package gocardless.exception;


public class SignatureException extends RuntimeException {
  
  protected static final long serialVersionUID = 1L;
  
  public SignatureException(String msg) {
    super(msg);
  }

}
