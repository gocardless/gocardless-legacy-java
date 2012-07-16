package gocardless.partner;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class MerchantAccessToken implements Serializable {

  private static final long serialVersionUID = 1L;

  private String accessToken;
  
  private String tokenType;
  
  private String scope;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }
  
  public String getMerchantId() {
    String scopePrefix = "manage_merchant:";
    if (scope != null && scope.length() > scopePrefix.length() && scope.startsWith(scopePrefix)) {      
      return scope.substring(scopePrefix.length());
    }
    return null;
  }
  
  @Override
  public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
  }
  
  public static class Builder {

    private String accessToken;
    
    private String tokenType;
    
    private String scope;

    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }
    
    public Builder tokenType(String tokenType) {
      this.tokenType = tokenType;
      return this;
    }
    
    public Builder scope(String scope) {
      this.scope = scope;
      return this;
    }

    public MerchantAccessToken build() {
      MerchantAccessToken merchantAccessToken = new MerchantAccessToken();
      merchantAccessToken.accessToken = this.accessToken;
      merchantAccessToken.tokenType = this.tokenType;
      merchantAccessToken.scope = this.scope;
      return merchantAccessToken;
    }

  }
    
}
