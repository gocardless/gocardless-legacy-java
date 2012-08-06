package gocardless;

import gocardless.api.Api;
import gocardless.connect.Connect;
import gocardless.partner.Partner;
import gocardless.webhook.WebHook;

/**
 * GoCardless is the main interface to the GoCardless API.<p>
 *
 */
public class GoCardless {
  
  public final static String VERSION = "1.0.1";
  
  public final static AccountDetails accountDetails = new AccountDetails();
  
  public final static Api api = new Api(accountDetails);
  
  public final static Connect connect = new Connect(accountDetails);
  
  public final static Partner partner = new Partner(accountDetails);
  
  public final static WebHook webHook = new WebHook(accountDetails);
  
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
