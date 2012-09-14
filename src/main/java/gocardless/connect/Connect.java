package gocardless.connect;

import static gocardless.http.HttpClient.basicAuth;
import static gocardless.http.HttpClient.url;
import static gocardless.signature.ParameterSigner.signParams;
import static gocardless.signature.ParameterSigner.validateSignature;
import static gocardless.utils.Utils.nonce;
import static gocardless.utils.Utils.utc;
import static java.lang.String.format;
import gocardless.AccountDetails;
import gocardless.GoCardless;
import gocardless.exception.SignatureException;
import gocardless.http.HttpClient;
import gocardless.utils.BeanUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Connect {
  
  public interface ApiPath {
    public static final String BASE = format("%s/connect", GoCardless.getApiBase());  
    public static final String NEW_BILL = format("%s/bills/new", BASE);
    public static final String NEW_SUBSCRIPTION = format("%s/subscriptions/new", BASE);
    public static final String NEW_PRE_AUTHORIZATION = format("%s/pre_authorizations/new", BASE);
    public static final String CONFIRM = format("%s%s/confirm", GoCardless.getApiBase(), GoCardless.API_PATH);
  }
  
  protected HttpClient httpClient = HttpClient.DEFAULT;
  
  protected AccountDetails accountDetails;

  public Connect(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }
  
  public String newBillUrl(Bill bill, URI redirectUri, URI cancelUri, String state) {
    return this.newUrl(bill, ApiPath.NEW_BILL, redirectUri, cancelUri, state);    
  }
  
  public String newSubscriptionUrl(Subscription subscription, URI redirectUri, URI cancelUri, String state) {
    return this.newUrl(subscription, ApiPath.NEW_SUBSCRIPTION, redirectUri, cancelUri, state);    
  }
  
  public String newPreAuthorizationUrl(PreAuthorization preAuthorization, URI redirectUri, URI cancelUri, String state) {
    return this.newUrl(preAuthorization, ApiPath.NEW_PRE_AUTHORIZATION, redirectUri, cancelUri, state);    
  }
  
  public void confirm(Resource resource) throws SignatureException {
    validateSignature(BeanUtils.recursiveDescribe(resource, false), accountDetails.getAppSecret());
    String payload = String.format("{\"%s\":\"%s\", \"%s\":\"%s\"}", 
        Resource.Params.RESOURCE_ID, resource.getResourceId(),
        Resource.Params.RESOURCE_TYPE, resource.getResourceType());
    Map<String, String> headers = basicAuth(accountDetails.getAppId(), accountDetails.getAppSecret());
    httpClient.post(ApiPath.CONFIRM, headers, payload);
  }
  
  /**
   * Note that this method automatically includes the nonce, timestamp and signature.
   */  
  protected String newUrl(Object resource, String apiPath, URI redirectUri, URI cancelUri, String state) {
    Map<String, String> params = params(redirectUri, cancelUri, state);
    params.putAll(BeanUtils.recursiveDescribe(resource));
    String signature = signParams(params, accountDetails.getAppSecret());
    params.put("signature", signature);
    return url(apiPath, params);
  }
  
  protected Map<String, String> params(URI redirectUri, URI cancelUri, String state) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("client_id", accountDetails.getAppId());
    params.put("nonce", nonce());
    params.put("timestamp", utc());    
    if (redirectUri != null) {
      params.put("redirect_uri", redirectUri.toString());
    }
    if (cancelUri != null) {
      params.put("cancel_uri", cancelUri.toString());
    }
    if (state != null) {
      params.put("state", state);
    }    
    return params;
  }
  
  protected void setHttpClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }
  
}
