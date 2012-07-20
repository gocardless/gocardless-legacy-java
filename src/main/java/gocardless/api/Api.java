package gocardless.api;

import static gocardless.utils.JsonUtils.fromJson;
import static gocardless.utils.JsonUtils.toJson;
import static java.lang.String.format;
import gocardless.AccountDetails;
import gocardless.GoCardless;
import gocardless.http.HttpClient;

import java.util.HashMap;
import java.util.Map;

public class Api {
  
  public interface ApiPath {
    public static final String BASE = format("%s/api/v1", GoCardless.getApiBase());  
    public static final String MERCHANT = format("%s/merchants", BASE);
    public static final String BILL = format("%s/bills", BASE);
  }
  
  protected HttpClient httpClient = HttpClient.DEFAULT;
  
  protected AccountDetails accountDetails;

  public Api(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }
  
  public Merchant getMerchant(String merchantId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.MERCHANT, merchantId), headers(), null), Merchant.class);
  }
  
  public Bill postPreAuthorizedBill(PreAuthorizedBill preAuthorizedBill) {
    return fromJson(httpClient.post(ApiPath.BILL, headers(), toJson(preAuthorizedBill, "bill")), Bill.class);
  }
  
  protected Map<String, String> headers() {
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", format("bearer %s", accountDetails.getAccessToken()));
    return headers;
  }

  protected void setHttpClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }
  
}
