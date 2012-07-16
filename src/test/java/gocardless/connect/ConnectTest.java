package gocardless.connect;

import static org.junit.Assert.assertEquals;
import gocardless.AccountDetails;
import gocardless.utils.Utils;

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
  
  @Test
  public void testNewBillUrl() throws Exception {
    PowerMockito.spy(Utils.class);
    PowerMockito.when(Utils.class, "nonce").thenReturn("Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT+HO3ReWMxavlco0Fw8rva+ZcI");
    PowerMockito.when(Utils.class, "utc").thenReturn("2012-03-21T08:55:56Z");    
    assertEquals(connect.newBillUrl(new Bill(1000.0f, accountDetails.getMerchantId()), null, null, null), Fixtures.NEW_BILL_URL);
  }
  
}