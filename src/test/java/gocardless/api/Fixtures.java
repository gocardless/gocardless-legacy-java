package gocardless.api;

import static gocardless.utils.Utils.parse;

public interface Fixtures {

  public final static String MERCHANT_RESPONSE = "{\n" + 
  		"   \"created_at\": \"2011-11-18T17:07:09Z\",\n" + 
  		"   \"description\": null,\n" + 
  		"   \"id\": \"WOQRUJU9OH2HH1\",\n" + 
  		"   \"name\": \"Tom's Delicious Chicken Shop\",\n" + 
  		"   \"first_name\": \"Tom\",\n" + 
  		"   \"last_name\": \"Blomfield\",\n" + 
  		"   \"email\": \"tom@gocardless.com\",\n" + 
  		"   \"uri\": \"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1\",\n" + 
  		"   \"balance\": \"12.00\",\n" + 
  		"   \"pending_balance\": \"0.00\",\n" + 
  		"   \"next_payout_date\": \"2011-11-25T17: 07: 09Z\",\n" + 
  		"   \"next_payout_amount\": \"12.00\",\n" + 
  		"   \"sub_resource_uris\": {\n" + 
  		"      \"users\": \"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/users\",\n" + 
  		"      \"bills\": \"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills\",\n" + 
  		"      \"pre_authorizations\": \"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/pre_authorizations\",\n" + 
  		"      \"subscriptions\": \"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/subscriptions\"\n" + 
  		"   }\n" + 
  		"}";
  
  public final static Merchant MERCHANT = new Merchant.Builder()
    .createdAt(parse("2011-11-18T17:07:09Z"))
    .description(null)
    .id("WOQRUJU9OH2HH1")
    .name("Tom's Delicious Chicken Shop")
    .firstName("Tom")
    .lastName("Blomfield")
    .email("tom@gocardless.com")
    .uri("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1")
    .balance(12.00f)
    .pendingBalance(0.00f)
    .nextPayoutDate(parse("2011-11-25T17:07:09Z"))
    .nextPayoutAmount(12.00f)
    .subResourceUris(
        new Merchant.SubResourceUris.Builder()
          .users("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/users")
          .bills("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills")
          .preAuthorizations("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/pre_authorizations")
          .subscriptions("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/subscriptions")
          .build()
    )
    .build();
  
}
