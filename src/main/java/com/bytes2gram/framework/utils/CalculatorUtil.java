package com.bytes2gram.framework.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CalculatorUtil {

  public int sum(int a, int b) {
    return a + b;
  }

  public int subtraction(int a, int b) {
    return a - b;
  }

  public int multiplication(int a, int b) {
    return a * b;
  }

  public int divison(int a, int b) throws Exception {
    if (b == 0) {
      throw new Exception("Divider can't be zero");
    }

    return a / b;
  }
}
