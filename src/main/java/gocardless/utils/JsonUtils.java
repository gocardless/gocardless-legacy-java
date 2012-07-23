package gocardless.utils;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * Wrapper around gson
 */
public class JsonUtils {
  
  public static final Gson gson = new GsonBuilder()
    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
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
