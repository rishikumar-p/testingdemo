package com.testing.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class JunitTests {

  StringHelper helper;

  @Before
  public void before(){
    helper = new StringHelper();
  }


  @Test
  public void testTruncateAInFirst2Positions_AinFirst2Positions() {
    assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
  }

  @Test
  public void testTruncateAInFirst2Positions_AinFirstPosition() {
    assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
    assertFalse(
        helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
    assertTrue(
        helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
  }


  @Test
  public void testArraySort_RandomArray() {
    int[] numbers = { 12, 3, 4, 1 , -1, 24};
    int[] expected = {-1, 1, 3, 4, 12 , 24};
    Arrays.sort(numbers);
    assertArrayEquals(expected, numbers);
  }

  @Test(expected = NullPointerException.class)
  public void testArraySort_NullArray() {
    int[] numbers = null;
    Arrays.sort(numbers);
  }

  @Test(timeout = 100)
  public void testSort_Performance() {
    int[] array = { 12, 23, 4 };
    for (int i = 1; i <= 1000000; i++) {
      array[0] = i;
      Arrays.sort(array);
    }
  }

  @Test(timeout = 100)
  public void testPerformance() {
    for (int i = 0; i < 1000000; i++) {
      Arrays.sort(new int[] { i, i - 1, i + 1 });
    }
  }

}