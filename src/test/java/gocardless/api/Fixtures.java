package gocardless.api;

import static gocardless.utils.Utils.parseUTC;

import java.util.Arrays;
import java.util.List;

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
    .createdAt(parseUTC("2011-11-18T17:07:09Z"))
    .description(null)
    .id("WOQRUJU9OH2HH1")
    .name("Tom's Delicious Chicken Shop")
    .firstName("Tom")
    .lastName("Blomfield")
    .email("tom@gocardless.com")
    .uri("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1")
    .balance(12.00f)
    .pendingBalance(0.00f)
    .nextPayoutDate(parseUTC("2011-11-25T17:07:09Z"))
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
  
  public final static PreAuthorizedBill PRE_AUTHORIZED_BILL = new PreAuthorizedBill.Builder()
    .amount(10.00f)
    .preAuthorizationId("UQSTF7AMQMYWBL")
    .build();
  
  public final static String PRE_AUTHORIZED_BILL_POST = 
    "{" + 
		  "\"bill\":{" + 
		    "\"amount\":10.0," + 
		    "\"pre_authorization_id\":\"UQSTF7AMQMYWBL\"" + 
		  "}" + 
		"}";
  
  public final static String BILL_RESPONSE = 
    "{\n" + 
		"   \"amount\": \"10.00\",\n" + 
		"   \"gocardless_fees\": \"0.10\",\n" + 
		"   \"partner_fees\": \"0\",\n" + 
		"   \"currency\": \"GBP\",\n" + 
		"   \"created_at\": \"2011-11-22T11: 59: 12Z\",\n" + 
		"   \"description\": null,\n" + 
		"   \"id\": \"PWSDXRYSCOKA7Z\",\n" + 
		"   \"name\": null,\n" + 
		"   \"status\": \"pending\",\n" + 
		"   \"merchant_id\": \"6UFY9IJWGYBTAP\",\n" + 
		"   \"user_id\": \"BWJ2GP659OXPAU\",\n" + 
		"   \"paid_at\": null,\n" + 
		"   \"source_type\": \"pre_authorization\",\n" + 
		"   \"source_id\": \"FAZ6FGSMTCOZUG\",\n" + 
		"   \"uri\": \"https://gocardless.com/api/v1/bills/PWSDXRYSCOKA7Z\"\n" + 
		"}";
  
  public final static Bill BILL = new Bill.Builder()
    .amount(10.00f)
    .gocardlessFees(0.10f)
    .partnerFees(0.00f)
    .currency("GBP")
    .createdAt(parseUTC("2011-11-22T11:59:12Z"))
    .description(null)
    .id("PWSDXRYSCOKA7Z")
    .name(null)
    .status("pending")
    .merchantId("6UFY9IJWGYBTAP")
    .userId("BWJ2GP659OXPAU")
    .paidAt(null)
    .sourceType("pre_authorization")
    .sourceId("FAZ6FGSMTCOZUG")
    .uri("https://gocardless.com/api/v1/bills/PWSDXRYSCOKA7Z")
    .build();
  
  public final static String BILLS_RESPONSE = "[" + BILL_RESPONSE + "," + BILL_RESPONSE + "]";
  
  public final static List<Bill> BILLS = Arrays.asList(BILL, BILL);
  
  public final static String BILLS_FILTER =
    "after=2011-11-23T09%3A00%3A00Z" +
    "&subscription_id=test_subscriptiod_id" +
    "&paid=false" +
    "&before=2011-11-22T09%3A00%3A00Z" +
    "&source_id=FAZ6FGSMTCOZUG" +
    "&pre_authorization_id=test_pre_authorized_id" +
    "&user_id=BWJ2GP659OXPAU";

  public final static String SUBSCRIPTION_RESPONSE =
    "{\n" +
		"   \"amount\":\"44.0\",\n" +
		"   \"interval_length\":1,\n" +
		"   \"interval_unit\":\"month\",\n" +
		"   \"created_at\":\"2011-09-12T13:51:30Z\",\n" +
		"   \"currency\":\"GBP\",\n" +
		"   \"name\":\"London Gym Membership\",\n" +
		"   \"description\":\"Entitles you to use all of the gyms around London\",\n" +
		"   \"expires_at\":null,\n" +
		"   \"next_interval_start\":\"2011-10-12T13:51:30Z\",\n" +
		"   \"id\": \"AJKH638A99\",\n" +
		"   \"merchant_id\":\"WOQRUJU9OH2HH1\",\n" +
		"   \"status\":\"active\",\n" +
		"   \"user_id\":\"HJEH638AJD\",\n" +
		"   \"uri\":\"https://gocardless.com/api/v1/subscriptions/1580\",\n" +
		"   \"sub_resource_uris\":{\n" +
		"      \"bills\":\"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills?source_id=1580\"\n" +
		"   }\n" +
		"}";
  
  public final static Subscription SUBSCRIPTION = new Subscription.Builder()
    .amount(44.00f)
    .intervalLength(1)
    .intervalUnit("month")
    .createdAt(parseUTC("2011-09-12T13:51:30Z"))
    .currency("GBP")
    .name("London Gym Membership")
    .description("Entitles you to use all of the gyms around London")
    .expiresAt(null)
    .nextIntervalStart(parseUTC("2011-10-12T13:51:30Z"))
    .id("AJKH638A99")
    .merchantId("WOQRUJU9OH2HH1")
    .status("active")
    .userId("HJEH638AJD")
    .uri("https://gocardless.com/api/v1/subscriptions/1580")
    .subResourceUris(
        new Subscription.SubResourceUris.Builder()
          .bills("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills?source_id=1580")
          .build()
    )
    .build();
  
  public final static String PRE_AUTHORIZATION_RESPONSE =
    "{\n" +
    "   \"created_at\":\"2011-02-18T15:25:58Z\",\n" +
    "   \"currency\":\"GBP\",\n" +
    "   \"name\":\"Variable Payments For Tennis Court Rental\",\n" +
    "   \"description\":\"You will be charged according to your monthly usage of the tennis courts\",\n" +
    "   \"expires_at\":null,\n" +
    "   \"id\": \"1234JKH8KLJ\",\n" +
    "   \"interval_length\":1,\n" +
    "   \"interval_unit\":\"month\",\n" +
    "   \"merchant_id\": \"WOQRUJU9OH2HH1\",\n" +
    "   \"status\":\"active\",\n" +
    "   \"remaining_amount\": \"65.0\",\n" +
    "   \"next_interval_start\": \"2012-02-20T00:00:00Z\",\n" +
    "   \"user_id\": \"834JUH8KLJ\",\n" +
    "   \"max_amount\":\"70.0\",\n" +
    "   \"uri\":\"https://gocardless.com/api/v1/pre_authorizations/1609\",\n" +
    "   \"sub_resource_uris\":{\n" +
    "      \"bills\":\"https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills?source_id=1609\"\n" +
    "   }\n" +
    "}";

  public final static PreAuthorization PRE_AUTHORIZATION = new PreAuthorization.Builder()
    .maxAmount(70.00f)
    .intervalLength(1)
    .intervalUnit("month")
    .createdAt(parseUTC("2011-02-18T15:25:58Z"))
    .currency("GBP")
    .name("Variable Payments For Tennis Court Rental")
    .description("You will be charged according to your monthly usage of the tennis courts")
    .expiresAt(null)
    .nextIntervalStart(parseUTC("2012-02-20T00:00:00Z"))
    .id("1234JKH8KLJ")
    .merchantId("WOQRUJU9OH2HH1")
    .status("active")
    .remainingAmount(65.0f)
    .userId("834JUH8KLJ")
    .uri("https://gocardless.com/api/v1/pre_authorizations/1609")
    .subResourceUris(
        new PreAuthorization.SubResourceUris.Builder()
          .bills("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills?source_id=1609")
          .build()
    )
    .build();

}
