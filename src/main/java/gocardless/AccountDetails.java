package gocardless;

public class AccountDetails {

  protected String appId;
  
  protected String appSecret;
  
  protected String accessToken;
  
  protected String merchantId;
  
  public AccountDetails appId(String appId) {
    this.appId = appId;
    return this;
  }
  
  public AccountDetails appSecret(String appSecret) {
    this.appSecret = appSecret;
    return this;
  }
  
  public AccountDetails accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
  
  public AccountDetails merchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  public String getAppId() {
    return appId;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getMerchantId() {
    return merchantId;
  }
  
}
