package gocardless.signature;

import gocardless.exception.SignatureException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Based on https://gocardless.com/docs/signature_guide#examples
 */
public class ParameterSigner {
  
  public static final String CHARSET = "UTF-8";

  public static String signParams(Map<String, ? extends Object> params, String key) {
    try {
      Mac mac = Mac.getInstance("HmacSHA256");
      SecretKeySpec s = new SecretKeySpec(key.getBytes(), mac.getAlgorithm());
      mac.init(s);
      List<List<String>> flatParams = flattenParams(params, null);
      byte[] digest = mac.doFinal(normalizeParams(flatParams).getBytes());

      StringBuilder sb = new StringBuilder();
      for (byte b : digest) {
        sb.append(String.format("%02x", b));
      }

      return sb.toString();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
  
  /**
   * Note that params must include the key "signature"
   */
  public static void validateSignature(Map<String, ? extends Object> params, String key) {
    String signature = (String) params.remove("signature");
    if (!signParams(params, key).equals(signature)) {
      throw new SignatureException("Invalid signature");
    }
  }

  private static String percentEncode(String str) throws UnsupportedEncodingException {
    str = URLEncoder.encode(str, CHARSET);
    str = str.replaceAll("\\+", "%20");
    str = str.replaceAll("\\*", "%2A");
    return str.replaceAll("%7E", "~");
  }

  private static List<List<String>> flattenParams(Map<String, Object> params, String ns) {
    List<List<String>> flattenedList = new ArrayList<List<String>>();
    for (Map.Entry<String, Object> entry : params.entrySet()) {
      String entryNs = entry.getKey();
      if (ns != null) {
        entryNs = String.format("%s[%s]", ns, entry.getKey());
      }
      flattenedList.addAll(flattenParams(entry.getValue(), entryNs));
    }
    return flattenedList;
  }

  private static List<List<String>> flattenParams(List<Object> params, String ns) {
    List<List<String>> flattenedList = new ArrayList<List<String>>();
    ns = String.format("%s[]", ns);
    for (Object param : params) {
      flattenedList.addAll(flattenParams(param, ns));
    }
    return flattenedList;
  }

  @SuppressWarnings("unchecked")
  private static List<List<String>> flattenParams(Object param, String ns) {
    if (param instanceof List<?>) {
      return flattenParams((List<Object>) param, ns);
    }
    if (param instanceof Map<?, ?>) {
      return flattenParams((Map<String, Object>) param, ns);
    }

    List<String> pair = new ArrayList<String>();
    pair.addAll(Arrays.asList(ns, param.toString()));
    return new ArrayList<List<String>>(Arrays.asList(pair));
  }

  private static String normalizeParams(List<List<String>> pairs) throws UnsupportedEncodingException {
    Collections.sort(pairs, new Comparator<List<String>>() {
      public int compare(List<String> a, List<String> b) {
        int cmp = a.get(0).compareTo(b.get(0));
        return (cmp != 0 ? cmp : a.get(1).compareTo(b.get(1)));
      }
    });

    List<String> items = new ArrayList<String>();
    for (List<String> pair : pairs) {
      items.add(String.format("%s=%s", percentEncode(pair.get(0)), percentEncode(pair.get(1))));
    }

    StringBuilder sb = new StringBuilder(items.get(0));
    for (int i = 1; i < items.size(); i++) {
      sb.append("&");
      sb.append(items.get(i));
    }

    return sb.toString();
  }
}