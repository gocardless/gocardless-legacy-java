package gocardless.partner;

import static gocardless.utils.JsonUtils.fromJson;
import static gocardless.utils.Utils.urlEncodedQueryPath;
import static java.lang.String.format;
import gocardless.AccountDetails;
import gocardless.GoCardless;
import gocardless.api.Merchant;
import gocardless.http.HttpClient;
import gocardless.utils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

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
  
  public String newMerchantUrl(String redirectUri, Merchant merchant, String state) {
    Map<String, String> params = params(redirectUri, state);
    params.put("response_type", "code");
    params.put("scope", "manage_merchant");
    if (merchant != null) {
      params.putAll(BeanUtils.recursiveDescribe(merchant));
    }
    return format("%s?%s", ApiPath.AUTHORIZE, urlEncodedQueryPath(params));
  }
  
  public MerchantAccessToken getMerchantAccessToken(String redirectUri, String code) {
    Map<String, String> params = params(redirectUri, null);
    params.put("code", code);
    params.put("grant_type", "authorization_code");
    String accessTokenUrl = format("%s?%s", ApiPath.ACCESS_TOKEN, urlEncodedQueryPath(params));
    return fromJson(httpClient.post(accessTokenUrl, headers(), null), MerchantAccessToken.class);
  }
  
  protected Map<String, String> headers() {
    Map<String, String> headers = new HashMap<String, String>();
    String basicAuth = Base64.encodeBase64String(format("%s:%s", accountDetails.getAppId(), accountDetails.getAppSecret()).getBytes());
    headers.put("Authorization", "Basic " + basicAuth);
    return headers;
  }
  
  protected Map<String, String> params(String redirectUri, String state) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("client_id", accountDetails.getAppId());
    if (redirectUri != null) {
      params.put("redirect_uri", redirectUri);
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
