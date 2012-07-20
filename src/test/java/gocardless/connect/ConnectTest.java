package gocardless.connect;

import static org.junit.Assert.assertEquals;
import gocardless.AccountDetails;
import gocardless.utils.Utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
  
  @Before
  public void setup() throws Exception {
    PowerMockito.spy(Utils.class);
    PowerMockito.when(Utils.class, "nonce").thenReturn("Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT+HO3ReWMxavlco0Fw8rva+ZcI");
    PowerMockito.when(Utils.class, "utc").thenReturn("2012-03-21T08:55:56Z");    
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
  
}