package gocardless.connect;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bill implements Serializable {

  private static final long serialVersionUID = 1L;

  private BigDecimal amount;
  
  private String merchantId;
  
  private String name;
  
  private String description;
  
  private User user;
  
  public Bill() {    
  }
  
  public Bill(String merchantId, BigDecimal amount) {
    this.merchantId = merchantId;
    this.amount = amount;    
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
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
