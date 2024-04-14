package com.bytes2gram.framework.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/** Utility class for JSON operations. */
public class JsonUtils {

  // Gson instance for JSON operations
  private static final Gson gson = new Gson();

  /**
   * Reads a JSON file and converts it into an object of the specified class.
   *
   * @param filePath The path of the JSON file.
   * @param classOfT The class of the object.
   * @return The object read from the JSON file.
   * @throws IOException If an I/O error occurs.
   */
  public static <T> T fromJsonFile(String filePath, Class<T> classOfT) throws IOException {
    try (FileReader reader = new FileReader(filePath)) {
      StringBuilder stringBuilder = new StringBuilder();
      int character;
      while ((character = reader.read()) != -1) {
        stringBuilder.append((char) character);
      }
      String jsonString = stringBuilder.toString();
      return gson.fromJson(jsonString, classOfT);
    }
  }

  /**
   * Converts an object into a JSON string and writes it to a file.
   *
   * @param object The object to convert into a JSON string.
   * @param filePath The path of the file to write the JSON string to.
   * @throws IOException If an I/O error occurs.
   */
  public static <T> void toJsonFile(T object, String filePath) throws IOException {
    String jsonString = gson.toJson(object);
    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(jsonString);
    }
  }

  /**
   * Converts a JSON string into an object of the specified type.
   *
   * @param jsonString The JSON string to convert.
   * @param type The type of the object.
   * @return The object read from the JSON string.
   */
  public static <T> T fromJsonString(String jsonString, Type type) {
    return gson.fromJson(jsonString, type);
  }

  /**
   * Converts an object into a JSON string.
   *
   * @param object The object to convert.
   * @return The JSON string representation of the object.
   */
  public static String toJsonString(Object object) {
    return gson.toJson(object);
  }

  /**
   * Converts a JSON string into a list of objects of the specified class.
   *
   * @param jsonString The JSON string to convert.
   * @param elementClass The class of the objects in the list.
   * @return The list of objects read from the JSON string.
   */
  public static <T> T fromJsonListString(String jsonString, Class<T> elementClass) {
    Type listType = TypeToken.getParameterized(List.class, elementClass).getType();
    return gson.fromJson(jsonString, listType);
  }
}
