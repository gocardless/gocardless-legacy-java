package gocardless.partner;

import java.io.Serializable;

public class Merchant implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;
  
  private String billingAddress1;
  
  private String billingAddress2;
  
  private String billingTown;
  
  private String billingCounty;
  
  private String billingPostcode;
  
  private User user;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
    
}
