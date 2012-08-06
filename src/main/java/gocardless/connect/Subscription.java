package gocardless.connect;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Subscription implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private BigDecimal amount;
  
  private String merchantId;
  
  private Integer intervalLength;
  
  private String intervalUnit;

  private Date startAt;
  
  private Date expiresAt;
  
  private String name;
  
  private String description;
  
  private Integer intervalCount;
  
  private User user;
  
  public Subscription() {    
  }
  
  public Subscription(String merchantId, BigDecimal amount, Integer intervalLength, String intervalUnit) {
    this.merchantId = merchantId;
    this.amount = amount;
    this.intervalLength = intervalLength;
    this.intervalUnit = intervalUnit;
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

  public Integer getIntervalLength() {
    return intervalLength;
  }

  public void setIntervalLength(Integer intervalLength) {
    this.intervalLength = intervalLength;
  }

  public String getIntervalUnit() {
    return intervalUnit;
  }

  public void setIntervalUnit(String intervalUnit) {
    this.intervalUnit = intervalUnit;
  }

  public Date getStartAt() {
    return startAt;
  }

  public void setStartAt(Date startAt) {
    this.startAt = startAt;
  }

  public Date getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(Date expiresAt) {
    this.expiresAt = expiresAt;
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

  public Integer getIntervalCount() {
    return intervalCount;
  }

  public void setIntervalCount(Integer intervalCount) {
    this.intervalCount = intervalCount;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
