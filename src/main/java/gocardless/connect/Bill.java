package gocardless.connect;

import java.io.Serializable;

public class Bill implements Serializable {

  private static final long serialVersionUID = 1L;

  private Float amount;
  
  private String merchantId;
  
  private String name;
  
  private String description;
  
  private User user;
  
  public Bill() {    
  }
  
  public Bill(Float amount, String merchantId) {
    this.amount = amount;
    this.merchantId = merchantId;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
    
}
