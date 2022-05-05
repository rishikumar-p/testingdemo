package com.testing.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({JunitTests.class, StringHelperParameterizedTests.class})
public class TestSuite {
}