package gocardless.api;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static gocardless.utils.Utils.parseUTC;

public interface Fixtures {

  String MERCHANT_RESPONSE = "{\n" +
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

  Merchant MERCHANT = new Merchant.Builder()
    .createdAt(parseUTC("2011-11-18T17:07:09Z"))
    .description(null)
    .id("WOQRUJU9OH2HH1")
    .name("Tom's Delicious Chicken Shop")
    .firstName("Tom")
    .lastName("Blomfield")
    .email("tom@gocardless.com")
    .uri(URI.create("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1"))
    .balance(new BigDecimal("12.00"))
    .pendingBalance(new BigDecimal("0.00"))
    .nextPayoutDate(parseUTC("2011-11-25T17:07:09Z"))
    .nextPayoutAmount(new BigDecimal("12.00"))
    .subResourceUris(
        new Merchant.SubResourceUris.Builder()
          .users("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/users")
          .bills("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills")
          .preAuthorizations("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/pre_authorizations")
          .subscriptions("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/subscriptions")
          .build()
    )
    .build();

  String MERCHANT_USERS_RESPONSE =
    "[\n" +
		"   {\n" +
		"      \"created_at\":\"2011-11-18T17:06:15Z\",\n" +
		"      \"email\":\"customer40@gocardless.com\",\n" +
		"      \"id\": \"JKH8HGKL9H\",\n" +
		"      \"first_name\":\"Frank\",\n" +
		"      \"last_name\":\"Smith\"\n" +
		"   },\n" +
		"   {\n" +
		"      \"created_at\":\"2011-11-19T14:16:15Z\",\n" +
		"      \"email\":\"customer41@gocardless.com\",\n" +
		"      \"id\":\"JKH8HGKL9I\",\n" +
		"      \"first_name\":\"James\",\n" +
		"      \"last_name\":\"Dean\"\n" +
		"   }\n" +
		"]";

  List<User> MERCHANT_USERS = Arrays.asList(
    new User.Builder()
      .createdAt(parseUTC("2011-11-18T17:06:15Z"))
      .email("customer40@gocardless.com")
      .id("JKH8HGKL9H")
      .firstName("Frank")
      .lastName("Smith")
      .build(),
    new User.Builder()
      .createdAt(parseUTC("2011-11-19T14:16:15Z"))
      .email("customer41@gocardless.com")
      .id("JKH8HGKL9I")
      .firstName("James")
      .lastName("Dean")
      .build()
  );

  String BILL_RESPONSE =
    "{\n" +
		"   \"amount\": \"10.00\",\n" +
		"   \"gocardless_fees\": \"0.10\",\n" +
		"   \"partner_fees\": \"0\",\n" +
		"   \"currency\": \"GBP\",\n" +
        "   \"charge_customer_at\": \"2013-12-25\",\n" +
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

  Bill BILL = new Bill.Builder()
    .amount(new BigDecimal("10.00"))
    .gocardlessFees(new BigDecimal("0.10"))
    .partnerFees(new BigDecimal("0"))
    .currency("GBP")
    .chargeCustomerAt(new GregorianCalendar(2013, 11, 25).getTime())
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
    .uri(URI.create("https://gocardless.com/api/v1/bills/PWSDXRYSCOKA7Z"))
    .build();

  String BILLS_RESPONSE = "[" + BILL_RESPONSE + "," + BILL_RESPONSE + "]";

   List<Bill> BILLS = Arrays.asList(BILL, BILL);

  String BILLS_FILTER =
    "after=2011-11-23T09%3A00%3A00Z" +
    "&subscription_id=test_subscriptiod_id" +
    "&paid=false" +
    "&before=2011-11-22T09%3A00%3A00Z" +
    "&source_id=FAZ6FGSMTCOZUG" +
    "&pre_authorization_id=test_pre_authorized_id" +
    "&user_id=BWJ2GP659OXPAU";

  String SUBSCRIPTION_RESPONSE =
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

  Subscription SUBSCRIPTION = new Subscription.Builder()
    .amount(new BigDecimal("44.0"))
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
    .uri(URI.create("https://gocardless.com/api/v1/subscriptions/1580"))
    .subResourceUris(
        new Subscription.SubResourceUris.Builder()
          .bills("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills?source_id=1580")
          .build()
    )
    .build();

  String SUBSCRIPTIONS_RESPONSE = "[" + SUBSCRIPTION_RESPONSE + "," + SUBSCRIPTION_RESPONSE + "]";

  List<Subscription> SUBSCRIPTIONS = Arrays.asList(SUBSCRIPTION, SUBSCRIPTION);

  String SUBSCRIPTIONS_FILTER =
    "after=2011-09-12T09%3A00%3A00Z" +
    "&before=2011-09-13T09%3A00%3A00Z" +
    "&user_id=HJEH638AJD";

  String PRE_AUTHORIZATION_RESPONSE =
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

  PreAuthorization PRE_AUTHORIZATION = new PreAuthorization.Builder()
    .maxAmount(new BigDecimal("70.0"))
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
    .remainingAmount(new BigDecimal("65.0"))
    .userId("834JUH8KLJ")
    .uri(URI.create("https://gocardless.com/api/v1/pre_authorizations/1609"))
    .subResourceUris(
        new PreAuthorization.SubResourceUris.Builder()
          .bills("https://gocardless.com/api/v1/merchants/WOQRUJU9OH2HH1/bills?source_id=1609")
          .build()
    )
    .build();

  String PRE_AUTHORIZATIONS_RESPONSE = "[" + PRE_AUTHORIZATION_RESPONSE + "," + PRE_AUTHORIZATION_RESPONSE + "]";

  List<PreAuthorization> PRE_AUTHORIZATIONS = Arrays.asList(PRE_AUTHORIZATION, PRE_AUTHORIZATION);

  String PRE_AUTHORIZATIONS_FILTER =
    "after=2011-02-18T09%3A00%3A00Z" +
    "&before=2011-02-19T09%3A00%3A00Z" +
    "&user_id=834JUH8KLJ";

  PreAuthorizedBill PRE_AUTHORIZED_BILL = new PreAuthorizedBill.Builder()
    .amount(new BigDecimal("10.0"))
    .preAuthorizationId("UQSTF7AMQMYWBL")
    .chargeCustomerAt(new GregorianCalendar(2013, 7, 27).getTime())
    .build();

  String PRE_AUTHORIZED_BILL_POST =
    "{" +
      "\"bill\":{" +
        "\"amount\":10.0," +
        "\"pre_authorization_id\":\"UQSTF7AMQMYWBL\"," +
        "\"charge_customer_at\":\"2013-08-27\"" +
      "}" +
    "}";

}
