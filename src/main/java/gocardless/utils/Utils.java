package gocardless.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class Utils {
  
  public static Date parse(String date) {
    try {
      return DateUtils.parseDate(date, new String[]{"yyyy-MM-dd'T'HH:mm:ss'Z'"});
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
}
