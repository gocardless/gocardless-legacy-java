package gocardless.partner;

import gocardless.partner.Partner.ApiPath;

import java.net.URI;

public interface Fixtures {

  URI REDIRECT_URI = URI.create("http://example.com/confirm_resource");

  String CODE = "9kbgD/RlJck1fbwAFCIJA6A8j8erXX+ujngNvHQD5guRIY5gFDGf2fa4jrGqfAkF";

  String MERCHANT_ID = "VSXU7HPAY7OZN6";

  String NEW_MERCHANT_URL =
    "https://gocardless.com/oauth/authorize?" +
    "scope=manage_merchant" +
    "&response_type=code" +
    "&redirect_uri=http%3A%2F%2Fexample.com%2Fconfirm_resource" +
    "&client_id=id01";

  String ACCESS_TOKEN_URL =
    ApiPath.ACCESS_TOKEN + "?" +
    "grant_type=authorization_code" +
    "&redirect_uri=http%3A%2F%2Fexample.com%2Fconfirm_resource" +
    "&code=9kbgD%2FRlJck1fbwAFCIJA6A8j8erXX%2BujngNvHQD5guRIY5gFDGf2fa4jrGqfAkF" +
    "&client_id=id01";

  String MERCHANT_ACCESS_TOKEN_RESPONSE =
    "{\n" +
    "  \"access_token\": \"FfqjnhGYtNPvA/uDm214dDh61mKu19ZSfWo5kdNbhyAJL8QZZ+4aoRw+hgerc1zD\",\n" +
    "  \"token_type\": \"bearer\",\n" +
    "  \"scope\": \"manage_merchant:VSXU7HPAY7OZN6\"\n" +
    "}";

  MerchantAccessToken MERCHANT_ACCESS_TOKEN = new MerchantAccessToken.Builder()
    .accessToken("FfqjnhGYtNPvA/uDm214dDh61mKu19ZSfWo5kdNbhyAJL8QZZ+4aoRw+hgerc1zD")
    .tokenType("bearer")
    .scope(String.format("manage_merchant:%s", MERCHANT_ID))
    .build();

}
