package gocardless.connect;

import java.io.Serializable;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private String name;
  
  private String firstName;
  
  private String lastName;
  
  private String email;
  
  private String billingAddress1;
  
  private String billingAddress2;
  
  private String billingTown;
  
  private String billingCounty;
  
  private String billingPostcode;
  
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
  
  public String getBillingAddress1() {
    return billingAddress1;
  }
  
  public void setBillingAddress1(String billingAddress1) {
    this.billingAddress1 = billingAddress1;
  }
  
  public String getBillingAddress2() {
    return billingAddress2;
  }
  
  public void setBillingAddress2(String billingAddress2) {
    this.billingAddress2 = billingAddress2;
  }
  
  public String getBillingTown() {
    return billingTown;
  }
  
  public void setBillingTown(String billingTown) {
    this.billingTown = billingTown;
  }
  
  public String getBillingCounty() {
    return billingCounty;
  }
  
  public void setBillingCounty(String billingCounty) {
    this.billingCounty = billingCounty;
  }
  
  public String getBillingPostcode() {
    return billingPostcode;
  }
  
  public void setBillingPostcode(String billingPostcode) {
    this.billingPostcode = billingPostcode;
  }
  
}
