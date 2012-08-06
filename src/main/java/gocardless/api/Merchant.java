package gocardless.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Merchant implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Date createdAt;
  
  private String description;
  
  private String id;
  
  private String name;
  
  private String firstName;
  
  private String lastName;
  
  private String email;
  
  private String uri;
  
  private BigDecimal balance;
  
  private BigDecimal pendingBalance;
  
  private Date nextPayoutDate;
  
  private BigDecimal nextPayoutAmount;
  
  private SubResourceUris subResourceUris = new SubResourceUris();
  
  public static class SubResourceUris implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String users;
    private String bills;
    private String preAuthorizations;
    private String subscriptions;
    
    public String getUsers() {
      return users;
    }
    
    public void setUsers(String users) {
      this.users = users;
    }
    
    public String getBills() {
      return bills;
    }
    
    public void setBills(String bills) {
      this.bills = bills;
    }
    
    public String getPreAuthorizations() {
      return preAuthorizations;
    }
    
    public void setPreAuthorizations(String preAuthorizations) {
      this.preAuthorizations = preAuthorizations;
    }
    
    public String getSubscriptions() {
      return subscriptions;
    }
    
    public void setSubscriptions(String subscriptions) {
      this.subscriptions = subscriptions;
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

      private String users;
      private String bills;      
      private String preAuthorizations;
      private String subscriptions;
      
      public Builder users(String users) {
        this.users = users;
        return this;
      }

      public Builder bills(String bills) {
        this.bills = bills;
        return this;
      }
      
      public Builder preAuthorizations(String preAuthorizations) {
        this.preAuthorizations = preAuthorizations;
        return this;
      }
      
      public Builder subscriptions(String subscriptions) {
        this.subscriptions = subscriptions;
        return this;
      }

      public SubResourceUris build() {
        SubResourceUris subResourceUris = new SubResourceUris();
        subResourceUris.setBills(bills);
        subResourceUris.setUsers(users);
        subResourceUris.setPreAuthorizations(preAuthorizations);
        subResourceUris.setSubscriptions(subscriptions);
        return subResourceUris;
      }

    }
    
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getPendingBalance() {
    return pendingBalance;
  }

  public void setPendingBalance(BigDecimal pendingBalance) {
    this.pendingBalance = pendingBalance;
  }

  public Date getNextPayoutDate() {
    return nextPayoutDate;
  }

  public void setNextPayoutDate(Date nextPayoutDate) {
    this.nextPayoutDate = nextPayoutDate;
  }

  public BigDecimal getNextPayoutAmount() {
    return nextPayoutAmount;
  }

  public void setNextPayoutAmount(BigDecimal nextPayoutAmount) {
    this.nextPayoutAmount = nextPayoutAmount;
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

    private Date createdAt;
    private String description;
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String uri;
    private BigDecimal balance;
    private BigDecimal pendingBalance;
    private Date nextPayoutDate;
    private BigDecimal nextPayoutAmount;
    private SubResourceUris subResourceUris = new SubResourceUris();

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
    
    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }
    
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    
    public Builder email(String email) {
      this.email = email;
      return this;
    }
    
    public Builder uri(String uri) {
      this.uri = uri;
      return this;
    }
    
    public Builder balance(BigDecimal balance) {
      this.balance = balance;
      return this;
    }
    
    public Builder pendingBalance(BigDecimal pendingBalance) {
      this.pendingBalance = pendingBalance;
      return this;
    }
    
    public Builder nextPayoutDate(Date nextPayoutDate) {
      this.nextPayoutDate = nextPayoutDate;
      return this;
    }
    
    public Builder nextPayoutAmount(BigDecimal nextPayoutAmount) {
      this.nextPayoutAmount = nextPayoutAmount;
      return this;
    }
    
    public Builder subResourceUris(SubResourceUris subResourceUris) {
      this.subResourceUris = subResourceUris;
      return this;
    }

    public Merchant build() {
      Merchant merchant = new Merchant();
      merchant.createdAt = this.createdAt;
      merchant.description = this.description;
      merchant.id = this.id;
      merchant.name = this.name;
      merchant.firstName = this.firstName;
      merchant.lastName = this.lastName;
      merchant.email = this.email;
      merchant.uri = this.uri;
      merchant.balance = this.balance;
      merchant.pendingBalance = this.pendingBalance;
      merchant.nextPayoutDate = this.nextPayoutDate;
      merchant.nextPayoutAmount = this.nextPayoutAmount;
      merchant.subResourceUris = this.subResourceUris;
      return merchant;
    }

  }
  
}
