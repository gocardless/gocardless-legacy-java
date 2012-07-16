package gocardless.utils;

import static java.lang.String.format;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;

/**
 * See http://stackoverflow.com/questions/6133660/recursive-beanutils-describe
 * 
 * Modified to:
 *  - use underscored lowercase instead of camel case
 *  - use bracket notation instead of dot notation
 *  - include prefix of object being described
 */
public class BeanUtils {

  public static Map<String, String> recursiveDescribe(Object object) {
    Set<Object> cache = new HashSet<Object>();
    return recursiveDescribe(object, null, cache);
  }

  @SuppressWarnings("unchecked")
  private static Map<String, String> recursiveDescribe(Object object, String prefix, Set<Object> cache) {
    if (object == null || cache.contains(object))
      return Collections.EMPTY_MAP;
    cache.add(object);

    Map<String, String> beanMap = new TreeMap<String, String>();

    Map<String, Object> properties = getProperties(object);
    for (String property : properties.keySet()) {      
      // Use bracket notation and underscored lowercase, instead of dot notation and camel case
      prefix = (prefix != null) ? prefix : underscoreAndLowercase(object.getClass().getSimpleName());
      String propertyName = format("%s[%s]", prefix, underscoreAndLowercase(property));
      
      Object value = properties.get(property);
      try {
        if (value == null) {
          // ignore nulls
        } else if (Collection.class.isAssignableFrom(value.getClass())) {          
          beanMap.putAll(convertAll((Collection) value, propertyName, cache));
        } else if (value.getClass().isArray()) {
          beanMap.putAll(convertAll(Arrays.asList((Object[]) value), propertyName, cache));
        } else if (Map.class.isAssignableFrom(value.getClass())) {
          beanMap.putAll(convertMap((Map) value, propertyName, cache));
        } else {
          beanMap.putAll(convertObject(value, propertyName, cache));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return beanMap;
  }

  private static Map<String, Object> getProperties(Object object) {
    Map<String, Object> propertyMap = getFields(object);
    // getters take precedence in case of any name collisions
    propertyMap.putAll(getGetterMethods(object));
    return propertyMap;
  }

  private static Map<String, Object> getGetterMethods(Object object) {
    Map<String, Object> result = new HashMap<String, Object>();
    BeanInfo info;
    try {
      info = Introspector.getBeanInfo(object.getClass());
      for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
        Method reader = pd.getReadMethod();
        if (reader != null) {
          String name = pd.getName();
          if (!"class".equals(name)) {
            try {
              Object value = reader.invoke(object);
              result.put(name, value);
            } catch (Exception e) {
              // you can choose to do something here
            }
          }
        }
      }
    } catch (IntrospectionException e) {
      // you can choose to do something here
    }
    return result;
  }

  private static Map<String, Object> getFields(Object object) {
    return getFields(object, object.getClass());
  }

  private static Map<String, Object> getFields(Object object, Class<?> classType) {
    Map<String, Object> result = new HashMap<String, Object>();

    Class<?> superClass = classType.getSuperclass();
    if (superClass != null)
      result.putAll(getFields(object, superClass));

    // get public fields only
    Field[] fields = classType.getFields();
    for (Field field : fields) {
      try {
        result.put(field.getName(), field.get(object));
      } catch (IllegalAccessException e) {
        // you can choose to do something here
      }
    }
    return result;
  }

  private static Map<String, String> convertAll(Collection<Object> values, String key, Set<Object> cache) {
    Map<String, String> valuesMap = new HashMap<String, String>();
    Object[] valArray = values.toArray();
    for (int i = 0; i < valArray.length; i++) {
      Object value = valArray[i];
      if (value != null)
        valuesMap.putAll(convertObject(value, key + "[" + i + "]", cache));
    }
    return valuesMap;
  }

  private static Map<String, String> convertMap(Map<Object, Object> values, String key, Set<Object> cache) {
    Map<String, String> valuesMap = new HashMap<String, String>();
    for (Object thisKey : values.keySet()) {
      Object value = values.get(thisKey);
      if (value != null)
        valuesMap.putAll(convertObject(value, key + "[" + thisKey + "]", cache));
    }
    return valuesMap;
  }

  private static ConvertUtilsBean converter = BeanUtilsBean.getInstance().getConvertUtils();

  private static Map<String, String> convertObject(Object value, String key, Set<Object> cache) {
    // if this type has a registered converted, then get the string and return
    if (converter.lookup(value.getClass()) != null) {
      String stringValue = converter.convert(value);
      Map<String, String> valueMap = new HashMap<String, String>();
      valueMap.put(key, stringValue);
      return valueMap;
    } else {
      // otherwise, treat it as a nested bean that needs to be described itself
      return recursiveDescribe(value, key, cache);
    }
  }
  
  // see http://stackoverflow.com/questions/2559759/how-do-i-convert-camelcase-into-human-readable-names-in-java
  private static String underscoreAndLowercase(String s) {
    return s.replaceAll(
        String.format("%s|%s",
           "(?<=[A-Z])(?=[A-Z][a-z])",
           "(?<=[^A-Z])(?=[A-Z])"
        ),
        "_"
     ).toLowerCase();
  }
  
}