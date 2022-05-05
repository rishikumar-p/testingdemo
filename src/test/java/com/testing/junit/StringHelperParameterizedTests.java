package com.testing.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTests {

  StringHelper stringHelper = new StringHelper();

  private String input;
  private String expectedOutput;

  public StringHelperParameterizedTests(String input, String expectedOutput) {
    this.input = input;
    this.expectedOutput = expectedOutput;
  }

  @Parameterized.Parameters
  public static Collection<String[]> testConditions(){
    String[][] expectedOutputs = {
        {"ABCD", "BCD"},
        {"ACD", "CD"},
        {"AAABCD", "ABCD"}
    };

    return Arrays.asList(expectedOutputs);
  }

  @Test
  public void testTruncatedInFirstTwoPositions(){
    assertEquals(expectedOutput, stringHelper.truncateAInFirst2Positions(input));
  }



}
