package gocardless.api;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Date createdAt;

  private String email;
  
  private String id;
  
  private String firstName;
  
  private String lastName;
  
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
    
    private String email;
    
    private String id;
    
    private String firstName;
    
    private String lastName;

    public Builder createdAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    
    public Builder email(String email) {
      this.email = email;
      return this;
    }
    
    public Builder id(String id) {
      this.id = id;
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

    public User build() {
      User user = new User();
      user.createdAt = this.createdAt;
      user.email = this.email;
      user.id = this.id;
      user.firstName = this.firstName;
      user.lastName = this.lastName;
      return user;
    }

  }
  
}
