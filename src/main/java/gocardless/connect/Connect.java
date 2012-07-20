package gocardless.connect;

import static gocardless.signature.ParameterSigner.signParams;
import static gocardless.utils.Utils.nonce;
import static gocardless.utils.Utils.urlEncodedQueryPath;
import static gocardless.utils.Utils.utc;
import static java.lang.String.format;
import gocardless.AccountDetails;
import gocardless.GoCardless;
import gocardless.utils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

public class Connect {
  
  public interface ApiPath {
    public static final String BASE = format("%s/connect", GoCardless.getApiBase());  
    public static final String NEW_BILL = format("%s/bills/new", BASE);
    public static final String NEW_SUBSCRIPTION = format("%s/subscriptions/new", BASE);
    public static final String NEW_PRE_AUTHORIZATION = format("%s/pre_authorizations/new", BASE);
  }
  
  protected AccountDetails accountDetails;

  public Connect(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }
  
  public String newBillUrl(Bill bill, String redirectUri, String cancelUri, String state) {
    return this.newUrl(bill, ApiPath.NEW_BILL, redirectUri, cancelUri, state);    
  }
  
  public String newSubscriptionUrl(Subscription subscription, String redirectUri, String cancelUri, String state) {
    return this.newUrl(subscription, ApiPath.NEW_SUBSCRIPTION, redirectUri, cancelUri, state);    
  }
  
  public String newPreAuthorizationUrl(PreAuthorization preAuthorization, String redirectUri, String cancelUri, String state) {
    return this.newUrl(preAuthorization, ApiPath.NEW_PRE_AUTHORIZATION, redirectUri, cancelUri, state);    
  }
  
  /**
   * Note that this method automatically includes the nonce, timestamp and signature.
   */  
  protected String newUrl(Object resource, String apiPath, String redirectUri, String cancelUri, String state) {
    Map<String, String> params = params(redirectUri, cancelUri, state);
    params.putAll(BeanUtils.recursiveDescribe(resource));
    String signature = signParams(params, accountDetails.getAppSecret());
    params.put("signature", signature);
    return format("%s?%s", apiPath, urlEncodedQueryPath(params));
  }
  
  protected Map<String, String> params(String redirectUri, String cancelUri, String state) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("client_id", accountDetails.getAppId());
    params.put("nonce", nonce());
    params.put("timestamp", utc());    
    if (redirectUri != null) {
      params.put("redirect_uri", redirectUri);
    }
    if (cancelUri != null) {
      params.put("cancel_uri", cancelUri);
    }
    if (state != null) {
      params.put("state", state);
    }    
    return params;
  }
  
}
