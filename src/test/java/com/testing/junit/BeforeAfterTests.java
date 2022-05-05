package com.testing.junit;

import org.junit.*;

public class BeforeAfterTests {

  @BeforeClass
  public static void beforeClass() {
    System.out.println("Before Class");
  }

  @Before
  public void setup() {
    System.out.println("Before Test");
  }

  @Test
  public void test1() {
    System.out.println("Test 1 executed");
  }

  @Test
  public void test2() {
    System.out.println("Test 2 executed");
  }

  @After
  public void teardown() {
    System.out.println("After test");
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("After Class");
  }
}
