package gocardless.partner;

import static gocardless.http.HttpClient.basicAuth;
import static gocardless.http.HttpClient.url;
import static gocardless.utils.JsonUtils.fromJson;
import static java.lang.String.format;
import gocardless.AccountDetails;
import gocardless.GoCardless;
import gocardless.http.HttpClient;
import gocardless.utils.BeanUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Partner {
  
  public interface ApiPath {
    public static final String AUTHORIZE = format("%s/oauth/authorize", GoCardless.getApiBase());  
    public static final String ACCESS_TOKEN = format("%s/oauth/access_token", GoCardless.getApiBase());
  }
  
  protected HttpClient httpClient = HttpClient.DEFAULT;
  
  protected AccountDetails accountDetails;

  public Partner(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }
  
  public String newMerchantUrl(URI redirectUri, Merchant merchant, String state) {
    Map<String, String> params = params(redirectUri, state);
    params.put("response_type", "code");
    params.put("scope", "manage_merchant");
    if (merchant != null) {
      params.putAll(BeanUtils.recursiveDescribe(merchant));
    }
    return url(ApiPath.AUTHORIZE, params);
  }
  
  public MerchantAccessToken getMerchantAccessToken(URI redirectUri, String code) {
    Map<String, String> params = params(redirectUri, null);
    params.put("code", code);
    params.put("grant_type", "authorization_code");
    Map<String, String> headers = basicAuth(accountDetails.getAppId(), accountDetails.getAppSecret());
    return fromJson(httpClient.post(url(ApiPath.ACCESS_TOKEN, params), headers, null), MerchantAccessToken.class);
  }
  
  protected Map<String, String> params(URI redirectUri, String state) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("client_id", accountDetails.getAppId());
    if (redirectUri != null) {
      params.put("redirect_uri", redirectUri.toString());
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
