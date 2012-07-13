package gocardless;

import gocardless.api.Api;

/**
 * GoCardless is the main interface to the GoCardless API.<p>
 *
 */
public class GoCardless {
  
  public final static AccountDetails accountDetails = new AccountDetails();
  
  public final static Api api = new Api(accountDetails); 
  
  public interface ApiBase {
    public static final String PRODUCTION = "https://gocardless.com";  
    public static final String SANDBOX = "https://sandbox.gocardless.com";
  }
  
  public enum Environment {PRODUCTION, SANDBOX};
  
  public static Environment environment = Environment.PRODUCTION;
  
  protected GoCardless() {
  }
  
  public static String getApiBase() {
    return (Environment.SANDBOX.equals(environment)) ? ApiBase.SANDBOX : ApiBase.PRODUCTION;
  }
  
}
