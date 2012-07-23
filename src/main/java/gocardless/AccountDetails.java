package gocardless;

import java.io.Serializable;

public class AccountDetails implements Serializable {

  private static final long serialVersionUID = -1513521078617354480L;

  private String appId;
  
  private String appSecret;
  
  private String accessToken;
  
  private String merchantId;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }
  
  public static class Builder {

    private String appId;
    
    private String appSecret;
    
    private String accessToken;
    
    private String merchantId;

    public Builder appId(String appId) {
      this.appId = appId;
      return this;
    }
    
    public Builder appSecret(String appSecret) {
      this.appSecret = appSecret;
      return this;
    }
    
    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }
    
    public Builder merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
    }

    public AccountDetails build() {
      AccountDetails accountDetails = new AccountDetails();
      accountDetails.appId = this.appId;
      accountDetails.appSecret = this.appSecret;
      accountDetails.accessToken = this.accessToken;
      accountDetails.merchantId = this.merchantId;
      return accountDetails;
    }

  }
  
}
