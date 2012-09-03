package gocardless.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Subscription implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private BigDecimal amount;
  
  private Integer intervalLength;
  
  private String intervalUnit;
  
  private Date createdAt;
  
  private String currency;
  
  private String name;
  
  private String description;
  
  private Date expiresAt;
  
  private Date nextIntervalStart;
  
  private String id;
  
  private String merchantId;
  
  private String status;
  
  private String userId;
  
  private URI uri;
  
  private SubResourceUris subResourceUris = new SubResourceUris();
  
  public static class SubResourceUris implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String bills;
    
    public String getBills() {
      return bills;
    }
    
    public void setBills(String bills) {
      this.bills = bills;
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

      private String bills;      
      
      public Builder bills(String bills) {
        this.bills = bills;
        return this;
      }

      public SubResourceUris build() {
        SubResourceUris subResourceUris = new SubResourceUris();
        subResourceUris.bills = this.bills;
        return subResourceUris;
      }

    }
    
  }
  
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
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

  public Date getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(Date expiresAt) {
    this.expiresAt = expiresAt;
  }

  public Date getNextIntervalStart() {
    return nextIntervalStart;
  }

  public void setNextIntervalStart(Date nextIntervalStart) {
    this.nextIntervalStart = nextIntervalStart;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public URI getUri() {
    return uri;
  }

  public void setUri(URI uri) {
    this.uri = uri;
  }

  public SubResourceUris getSubResourceUris() {
    return subResourceUris;
  }

  public void setSubResourceUris(SubResourceUris subResourceUris) {
    this.subResourceUris = subResourceUris;
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
    
    private BigDecimal amount;
    
    private Integer intervalLength;
    
    private String intervalUnit;
    
    private Date createdAt;
    
    private String currency;
    
    private String name;
    
    private String description;
    
    private Date expiresAt;
    
    private Date nextIntervalStart;
    
    private String id;
    
    private String merchantId;
    
    private String status;
    
    private String userId;
    
    private URI uri;

    private SubResourceUris subResourceUris = new SubResourceUris();

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }
    
    public Builder intervalLength(Integer intervalLength) {
      this.intervalLength = intervalLength;
      return this;
    }
    
    public Builder intervalUnit(String intervalUnit) {
      this.intervalUnit = intervalUnit;
      return this;
    }
    
    public Builder createdAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    
    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder description(String description) {
      this.description = description;
      return this;
    }
    
    public Builder expiresAt(Date expiresAt) {
      this.expiresAt = expiresAt;
      return this;
    }
    
    public Builder nextIntervalStart(Date nextIntervalStart) {
      this.nextIntervalStart = nextIntervalStart;
      return this;
    }
    
    public Builder id(String id) {
      this.id = id;
      return this;
    }
    
    public Builder merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
    }
    
    public Builder status(String status) {
      this.status = status;
      return this;
    }
    
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
    
    public Builder uri(URI uri) {
      this.uri = uri;
      return this;
    }
    
    public Builder subResourceUris(SubResourceUris subResourceUris) {
      this.subResourceUris = subResourceUris;
      return this;
    }

    public Subscription build() {
      Subscription subscription = new Subscription();
      subscription.amount = this.amount;
      subscription.intervalLength = this.intervalLength;
      subscription.intervalUnit = this.intervalUnit;
      subscription.createdAt = this.createdAt;
      subscription.currency = this.currency;
      subscription.name = this.name;
      subscription.description = this.description;
      subscription.expiresAt = this.expiresAt;
      subscription.nextIntervalStart = this.nextIntervalStart;
      subscription.id = this.id;
      subscription.merchantId = this.merchantId;
      subscription.status = this.status;
      subscription.userId = this.userId;
      subscription.uri = this.uri;
      subscription.subResourceUris = this.subResourceUris;
      return subscription;
    }

  }
  
}
