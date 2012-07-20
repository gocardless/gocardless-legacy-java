package gocardless;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GoCardlessTest {
  
  @Test
  public void testApiBase() {
    // Test default first
    assertEquals(GoCardless.ApiBase.PRODUCTION, GoCardless.getApiBase());
    
    GoCardless.environment = GoCardless.Environment.SANDBOX;
    assertEquals(GoCardless.ApiBase.SANDBOX, GoCardless.getApiBase());
    
    GoCardless.environment = GoCardless.Environment.PRODUCTION;
    assertEquals(GoCardless.ApiBase.PRODUCTION, GoCardless.getApiBase());    
  }

}