package gocardless.webhook;

import gocardless.AccountDetails;
import gocardless.exception.SignatureException;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WebHookTest {
  
  private AccountDetails accountDetails = new AccountDetails.Builder()
    .appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01").build();
  
  private WebHook webHook = new WebHook(accountDetails);
  private String webHookJsonData;

  @Before
  public void init() throws IOException {
    webHookJsonData = readFromRawResourceFile("/webhook.json");
  }

  @Test
  public void testValidate() throws SignatureException {
    webHook.validate(webHookJsonData);
  }

  private String readFromRawResourceFile(String filename) throws IOException
  {
    InputStream is = getClass().getResourceAsStream(filename);
    BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    return sb.toString();
  }
}
