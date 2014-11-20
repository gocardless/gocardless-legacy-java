package gocardless.connect;

import static gocardless.http.HttpClient.basicAuth;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import gocardless.AccountDetails;
import gocardless.exception.SignatureException;
import gocardless.http.HttpClient;
import gocardless.utils.Utils;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utils.class})
@PowerMockIgnore({"javax.crypto.*"}) // See http://code.google.com/p/powermock/issues/detail?id=274
public class ConnectTest {

  private AccountDetails accountDetails = new AccountDetails.Builder()
    .appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01").build();

  private Connect connect = new Connect(accountDetails);

  @Mock private HttpClient mockHttpClient;

  @Before
  public void setup() throws Exception {
    initMocks(this);
    PowerMockito.spy(Utils.class);
    PowerMockito.when(Utils.class, "nonce").thenReturn("Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT+HO3ReWMxavlco0Fw8rva+ZcI");
    PowerMockito.when(Utils.class, "utc").thenReturn("2012-03-21T08:55:56Z");
    connect.setHttpClient(mockHttpClient);
  }

  @Test
  public void testNewBillUrl() {
    Bill bill = new Bill(accountDetails.getMerchantId(), new BigDecimal("1000.0"));
    assertEquals(Fixtures.NEW_BILL_URL, connect.newBillUrl(bill, (URI) null, (URI) null, null));
  }

  @Test
  public void testNewBillUrlInEuros() {
    Bill bill = new Bill(accountDetails.getMerchantId(), new BigDecimal("1000.0"));
    bill.setCurrency("EUR");
    assertEquals(Fixtures.NEW_BILL_URL_EUR, connect.newBillUrl(bill, (URI) null, (URI) null, null));
  }

  @Test
  public void testNewSubscriptionUrl() {
    Subscription subscription = new Subscription(accountDetails.getMerchantId(), new BigDecimal("15.0"), 1, "month");
    assertEquals(Fixtures.NEW_SUBSCRIPTION_URL, connect.newSubscriptionUrl(subscription, (URI) null, (URI) null, null));
  }

  @Test
  public void testNewSubscriptionUrlInEuros() {
    Subscription subscription = new Subscription(accountDetails.getMerchantId(), new BigDecimal("15.0"), 1, "month");
    subscription.setCurrency("EUR");
    assertEquals(Fixtures.NEW_SUBSCRIPTION_URL_EUR, connect.newSubscriptionUrl(subscription, (URI) null, (URI) null, null));
  }

  @Test
  public void testNewSubscriptionUrlWithSetupFee() {
    Subscription subscription = new Subscription(accountDetails.getMerchantId(), new BigDecimal("15.0"), 1, "month");
    subscription.setSetupFee(new BigDecimal(20));
    assertEquals(Fixtures.NEW_SUB_URL_WITH_SETUP_FEE, connect.newSubscriptionUrl(subscription, (URI) null, (URI) null, null));
  }

  @Test
  public void testNewPreAuthorizationUrl() {
    PreAuthorization preAuthorization = new PreAuthorization(accountDetails.getMerchantId(), new BigDecimal("15.0"), 1, "month");
    assertEquals(Fixtures.NEW_PRE_AUTHORIZATION_URL, connect.newPreAuthorizationUrl(preAuthorization, (URI) null, (URI) null, null));
  }

  @Test
  public void testNewPreAuthorizationUrlInEuros() {
    PreAuthorization preAuthorization = new PreAuthorization(accountDetails.getMerchantId(), new BigDecimal("15.0"), 1, "month");
    preAuthorization.setCurrency("EUR");
    assertEquals(Fixtures.NEW_PRE_AUTHORIZATION_URL_EUR, connect.newPreAuthorizationUrl(preAuthorization, (URI) null, (URI) null, null));
  }

  @Test
  public void testConfirmResource() throws SignatureException {
    Map<String, String> headers = basicAuth(accountDetails.getAppId(), accountDetails.getAppSecret());
    connect.confirm(Fixtures.RESOURCE);
    String expectedPath = "https://gocardless.com/api/v1/confirm";
    verify(mockHttpClient, times(1)).post(expectedPath, headers, Fixtures.CONFIRM_POST);
  }

}
