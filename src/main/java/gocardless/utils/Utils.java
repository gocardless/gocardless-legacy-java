package gocardless.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

public class Utils {
  
  public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  
  public static final DateFormat ISO_DATE_FORMATTER = new SimpleDateFormat(ISO_DATE_FORMAT);
  
  public static final String CHARSET = "UTF-8";
  
  static {
    ISO_DATE_FORMATTER.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  public static Date parseUTC(String date) {
    try {      
      return ISO_DATE_FORMATTER.parse(date);
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static String formatUTC(Date date) {
    return DateFormatUtils.formatUTC(date, ISO_DATE_FORMAT);    
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
  
}
