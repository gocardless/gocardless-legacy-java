package gocardless.webhook;

public interface Fixtures {

    String WEBHOOK =
        "{\n" +
        "    \"payload\": {\n" +
        "        \"resource_type\": \"bill\",\n" +
        "        \"action\": \"paid\",\n" +
        "        \"bills\": [\n" +
        "            {\n" +
        "                \"id\": \"AKJ398H8KA\",\n" +
        "                \"status\": \"paid\",\n" +
        "                \"source_type\": \"subscription\",\n" +
        "                \"source_id\": \"KKJ398H8K8\",\n" +
        "                \"user_id\": \"ABC398H8K8\",\n" +
        "                \"merchant_id\": \"DEF398H8K8\",\n" +
        "                \"amount\": \"20.0\",\n" +
        "                \"amount_minus_fees\": \"19.8\",\n" +
        "                \"paid_at\": \"2011-12-01T12:00:00Z\",\n" +
        "                \"uri\": \"https://gocardless.com/api/v1/bills/AKJ398H8KA\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"AKJ398H8KB\",\n" +
        "                \"status\": \"paid\",\n" +
        "                \"source_type\": \"subscription\",\n" +
        "                \"source_id\": \"8AKJ398H78\",\n" +
        "                \"user_id\": \"ABC398H8K8\",\n" +
        "                \"merchant_id\": \"DEF398H8K8\",\n" +
        "                \"amount\": \"20.0\",\n" +
        "                \"amount_minus_fees\": \"19.8\",\n" +
        "                \"paid_at\": \"2011-12-09T12:00:00Z\",\n" +
        "                \"uri\": \"https://gocardless.com/api/v1/bills/AKJ398H8KB\"\n" +
        "            }\n" +
        "        ],\n" +
        "        \"signature\": \"d81e52100e6f4af6aa37d739f0e8359d6461cbcdc8556088f45453940c7fff4d\"\n" +
        "    }\n" +
        "}";

}
