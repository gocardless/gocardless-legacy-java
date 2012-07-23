package gocardless.api;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import gocardless.AccountDetails;
import gocardless.http.HttpClient;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ApiTest {
  
  private AccountDetails accountDetails = new AccountDetails().appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01");
  
  private Api api = new Api(accountDetails);
  
  private Map<String, String> headers = api.headers();
  
  @Mock private HttpClient mockHttpClient;
  
  @Before
  public void setUp() {    
    initMocks(this);
    api.setHttpClient(mockHttpClient);
  }
  
  @Test
  public void testGetMechant() {
    String url = format("%s/%s", Api.ApiPath.MERCHANT, Fixtures.MERCHANT.getId());    
    when(mockHttpClient.get(url, headers, null)).thenReturn(Fixtures.MERCHANT_RESPONSE);    
    Merchant merchant = api.getMerchant(Fixtures.MERCHANT.getId());
    verify(mockHttpClient, times(1)).get(url, headers, null);
    assertEquals(Fixtures.MERCHANT, merchant);
  }
  
  @Test
  public void testGetBill() {
    String url = format("%s/%s", Api.ApiPath.BILL, Fixtures.BILL.getId());
    when(mockHttpClient.get(url, headers, null)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.getBill(Fixtures.BILL.getId());
    verify(mockHttpClient, times(1)).get(url, headers, null);
    assertEquals(Fixtures.BILL, bill);
  }
  
  @Test
  public void testPostPreAuthorizedBill() {
    when(mockHttpClient.post(Api.ApiPath.BILL, headers, Fixtures.PRE_AUTHORIZED_BILL_POST)).thenReturn(Fixtures.BILL_RESPONSE);
    Bill bill = api.postPreAuthorizedBill(Fixtures.PRE_AUTHORIZED_BILL);
    verify(mockHttpClient, times(1)).post(Api.ApiPath.BILL, headers, Fixtures.PRE_AUTHORIZED_BILL_POST);
    assertEquals(Fixtures.BILL, bill);
  }

}