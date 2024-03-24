package com.bytes2gram.framework.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedData {

  private static final Map<String, Object> customDataStore = new ConcurrentHashMap<>();

  public static Map<String, Object> getDataStoreMap() {
    return customDataStore;
  }

  public static void put(String key, Object objectValue) {
    if (getDataStoreMap().containsKey(key)) {
      return;
    }
    getDataStoreMap().put(key, objectValue);
  }

  public static Object get(String key) {
    return getDataStoreMap().get(key);
  }

}