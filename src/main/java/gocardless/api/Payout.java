package gocardless.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Payout implements Serializable {
  private static final long serialVersionUID = 1L;

  private BigDecimal amount;
  private String bankReference;
  private Date createdAt;
  private String id;
  private Date paidAt;
  private BigDecimal transactionFees;

  public BigDecimal getAmount() { return amount; }
  public void setAmount(BigDecimal amount) { this.amount = amount; }

  public String getBankReference() { return bankReference; }
  public void setBankReference(String bankReference) { this.bankReference = bankReference; }

  public Date getCreatedAt() { return createdAt; }
  public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public Date getPaidAt() { return paidAt; }
  public void setPaidAt(Date paidAt) { this.paidAt = paidAt; }

  public BigDecimal geTtransactionFees() { return transactionFees; }
  public void setTransactionFees(BigDecimal transactionFees) { this.transactionFees = transactionFees; }

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
    private String bankReference;
    private Date createdAt;
    private String id;
    private Date paidAt;
    private BigDecimal transactionFees;

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder bankReference(String bankReference) {
      this.bankReference = bankReference;
      return this;
    }

    public Builder createdAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder paidAt(Date paidAt) {
      this.paidAt = paidAt;
      return this;
    }

    public Builder transactionFees(BigDecimal transactionFees) {
      this.transactionFees = transactionFees;
      return this;
    }

    public Payout build() {
      Payout payout = new Payout();
      payout.amount = this.amount;
      payout.bankReference = this.bankReference;
      payout.createdAt = this.createdAt;
      payout.id = this.id;
      payout.paidAt = this.paidAt;
      payout.transactionFees = this.transactionFees;
      return payout;
    }
  }
}
