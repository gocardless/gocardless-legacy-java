package gocardless.connect;

import java.net.URI;

public interface Fixtures {

  String NEW_BILL_URL =
    "https://gocardless.com/connect/bills/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&bill%5Bamount%5D=1000.0" +
    "&bill%5Bmerchant_id%5D=mer01" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&client_id=id01" +
    "&signature=27c13ef219b44e519e66133ccc514353606a6b3c223dce01a314eddea4caf76b";

  String NEW_BILL_URL_EUR =
    "https://gocardless.com/connect/bills/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&bill%5Bamount%5D=1000.0" +
    "&bill%5Bmerchant_id%5D=mer01" +
    "&bill%5Bcurrency%5D=EUR" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&client_id=id01" +
    "&signature=d2a62fd627fc18d48413f09e71cc3184f22a0f747270a2ec675aa832655b7021";

  String NEW_SUBSCRIPTION_URL =
    "https://gocardless.com/connect/subscriptions/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&subscription%5Binterval_unit%5D=month" +
    "&subscription%5Bamount%5D=15.0" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&subscription%5Binterval_length%5D=1" +
    "&client_id=id01" +
    "&subscription%5Bmerchant_id%5D=mer01" +
    "&signature=6026be854689c533304fe29381e014774b7cc746c65d6d632852d9cfa25caddf";

  String NEW_SUBSCRIPTION_URL_EUR =
    "https://gocardless.com/connect/subscriptions/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&subscription%5Binterval_unit%5D=month" +
    "&subscription%5Bamount%5D=15.0" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&subscription%5Bcurrency%5D=EUR" +
    "&subscription%5Binterval_length%5D=1" +
    "&client_id=id01" +
    "&subscription%5Bmerchant_id%5D=mer01" +
    "&signature=1277b63382dfc64a6ccee38d6bf0b3b5b1f1233cfa6fb37ef657984f44f42208";

  String NEW_SUB_URL_WITH_SETUP_FEE =
    "https://gocardless.com/connect/subscriptions/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&subscription%5Binterval_unit%5D=month" +
    "&subscription%5Bamount%5D=15.0" +
    "&subscription%5Bsetup_fee%5D=20" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&subscription%5Binterval_length%5D=1" +
    "&client_id=id01" +
    "&subscription%5Bmerchant_id%5D=mer01" +
    "&signature=a25d0b4cad4488976c62a12fd8907af05894da647310228e827562f84ce1e129";

  String NEW_PRE_AUTHORIZATION_URL =
    "https://gocardless.com/connect/pre_authorizations/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&pre_authorization%5Binterval_unit%5D=month" +
    "&pre_authorization%5Binterval_length%5D=1" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&pre_authorization%5Bmerchant_id%5D=mer01" +
    "&pre_authorization%5Bmax_amount%5D=15.0" +
    "&client_id=id01" +
    "&signature=eb46228f02b1bb2efddff55ac0e38614c2c562b7507779768abc0063d57dc1a4";

  String NEW_PRE_AUTHORIZATION_URL_EUR =
    "https://gocardless.com/connect/pre_authorizations/new?" +
    "timestamp=2012-03-21T08%3A55%3A56Z" +
    "&pre_authorization%5Binterval_unit%5D=month" +
    "&pre_authorization%5Binterval_length%5D=1" +
    "&nonce=Q9gMPVBZixfRiQ9VnRdDyrrMiskqT0ox8IT%2BHO3ReWMxavlco0Fw8rva%2BZcI" +
    "&pre_authorization%5Bmerchant_id%5D=mer01" +
    "&pre_authorization%5Bmax_amount%5D=15.0" +
    "&client_id=id01" +
    "&signature=35d92ef9120c74806888db903c5551af9ab045773decf00e90f85d9c7a157e8d" +
    "&pre_authorization%5Bcurrency%5D=EUR";

  Resource RESOURCE = new Resource.Builder()
    .resourceId("VZUG2SC3PRT5EM")
    .resourceType("bill")
    .resourceUri(URI.create("https://gocardless.com/api/v1/bills/VZUG2SC3PRT5EM"))
    .state("id_9SX5G36")
    .signature("f5332dc226ef1196cc03bd3f4d7259412a180a4528f9fae28f8c008a772c540e")
    .build();

  String CONFIRM_POST = "{\"resource_id\":\"VZUG2SC3PRT5EM\", \"resource_type\":\"bill\"}";

}
