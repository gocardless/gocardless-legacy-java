package gocardless.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class Utils {
  
  public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  
  public static final String CHARSET = "UTF-8";

  public static Date parse(String date) {
    try {
      return DateUtils.parseDate(date, new String[]{ISO_DATE_FORMAT});
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static String format(Date date) {
    return DateFormatUtils.format(date, ISO_DATE_FORMAT);    
  }
  
  public static String utc() {
    return DateFormatUtils.formatUTC(new Date(), ISO_DATE_FORMAT);    
  }
  
  /**
   * random base64-encoded string
   */
  public static String nonce() {
    return Base64.encodeBase64String(RandomStringUtils.randomAlphanumeric(40).getBytes());
  }
  
  public static String urlEncodedQueryPath(Map<?, ?> map) {
    try {
      StringBuilder sb = new StringBuilder();
      for (Map.Entry<?,?> entry : map.entrySet()) {
          if (sb.length() > 0) {
              sb.append("&");
          }
          sb.append(String.format("%s=%s",
              URLEncoder.encode(entry.getKey().toString(), CHARSET),
              URLEncoder.encode(entry.getValue().toString(), CHARSET)
          ));
      }
      return sb.toString();
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException(ex);
    }
  }
  
}
