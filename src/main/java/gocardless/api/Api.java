package gocardless.api;

import static gocardless.utils.JsonUtils.fromJson;
import static gocardless.utils.JsonUtils.toJson;
import static gocardless.utils.Utils.formatUTC;
import static gocardless.utils.Utils.urlEncodedQueryPath;
import static java.lang.String.format;
import gocardless.AccountDetails;
import gocardless.GoCardless;
import gocardless.http.HttpClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

public class Api {
  
  public interface ApiPath {
    public static final String BASE = format("%s/api/v1", GoCardless.getApiBase());  
    public static final String MERCHANT = format("%s/merchants", BASE);
    public static final String MERCHANT_BILLS = MERCHANT + "/%s/bills";
    public static final String BILL = format("%s/bills", BASE);
    public static final String SUBSCRIPTION = format("%s/subscriptions", BASE);
  }
  
  protected HttpClient httpClient = HttpClient.DEFAULT;
  
  protected AccountDetails accountDetails;

  public Api(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }
  
  public Merchant getMerchant(String merchantId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.MERCHANT, merchantId), headers(), null), Merchant.class);
  }
  
  public Bill getBill(String billId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.BILL, billId), headers(), null), Bill.class);
  }
  
  public List<Bill> getMerchantBills(
      String merchantId, String sourceId, String subscriptionId,
      String preAuthorizationId, String userId, Date before, Date after, Boolean paid) {
    Map<String, String> params = new HashMap<String, String>();
    if (sourceId != null) params.put("source_id", sourceId);
    if (subscriptionId != null) params.put("subscription_id", subscriptionId);
    if (preAuthorizationId != null) params.put("pre_authorization_id", preAuthorizationId);
    if (userId != null) params.put("user_id", userId);
    if (before != null) params.put("before", formatUTC(before));
    if (after != null) params.put("after", formatUTC(after));
    if (paid != null) params.put("paid", paid.toString());

    String url = (params.isEmpty())
      ? format(ApiPath.MERCHANT_BILLS, merchantId)
      : format(ApiPath.MERCHANT_BILLS + "?%s", merchantId, urlEncodedQueryPath(params));
    return fromJson(httpClient.get(url, headers(), null), new TypeToken<ArrayList<Bill>>(){}.getType());
  }

  public Subscription getSubscription(String subscriptionId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.SUBSCRIPTION, subscriptionId), headers(), null), Subscription.class);
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
