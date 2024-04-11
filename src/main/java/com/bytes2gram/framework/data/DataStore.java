package com.bytes2gram.framework.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by dinesh on 24/03/24.
 *
 * @author dinesh
 * @version 1.0
 *     <p>
 *     <p>An internal data store used to access data's between the session's at runtime
 */
@Slf4j
public class DataStore {

  private static final ThreadLocal<Map<String, Object>> customDataStore =
      ThreadLocal.withInitial(ConcurrentHashMap::new);

  // private constructor to avoid the instantiation
  private DataStore() {}

  /**
   * Implementation of ThreadLocal get method
   *
   * @return
   */
  public static Map<String, Object> getDataStoreMap() {
    return customDataStore.get();
  }

  /**
   * Put the value in store to access the data between classes in the same session
   *
   * @param key
   * @param objectValue
   */
  public static void put(String key, Object objectValue) {
    if (getDataStoreMap().containsKey(key)) {
      return;
    }
    getDataStoreMap().put(key, objectValue);
  }

  /**
   * Fetch value based on the key passed by the user.
   *
   * @param key
   * @return
   */
  public static Object get(String key) {
    log.debug("Current Key {" + key + "}");
    return getDataStoreMap().get(key);
  }

  /**
   * Clear the data
   *
   * <p>Description: After each test method execution completes, clears the test data stored/used
   * for the session to avoid duplicates/repeated data(s) for other test method/scripts
   */
  public static void clear() {
    customDataStore.remove();
  }

  /**
   * Checks whether the key is available or not
   *
   * @param key
   * @return
   */
  public static boolean isKeyPresent(String key) {
    return customDataStore.get().containsKey(key);
  }
}
