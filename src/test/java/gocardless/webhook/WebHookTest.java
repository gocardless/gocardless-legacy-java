package gocardless.webhook;

import gocardless.AccountDetails;

import org.junit.Test;

public class WebHookTest {
  
  private AccountDetails accountDetails = new AccountDetails().appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01");
  
  private WebHook webHook = new WebHook(accountDetails);
  
  @Test
  public void testValidate() {
    webHook.validate(Fixtures.WEBHOOK);
  }
  
}