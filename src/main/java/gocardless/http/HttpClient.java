package gocardless.http;

import static java.lang.String.format;
import gocardless.GoCardless;
import gocardless.exception.GoCardlessException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;

public class HttpClient {
  
  public final static HttpClient DEFAULT = new HttpClient();
  
  public static final String CHARSET = "UTF-8";
  
  public static final String CONTENT_TYPE = "application/json";
  
  public static final String USER_AGENT = format("gocardless-java/%s", GoCardless.VERSION);
  
  public static final Map<String, String> BASE_HEADERS = headers();
  
  protected enum RequestMethod {GET, POST, PUT};
  
  protected int connectTimeout = 30000; // 30 second default
  
  protected int readTimeout = 60000; // 60 second default

  public HttpClient() {
  }
  
  public String get(String url, Map<String, String> headers) {
    return request(RequestMethod.GET, url, headers, null);
  }
  
  public String post(String url, Map<String, String> headers, String payload) {
    return request(RequestMethod.POST, url, headers, payload);
  }
  
  public String put(String url, Map<String, String> headers, String payload) {
    return request(RequestMethod.PUT, url, headers, payload);
  }

  public static String url(String url, Map<String, String> params) {
    if (params == null || params.isEmpty()) {
      return url;
    }
    return format("%s?%s", url, createQuery(params));
  }
  
  public static Map<String, String> basicAuth(String username, String password) {
    String basicAuth = Base64.encodeBase64String(format("%s:%s", username, password).getBytes());
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", "Basic " + basicAuth);
    return headers;
  }
  
  public int getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public int getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(int readTimeout) {
    this.readTimeout = readTimeout;
  }

  protected String request(RequestMethod method, String url, Map<String, String> headers, String payload) {
    HttpsURLConnection conn = null;
    try {
      conn = createConnection(url);
      headers = (headers != null) ? headers : new HashMap<String, String>(); 
      for(Map.Entry<String, String> header: headers.entrySet()) {
        conn.setRequestProperty(header.getKey(), header.getValue());
      }
      if (method.equals(RequestMethod.GET)) {
        conn.setRequestMethod("GET");
      } else if (method.equals(RequestMethod.POST)) {
        conn.setRequestMethod("POST");
        writeOutput(conn, payload);
      } else if (method.equals(RequestMethod.PUT)) {
        conn.setRequestMethod("PUT");
        writeOutput(conn, payload);
      } else {
        throw new GoCardlessException(format("Unsupported Request Method [method: %s, url: %s]", method, url));
      }
      int statusCode = conn.getResponseCode(); //triggers the request
      if (statusCode < 200 || statusCode >= 300) {
        throw new GoCardlessException(url, statusCode, getResponse(conn.getErrorStream()));
      }    
      return getResponse(conn.getInputStream());
    } catch (IOException ex) {
      throw new GoCardlessException(format("Failed request [url: %s]", url), ex);
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
  }
  
  protected void writeOutput(URLConnection connection, String payload) throws IOException {
    if (payload != null) {
      connection.setDoOutput(true);
      OutputStream output = null;
      try {
           output = connection.getOutputStream();
           output.write(payload.getBytes(CHARSET));
      } finally {
        if (output != null) output.close();
      }
    }
  }

  /**
   * See http://stackoverflow.com/questions/309424/in-java-how-do-i-read-convert-an-inputstream-to-a-string
   */
  protected String getResponse(java.io.InputStream response) throws IOException {
    try {
      return new java.util.Scanner(response, CHARSET).useDelimiter("\\A").next();
    } finally {
      response.close();
    }
  }
  
  protected HttpsURLConnection createConnection(String url) throws IOException {
    HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
    conn.setConnectTimeout(connectTimeout);
    conn.setReadTimeout(readTimeout);
    conn.setUseCaches(false);
    for(Map.Entry<String, String> header: BASE_HEADERS.entrySet()) {
      conn.setRequestProperty(header.getKey(), header.getValue());
    }
    return conn;
  }
  
  protected static String createQuery(Map<String, String> params) {
    if (params == null) {
      return "";
    }
    try {
      StringBuffer query = new StringBuffer();
      for(Entry<String, String> entry: params.entrySet()) {
        if (query.length() > 0) {
          query.append("&");
        }
        String encodedKey = URLEncoder.encode(entry.getKey(), CHARSET);
        String encodedValue = URLEncoder.encode(entry.getValue(), CHARSET);
        query.append(String.format("%s=%s", encodedKey, encodedValue));
      }
      return query.toString();
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("Failed to encode params " + params.toString(), ex);
    }
  }
  
  protected static Map<String, String> headers() {
    Map<String, String> headers = new HashMap<String, String>();    
    headers.put("Accept", format("%s", CONTENT_TYPE));
    headers.put("Content-Type", format("%s;charset=%s", CONTENT_TYPE, CHARSET));
    headers.put("User-Agent", USER_AGENT);
    return headers;
  }
  
}
