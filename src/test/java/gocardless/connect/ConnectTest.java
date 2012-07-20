package gocardless.connect;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import gocardless.AccountDetails;
import gocardless.http.HttpClient;
import gocardless.utils.Utils;

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
  
  private AccountDetails accountDetails = new AccountDetails().appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01");
  
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
    Bill bill = new Bill(accountDetails.getMerchantId(), 1000.0f);
    assertEquals(connect.newBillUrl(bill, null, null, null), Fixtures.NEW_BILL_URL);
  }
  
  
  @Test
  public void testNewSubscriptionUrl() {
    Subscription subscription = new Subscription(accountDetails.getMerchantId(), 15.00f, 1, "month");
    assertEquals(connect.newSubscriptionUrl(subscription, null, null, null), Fixtures.NEW_SUBSCRIPTION_URL);
  }
  
  @Test
  public void testNewPreAuthorizationUrl() {
    PreAuthorization preAuthorization = new PreAuthorization(accountDetails.getMerchantId(), 15.00f, 1, "month");
    assertEquals(connect.newPreAuthorizationUrl(preAuthorization, null, null, null), Fixtures.NEW_PRE_AUTHORIZATION_URL);
  }
  
  @Test
  public void testConfirmResource() {    
    Map<String, String> headers = mockHttpClient.basicAuth(accountDetails.getAppId(), accountDetails.getAppSecret());
    connect.confirm(Fixtures.RESOURCE);
    verify(mockHttpClient, times(1)).post(Connect.ApiPath.CONFIRM, headers, Fixtures.CONFIRM_POST);    
  }
  
}