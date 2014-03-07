package gocardless.api;

import gocardless.TestUtils;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static gocardless.utils.Utils.parseUTC;


public interface Fixtures {

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

  String BILL_RESPONSE = TestUtils.readFromRawResourceFile("/bill_response.json");

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
    .paymentId("0B1R2T0507")
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

  String SUBSCRIPTION_RESPONSE = TestUtils.readFromRawResourceFile("/subscription_response.json");

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

  String PRE_AUTHORIZATION_RESPONSE = TestUtils.readFromRawResourceFile("/pre_authorization_response.json");

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

  String PRE_AUTHORIZED_BILL_POST = TestUtils.readFromRawResourceFile("/pre_authorized_bill_post.json");

  String PAYOUT_RESPONSE = TestUtils.readFromRawResourceFile("/payout_response.json");

  Payout PAYOUT = new Payout.Builder()
    .amount(new BigDecimal("12.37"))
    .bankReference("JOHNSMITH-Z5DRM")
    .createdAt(parseUTC("2013-05-10T16:34:34Z"))
    .id("0BKR1AZNJF")
    .paidAt(parseUTC("2013-05-10T17:00:26Z"))
    .transactionFees(new BigDecimal("0.13"))
    .build();

  String PAYOUTS_RESPONSE = "[" + PAYOUT_RESPONSE + "," + PAYOUT_RESPONSE + "]";
  List<Payout> PAYOUTS = Arrays.asList(PAYOUT, PAYOUT);
}
