package gocardless.exception;

import static java.lang.String.format;

public class GoCardlessException extends RuntimeException {
  
  protected static final long serialVersionUID = 1L;
  
  public GoCardlessException(String msg) {
    super(msg);
  }
  
  public GoCardlessException(String msg, Throwable ex) {
    super(msg, ex);
  }
  
  public GoCardlessException(String url, int statusCode, String errorResponse) {    
    super(format("[url: %s, error code: %d, response: %s]", url, statusCode, errorResponse));    
  }

}
