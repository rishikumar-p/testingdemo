package com.testing.powermock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  Dependency dependency;

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Captor
  ArgumentCaptor<String> argumentCaptor;

  @Test
  public void test() {
    List<Integer> stats = Arrays.asList(5, 10, 15, 20);
    when(dependency.retrieveAllStats()).thenReturn(stats);

    PowerMockito.mockStatic(UtilityClass.class);

    when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
    assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
  }

}
