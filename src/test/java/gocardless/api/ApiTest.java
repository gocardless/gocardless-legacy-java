package gocardless.api;

import static gocardless.utils.Utils.parseUTC;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import gocardless.AccountDetails;
import gocardless.TestUtils;
import gocardless.http.HttpClient;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ApiTest {

  private AccountDetails accountDetails = new AccountDetails.Builder()
    .appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01").build();

  private Api api = new Api(accountDetails);

  private Map<String, String> headers = api.headers();

  @Mock private HttpClient mockHttpClient;

  @Before
  public void setUp() {
    initMocks(this);
    api.setHttpClient(mockHttpClient);
  }

  @Test
  public void testGetMerchant() {
    String url = format("%s/%s", Api.ApiPath.MERCHANT, Fixtures.MERCHANT.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(TestUtils.readFromRawResourceFile("/merchant_response.json"));
    Merchant merchant = api.getMerchant(Fixtures.MERCHANT.getId());
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.MERCHANT, merchant);
  }

  @Test
  public void testGetMerchantUsers() {
    String url = format(Api.ApiPath.MERCHANT_USERS, Fixtures.MERCHANT.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(TestUtils.readFromRawResourceFile("/merchant_users_response.json"));
    List<User> users = api.getMerchantUsers(Fixtures.MERCHANT.getId());
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.MERCHANT_USERS, users);
  }

  @Test
  public void testGetBill() {
    String url = format("%s/%s", Api.ApiPath.BILL, Fixtures.BILL.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.getBill(Fixtures.BILL.getId());
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.BILL, bill);
  }

  @Test
  public void testCancelBill() {
    String url = format(Api.ApiPath.BILL_CANCEL, Fixtures.BILL.getId());
    when(mockHttpClient.put(url, headers, null)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.cancelBill(Fixtures.BILL.getId());
    verify(mockHttpClient, times(1)).put(url, headers, null);
    assertEquals(Fixtures.BILL, bill);
  }

  @Test
  public void testRetryBill() {
    String url = format(Api.ApiPath.BILL_RETRY, Fixtures.BILL.getId());
    when(mockHttpClient.post(url, headers, null)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.retryBill(Fixtures.BILL.getId());
    verify(mockHttpClient, times(1)).post(url, headers, null);
    assertEquals(Fixtures.BILL, bill);
  }

  @Test
  public void testRefundBill() {
    String url = format(Api.ApiPath.BILL_REFUND, Fixtures.BILL.getId());
    when(mockHttpClient.post(url, headers, null)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.refundBill(Fixtures.BILL.getId());
    verify(mockHttpClient, times(1)).post(url, headers, null);
    assertEquals(Fixtures.BILL, bill);
  }

  @Test
  public void testGetMerchantBills() {
    String url = format(Api.ApiPath.MERCHANT_BILLS, Fixtures.MERCHANT.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.BILLS_RESPONSE);
    List<Bill> bills = api.getMerchantBills(Fixtures.MERCHANT.getId(), null, null, null, null, null, null, null);
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.BILLS, bills);
  }

  @Test
  public void testGetFilteredMerchantBills() {
    String url = format(Api.ApiPath.MERCHANT_BILLS + "?%s", Fixtures.MERCHANT.getId(), Fixtures.BILLS_FILTER);
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.BILLS_RESPONSE);
    List<Bill> bills = api.getMerchantBills(Fixtures.MERCHANT.getId(),
        Fixtures.BILL.getSourceId(), "test_subscriptiod_id", "test_pre_authorized_id", Fixtures.BILL.getUserId(),
        parseUTC("2011-11-22T09:00:00Z"), parseUTC("2011-11-23T09:00:00Z"), Boolean.FALSE);
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.BILLS, bills);
  }

  @Test
  public void testGetSubscription() {
    String url = format("%s/%s", Api.ApiPath.SUBSCRIPTION, Fixtures.SUBSCRIPTION.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.SUBSCRIPTION_RESPONSE);
    Subscription subscription = api.getSubscription(Fixtures.SUBSCRIPTION.getId());
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.SUBSCRIPTION, subscription);
  }

  @Test
  public void testGetMerchantSubscriptions() {
    String url = format(Api.ApiPath.MERCHANT_SUBSCRIPTIONS, Fixtures.SUBSCRIPTION.getMerchantId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.SUBSCRIPTIONS_RESPONSE);
    List<Subscription> subscriptions = api.getMerchantSubscriptions(Fixtures.SUBSCRIPTION.getMerchantId(), null, null, null);
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.SUBSCRIPTIONS, subscriptions);
  }

  @Test
  public void testGetFilteredMerchantSubscriptions() {
    String url = format(Api.ApiPath.MERCHANT_SUBSCRIPTIONS + "?%s", Fixtures.SUBSCRIPTION.getMerchantId(), Fixtures.SUBSCRIPTIONS_FILTER);
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.SUBSCRIPTIONS_RESPONSE);
    List<Subscription> subscriptions = api.getMerchantSubscriptions(Fixtures.SUBSCRIPTION.getMerchantId(),
        Fixtures.SUBSCRIPTION.getUserId(), parseUTC("2011-09-13T09:00:00Z"), parseUTC("2011-09-12T09:00:00Z"));
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.SUBSCRIPTIONS, subscriptions);
  }

  @Test
  public void testCancelSubscription() {
    String url = format(Api.ApiPath.SUBSCRIPTION_CANCEL, Fixtures.SUBSCRIPTION.getId());
    when(mockHttpClient.put(url, headers, null)).thenReturn(Fixtures.SUBSCRIPTION_RESPONSE);
    Subscription subscription = api.cancelSubscription(Fixtures.SUBSCRIPTION.getId());
    verify(mockHttpClient, times(1)).put(url, headers, null);
    assertEquals(Fixtures.SUBSCRIPTION, subscription);
  }

  @Test
  public void testGetPreAuthorization() {
    String url = format("%s/%s", Api.ApiPath.PRE_AUTHORIZATION, Fixtures.PRE_AUTHORIZATION.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.PRE_AUTHORIZATION_RESPONSE);
    PreAuthorization preAuthorization = api.getPreAuthorization(Fixtures.PRE_AUTHORIZATION.getId());
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.PRE_AUTHORIZATION, preAuthorization);
  }

  @Test
  public void testGetMerchantPreAuthorizations() {
    String url = format(Api.ApiPath.MERCHANT_PRE_AUTHORIZATIONS, Fixtures.PRE_AUTHORIZATION.getMerchantId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.PRE_AUTHORIZATIONS_RESPONSE);
    List<PreAuthorization> preAuthorizations = api.getMerchantPreAuthorizations(Fixtures.PRE_AUTHORIZATION.getMerchantId(), null, null, null);
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.PRE_AUTHORIZATIONS, preAuthorizations);
  }

  @Test
  public void testGetFilteredMerchantPreAuthorizations() {
    String url = format(Api.ApiPath.MERCHANT_PRE_AUTHORIZATIONS + "?%s", Fixtures.PRE_AUTHORIZATION.getMerchantId(), Fixtures.PRE_AUTHORIZATIONS_FILTER);
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.PRE_AUTHORIZATIONS_RESPONSE);
    List<PreAuthorization> preAuthorizations = api.getMerchantPreAuthorizations(Fixtures.PRE_AUTHORIZATION.getMerchantId(),
        Fixtures.PRE_AUTHORIZATION.getUserId(), parseUTC("2011-02-19T09:00:00Z"), parseUTC("2011-02-18T09:00:00Z"));
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.PRE_AUTHORIZATIONS, preAuthorizations);
  }

  @Test
  public void testCancelPreAuthorization() {
    String url = format(Api.ApiPath.PRE_AUTHORIZATION_CANCEL, Fixtures.PRE_AUTHORIZATION.getId());
    when(mockHttpClient.put(url, headers, null)).thenReturn(Fixtures.PRE_AUTHORIZATION_RESPONSE);
    PreAuthorization preAuthorization = api.cancelPreAuthorization(Fixtures.PRE_AUTHORIZATION.getId());
    verify(mockHttpClient, times(1)).put(url, headers, null);
    assertEquals(Fixtures.PRE_AUTHORIZATION, preAuthorization);
  }

  @Test
  public void testPostPreAuthorizedBill() {
    when(mockHttpClient.post(Api.ApiPath.BILL, headers, Fixtures.PRE_AUTHORIZED_BILL_POST)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.postPreAuthorizedBill(Fixtures.PRE_AUTHORIZED_BILL);
    verify(mockHttpClient, times(1)).post(Api.ApiPath.BILL, headers, Fixtures.PRE_AUTHORIZED_BILL_POST);
    assertEquals(Fixtures.BILL, bill);
  }

  @Test
  public void testGetPayout() {
    String url = format("%s/%s", Api.ApiPath.PAYOUT, Fixtures.PAYOUT.getId());
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.PAYOUT_RESPONSE);
    Payout payout = api.getPayout(Fixtures.PAYOUT.getId());
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.PAYOUT, payout);
  }

  @Test
  public void testGetPayouts() {
    String merchantId = "MERCHANTID";
    String url = format(Api.ApiPath.MERCHANT_PAYOUTS, merchantId);
    when(mockHttpClient.get(url, headers)).thenReturn(Fixtures.PAYOUTS_RESPONSE);
    List<Payout> payouts = api.getMerchantPayouts(merchantId);
    verify(mockHttpClient, times(1)).get(url, headers);
    assertEquals(Fixtures.PAYOUTS, payouts);
  }
}
