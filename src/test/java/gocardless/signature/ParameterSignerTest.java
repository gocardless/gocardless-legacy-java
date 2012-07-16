package gocardless.signature;

import static gocardless.signature.ParameterSigner.signParams;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ParameterSignerTest {

  /**
   * Look for usage example in Ruby example at https://gocardless.com/docs/signature_guide#examples
   */
  @Test
  public void testSignParams() {    
    // data = {:foo => 'bar', :example => [1, 'a']}
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("foo", "bar");
    List<Object> example = new ArrayList<Object>();
    example.add(1);
    example.add("a");
    params.put("example", example);
    
    String key = "5PUZmVMmukNwiHc7V/TJvFHRQZWZumIpCnfZKrVYGpuAdkCcEfv3LIDSrsJ+xOVH";
    assertEquals("5a9447aef2ebd0e12d80d80c836858c6f9c13219f615ef5d135da408bcad453d", signParams(params, key));
  }
  
}
