package gocardless.partner;

import static gocardless.http.HttpClient.basicAuth;
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

public class PartnerTest {
  
  private AccountDetails accountDetails = new AccountDetails().appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01");
  
  private Partner partner = new Partner(accountDetails);
  
  @Mock private HttpClient mockHttpClient;
  
  @Before
  public void setUp() {    
    initMocks(this);
    partner.setHttpClient(mockHttpClient);
  }
  
  @Test
  public void testNewMerchantUrl() throws Exception {
    assertEquals(partner.newMerchantUrl(Fixtures.REDIRECT_URI, null, null), Fixtures.NEW_MERCHANT_URL);
  }
  
  @Test
  public void testGetMechantAccessToken() {
    Map<String, String> headers = basicAuth(accountDetails.getAppId(), accountDetails.getAppSecret());
    when(mockHttpClient.post(Fixtures.ACCESS_TOKEN_URL, headers, null)).thenReturn(Fixtures.MERCHANT_ACCESS_TOKEN_RESPONSE);    
    MerchantAccessToken merchantAccessToken = partner.getMerchantAccessToken(Fixtures.REDIRECT_URI, Fixtures.CODE);
    verify(mockHttpClient, times(1)).post(Fixtures.ACCESS_TOKEN_URL, headers, null);
    assertEquals(Fixtures.MERCHANT_ACCESS_TOKEN, merchantAccessToken);
    assertEquals(Fixtures.MERCHANT_ID, merchantAccessToken.getMerchantId());
  }
  
}