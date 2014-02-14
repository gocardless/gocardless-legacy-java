package gocardless.webhook;

import gocardless.AccountDetails;
import gocardless.exception.SignatureException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class WebHookTest {
  
  private AccountDetails accountDetails = new AccountDetails.Builder()
    .appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01").build();
  
  private WebHook webHook = new WebHook(accountDetails);
  private String webhookJsonData;

  @Before
  public void init() throws IOException {
      String rawwebhookJsonData = readFromRawResourceFile("/webhook.json");
      webhookJsonData = removeNewLines(rawwebhookJsonData);
  }

  @Test
  public void testValidate() throws SignatureException {
    webHook.validate(webhookJsonData);
  }

    private String removeNewLines(String input)
    {
        return input.replaceAll("\n","").replaceAll("\\s+$", "");
    }

  private String readFromRawResourceFile(String filename) throws IOException
  {
        InputStream is = getClass().getResourceAsStream(filename);
        byte[] buff = new byte[2000];
        is.read(buff);
        byte[] results = new String(buff).trim().getBytes();
        return new String(results);
  }
}
