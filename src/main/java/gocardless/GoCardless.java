package gocardless;

/**
 * GoCardless is the main interface to the GoCardless API.<p>
 *
 */
public class GoCardless {
  
  // TODO Move to a config class?
  public static boolean SANDBOX = false;

  public interface API_BASE {
    public static final String PRODUCTION = "https://gocardless.com";  
    public static final String SANDBOX = "https://sandbox.gocardless.com";
  }
  
  protected String apiBase;
  
  public GoCardless() {
    this.apiBase = (SANDBOX) ? API_BASE.SANDBOX : API_BASE.PRODUCTION;
  }

}
