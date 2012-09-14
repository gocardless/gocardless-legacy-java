package gocardless.webhook;

import static gocardless.signature.ParameterSigner.validateSignature;
import gocardless.AccountDetails;
import gocardless.exception.SignatureException;
import gocardless.utils.JsonUtils;

import java.util.Map;

public class WebHook {
  
  protected AccountDetails accountDetails;

  public WebHook(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }
  
  @SuppressWarnings("unchecked")
  public void validate(String json) throws SignatureException {
    Map<String, Object> payload = (Map<String, Object>) JsonUtils.toMap(json).get("payload");
    validateSignature(payload, accountDetails.getAppSecret());
  }
  
}
