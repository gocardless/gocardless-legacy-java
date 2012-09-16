package gocardless.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Bill implements Serializable {

  private static final long serialVersionUID = 1L;

  private BigDecimal amount;
  
  private BigDecimal gocardlessFees;
  
  private BigDecimal partnerFees;
  
  private String currency;
  
  private Date createdAt;
  
  private String description;
  
  private String id;
  
  private String name;
  
  private Date paidAt;
  
  private String status;
  
  private String merchantId;
  
  private String userId;
  
  private String sourceType;
  
  private String sourceId;
  
  private URI uri;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getGocardlessFees() {
    return gocardlessFees;
  }

  public void setGocardlessFees(BigDecimal gocardlessFees) {
    this.gocardlessFees = gocardlessFees;
  }

  public BigDecimal getPartnerFees() {
    return partnerFees;
  }

  public void setPartnerFees(BigDecimal partnerFees) {
    this.partnerFees = partnerFees;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPaidAt() {
    return paidAt;
  }

  public void setPaidAt(Date paidAt) {
    this.paidAt = paidAt;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getSourceType() {
    return sourceType;
  }

  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  public String getSourceId() {
    return sourceId;
  }

  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  public URI getUri() {
    return uri;
  }

  public void setUri(String uriStr) throws URISyntaxException {
    setUri(new URI(uriStr));
  }

  public void setUri(URI uri) {
    this.uri = uri;
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
    
    private BigDecimal gocardlessFees;
    
    private BigDecimal partnerFees;
    
    private String currency;
    
    private Date createdAt;
    
    private String description;
    
    private String id;
    
    private String name;
    
    private Date paidAt;
    
    private String status;
    
    private String merchantId;
    
    private String userId;
    
    private String sourceType;
    
    private String sourceId;
    
    private URI uri;

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }
    
    public Builder gocardlessFees(BigDecimal gocardlessFees) {
      this.gocardlessFees = gocardlessFees;
      return this;
    }
    
    public Builder partnerFees(BigDecimal partnerFees) {
      this.partnerFees = partnerFees;
      return this;
    }
    
    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }
    
    public Builder createdAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    
    public Builder description(String description) {
      this.description = description;
      return this;
    }
    
    public Builder id(String id) {
      this.id = id;
      return this;
    }
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder paidAt(Date paidAt) {
      this.paidAt = paidAt;
      return this;
    }
    
    public Builder status(String status) {
      this.status = status;
      return this;
    }
    
    public Builder merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
    }
    
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
    
    public Builder sourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }
    
    public Builder sourceId(String sourceId) {
      this.sourceId = sourceId;
      return this;
    }

    public Builder uri(String uriStr) throws URISyntaxException {
      return uri(new URI(uriStr));
    }
    
    public Builder uri(URI uri) {
      this.uri = uri;
      return this;
    }

    public Bill build() {
      Bill bill = new Bill();
      bill.amount = this.amount;      
      bill.gocardlessFees = this.gocardlessFees;      
      bill.partnerFees = this.partnerFees;
      bill.currency = this.currency;
      bill.createdAt = this.createdAt;
      bill.description = this.description;
      bill.id = this.id;
      bill.name = this.name;
      bill.paidAt = this.paidAt;
      bill.status = this.status;
      bill.merchantId = this.merchantId;  
      bill.userId = this.userId;
      bill.sourceType = this.sourceType;  
      bill.sourceId = this.sourceId;
      bill.uri = this.uri;
      return bill;
    }

  }

}
