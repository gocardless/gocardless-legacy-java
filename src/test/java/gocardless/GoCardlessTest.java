package gocardless;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GoCardlessTest {
  
  @Before
  public void setUp() {
    GoCardless.environment = GoCardless.Environment.SANDBOX;
  }
  
  @Test
  public void testApiBase() {
    assertEquals(GoCardless.ApiBase.SANDBOX, GoCardless.getApiBase());
  } 

}