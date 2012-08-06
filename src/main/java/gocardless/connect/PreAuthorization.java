package gocardless.connect;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PreAuthorization implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private BigDecimal maxAmount;
  
  private String merchantId;
  
  private Integer intervalLength;
  
  private String intervalUnit;

  private Date expiresAt;
  
  private String name;
  
  private String description;
  
  private Integer intervalCount;

  private Boolean calendarIntervals;
  
  private User user;
  
  public PreAuthorization() {    
  }
  
  public PreAuthorization(String merchantId, BigDecimal maxAmount, Integer intervalLength, String intervalUnit) {
    this.merchantId = merchantId;
    this.maxAmount = maxAmount;
    this.intervalLength = intervalLength;
    this.intervalUnit = intervalUnit;
  }

  public BigDecimal getMaxAmount() {
    return maxAmount;
  }

  public void setMaxAmount(BigDecimal maxAmount) {
    this.maxAmount = maxAmount;
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

  public Boolean getCalendarIntervals() {
    return calendarIntervals;
  }

  public void setCalendarIntervals(Boolean calendarIntervals) {
    this.calendarIntervals = calendarIntervals;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
