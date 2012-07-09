package gocardless;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class GoCardlessTest {
  
  @BeforeClass
  public static void setUp() {
    GoCardless.client.environment(GoCardless.Environment.SANDBOX);
    GoCardless.client.appId("id01").appSecret("sec01").accessToken("tok01").merchantId("mer01");
  }
  
  @Test
  public void testApiBase() {
    assertEquals(GoCardless.API_BASE.SANDBOX, GoCardless.client.apiBase);
  }

}