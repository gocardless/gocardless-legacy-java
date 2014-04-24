package gocardless.api;

import static gocardless.http.HttpClient.url;
import static gocardless.utils.JsonUtils.fromJson;
import static gocardless.utils.JsonUtils.toJson;
import static gocardless.utils.Utils.formatUTC;
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
    public static final String BASE = format("%s/%s", GoCardless.getApiBase(), GoCardless.API_PATH);
    public static final String MERCHANT = format("%s/merchants", BASE);
    public static final String MERCHANT_USERS = MERCHANT + "/%s/users";
    public static final String BILL = format("%s/bills", BASE);
    public static final String BILL_CANCEL = BILL + "/%s/cancel";
    public static final String BILL_RETRY = BILL + "/%s/retry";
    public static final String BILL_REFUND = BILL + "/%s/refund";
    public static final String MERCHANT_BILLS = MERCHANT + "/%s/bills";
    public static final String SUBSCRIPTION = format("%s/subscriptions", BASE);
    public static final String MERCHANT_SUBSCRIPTIONS = MERCHANT + "/%s/subscriptions";
    public static final String SUBSCRIPTION_CANCEL = SUBSCRIPTION + "/%s/cancel";
    public static final String PRE_AUTHORIZATION = format("%s/pre_authorizations", BASE);
    public static final String MERCHANT_PRE_AUTHORIZATIONS = MERCHANT + "/%s/pre_authorizations";
    public static final String PRE_AUTHORIZATION_CANCEL = PRE_AUTHORIZATION + "/%s/cancel";
    public static final String PAYOUT = format("%s/payouts", BASE);
    public static final String MERCHANT_PAYOUTS = MERCHANT + "/%s/payouts";
  }

  protected HttpClient httpClient = HttpClient.DEFAULT;

  protected AccountDetails accountDetails;

  public Api(AccountDetails accountDetails) {
    this.accountDetails = accountDetails;
  }

  public Merchant getMerchant(String merchantId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.MERCHANT, merchantId), headers()), Merchant.class);
  }

  public List<User> getMerchantUsers(String merchantId) {
    return fromJson(httpClient.get(format(ApiPath.MERCHANT_USERS, merchantId), headers()), new TypeToken<ArrayList<User>>(){}.getType());
  }

  public Bill getBill(String billId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.BILL, billId), headers()), Bill.class);
  }

  public Bill cancelBill(String billId) {
    return fromJson(httpClient.put(format(ApiPath.BILL_CANCEL, billId), headers(), null), Bill.class);
  }

  public Bill retryBill(String billId) {
    return fromJson(httpClient.post(format(ApiPath.BILL_RETRY, billId), headers(), null), Bill.class);
  }

  public Bill refundBill(String billId) {
    return fromJson(httpClient.post(format(ApiPath.BILL_REFUND, billId), headers(), null), Bill.class);
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
    return fromJson(
        httpClient.get(url(format(ApiPath.MERCHANT_BILLS, merchantId), params), headers()),
        new TypeToken<ArrayList<Bill>>(){}.getType());
  }

  public Subscription getSubscription(String subscriptionId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.SUBSCRIPTION, subscriptionId), headers()), Subscription.class);
  }

  public List<Subscription> getMerchantSubscriptions(String merchantId, String userId, Date before, Date after) {
    Map<String, String> params = new HashMap<String, String>();
    if (userId != null) params.put("user_id", userId);
    if (before != null) params.put("before", formatUTC(before));
    if (after != null) params.put("after", formatUTC(after));
    return fromJson(
        httpClient.get(url(format(ApiPath.MERCHANT_SUBSCRIPTIONS, merchantId), params), headers()),
        new TypeToken<ArrayList<Subscription>>(){}.getType());
  }

  public Subscription cancelSubscription(String subscriptionId) {
    return fromJson(httpClient.put(format(ApiPath.SUBSCRIPTION_CANCEL, subscriptionId), headers(), null), Subscription.class);
  }

  public PreAuthorization getPreAuthorization(String preAuthorizationId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.PRE_AUTHORIZATION, preAuthorizationId), headers()), PreAuthorization.class);
  }

  public List<PreAuthorization> getMerchantPreAuthorizations(String merchantId) {
    return getMerchantPreAuthorizations(merchantId, null, null, null);
  }

  public List<PreAuthorization> getMerchantPreAuthorizations(String merchantId, String userId, Date before, Date after) {
    Map<String, String> params = new HashMap<String, String>();
    if (userId != null) params.put("user_id", userId);
    if (before != null) params.put("before", formatUTC(before));
    if (after != null) params.put("after", formatUTC(after));
    return fromJson(
        httpClient.get(url(format(ApiPath.MERCHANT_PRE_AUTHORIZATIONS, merchantId), params), headers()),
        new TypeToken<ArrayList<PreAuthorization>>(){}.getType());
  }

  public PreAuthorization cancelPreAuthorization(String preAuthorizationId) {
    return fromJson(httpClient.put(format(ApiPath.PRE_AUTHORIZATION_CANCEL, preAuthorizationId), headers(), null), PreAuthorization.class);
  }

  public Bill postPreAuthorizedBill(PreAuthorizedBill preAuthorizedBill) {
    return fromJson(httpClient.post(ApiPath.BILL, headers(), toJson(preAuthorizedBill, "bill")), Bill.class);
  }

  public List<Payout> getMerchantPayouts(String merchantId) {
    return fromJson(
      httpClient.get(format(ApiPath.MERCHANT_PAYOUTS, merchantId), headers()),
      new TypeToken<ArrayList<Payout>>(){}.getType());
  }

  public Payout getPayout(String payoutId) {
    return fromJson(httpClient.get(format("%s/%s", ApiPath.PAYOUT, payoutId), headers()), Payout.class);
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
