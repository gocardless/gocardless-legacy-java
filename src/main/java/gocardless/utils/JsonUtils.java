package gocardless.utils;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.reflect.TypeToken;

class DateSerializer implements JsonSerializer<Date> {
  public JsonElement serialize(Date src, Type typeOfSrc,
                               JsonSerializationContext context) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    return new JsonPrimitive(formatter.format(src));
  }
}

class DateDeserializer implements JsonDeserializer<Date> {
  public Date deserialize(JsonElement json, Type typeOfSrc,
                               JsonDeserializationContext context) {
    SimpleDateFormat formatterShort = new SimpleDateFormat("yyyy-MM-dd");
    Date deserialized = null;
    String dateAsString = json.getAsJsonPrimitive().getAsString();

    if (dateAsString.equalsIgnoreCase("null")) {
        return null;
    }

    if (dateAsString.length() > 10) {
      deserialized = Utils.parseUTC(dateAsString);
    } else {
      try {
          deserialized = formatterShort.parse(dateAsString);
      } catch (ParseException e) {
      }
    }

    return deserialized;
  }
}

/**
 * Wrapper around gson
 */
public class JsonUtils {

  public static final Gson gson = new GsonBuilder()
    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    .registerTypeAdapter(Date.class, new DateSerializer())
    .registerTypeAdapter(Date.class, new DateDeserializer())
    .create();

  public static <T> T fromJson(String json, Class<T> clazz) {
    return gson.fromJson(json, clazz);
  }

  public static <T> T fromJson(String json, Type type) {
    return gson.fromJson(json, type);
  }

  public static String toJson(Object src) {
    return gson.toJson(src);
  }

  public static String toJson(Object src, String root) {
    JsonObject json = new JsonObject();
    json.add(root, gson.toJsonTree(src));
    return json.toString();
  }

  public static Map<String, Object> toMap(String json) {
    // See https://sites.google.com/site/gson/gson-user-guide#TOC-Serializing-and-Deserializing-Generic-Types
    return gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
  }

}
