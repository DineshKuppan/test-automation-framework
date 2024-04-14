package com.bytes2gram.framework.test;

import com.bytes2gram.framework.utils.CalculatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class CalculatorTest {

  // Disabling the test

  /** Test to verify the add/sum functionality for the given numbers. */
  @Test(
      enabled = false,
      description = "Test to verify the add/sum functionality for the given numbers")
  public void testSum() {
    int result = CalculatorUtil.sum(3, 9);
    Assert.assertEquals(result, 7);
  }

  /** Test to verify the subtract functionality for the given numbers. */
  @Test(description = "Test to verify the subtract functionality for the given numbers")
  public void testSubtract() {
    int result = CalculatorUtil.subtraction(10, 2);
    Assert.assertTrue(result == 9);
  }

  /** Test to verify the multiplication functionality for the given numbers. */
  @Test(description = "Test to verify the multiplication functionality for the given numbers")
  public void testMultiplication() {
    int expected = 30;
    int result = CalculatorUtil.multiplication(10, 3);
    Assert.assertEquals(result, expected);
  }

  /** Test to verify the division functionality for the given numbers non-zero division number. */
  @Test(
      description =
          "Test to verify the division functionality for the given numbers non-zero division number")
  public void testDivision() {
    int result = 0;
    try {
      result = CalculatorUtil.divison(10, 2);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    Assert.assertEquals(result, 5);
  }

  /**
   * Test to verify the division functionality for the given numbers.
   *
   * <p>Any number divided by zero -"equal to infinity".
   *
   * @throws Exception
   */
  @Test(
      expectedExceptions = Exception.class,
      description =
          "Test to verify the division functionality for the given numbers with zero division number")
  public void testDivideByZeroArithmeticException() throws Exception {
    int result = CalculatorUtil.divison(10, 0);
    Assert.assertEquals(result, 1);
  }
}
