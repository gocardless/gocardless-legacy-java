package gocardless.connect;

public interface Fixtures {

  public final static String NEW_BILL_URL =
    "https://gocardless.com/connect/bills/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&bill%5Bamount%5D=1000.0" +
    "&bill%5Bmerchant_id%5D=mer01" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&client_id=id01" +      
    "&signature=27c13ef219b44e519e66133ccc514353606a6b3c223dce01a314eddea4caf76b";
  
  public final static String NEW_SUBSCRIPTION_URL = 
    "https://gocardless.com/connect/subscriptions/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&subscription%5Binterval_unit%5D=month" +
    "&subscription%5Bamount%5D=15.0" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&subscription%5Binterval_length%5D=1" +
    "&client_id=id01" +    
    "&subscription%5Bmerchant_id%5D=mer01" +
    "&signature=6026be854689c533304fe29381e014774b7cc746c65d6d632852d9cfa25caddf";
  
  public final static String NEW_PRE_AUTHORIZATION_URL = 
    "https://gocardless.com/connect/pre_authorizations/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&pre_authorization%5Binterval_unit%5D=month" +
    "&pre_authorization%5Binterval_length%5D=1" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&pre_authorization%5Bmerchant_id%5D=mer01" +
    "&pre_authorization%5Bmax_amount%5D=15.0" +
    "&client_id=id01" +
    "&signature=eb46228f02b1bb2efddff55ac0e38614c2c562b7507779768abc0063d57dc1a4";
  
}
