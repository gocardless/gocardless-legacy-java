package gocardless;

/**
 * GoCardless.client is the main interface to the GoCardless API.<p>
 *
 */
public class GoCardless {
  
  public final static GoCardless client = new GoCardless();
  
  public interface API_BASE {
    public static final String PRODUCTION = "https://gocardless.com";  
    public static final String SANDBOX = "https://sandbox.gocardless.com";
  }
  
  protected enum Environment {PRODUCTION, SANDBOX};
  
  protected String apiBase;
  
  protected String appId;
  
  protected String appSecret;
  
  protected String accessToken;
  
  protected String merchantId;
  
  protected GoCardless() {
  }
  
  public GoCardless environment(Environment environment) {
    if (Environment.PRODUCTION.equals(environment)) {
      this.apiBase = API_BASE.PRODUCTION;
    } else if (Environment.SANDBOX.equals(environment)) {
      this.apiBase = API_BASE.SANDBOX;
    }
    return this;
  }
    
  public GoCardless appId(String appId) {
    this.appId = appId;
    return this;
  }
  
  public GoCardless appSecret(String appSecret) {
    this.appSecret = appSecret;
    return this;
  }
  
  public GoCardless accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
  
  public GoCardless merchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }
    
}
