package com.testing.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

  @Test
  public void testMockListSize(){
    List listMock = mock(List.class);
    when(listMock.size()).thenReturn(2);
    assertEquals(2, listMock.size());
  }

  @Test
  public void testMockListSize_ReturnMultipleValues(){
    List listMock = mock(List.class);
    when(listMock.size()).thenReturn(2).thenReturn(3);
    assertEquals(2, listMock.size());
    assertEquals(3, listMock.size());
  }

  @Test
  public void testMockListGet(){
    List listMock = mock(List.class);
    when(listMock.get(anyInt())).thenReturn("Hello World");
    assertEquals("Hello World", listMock.get(0));
    assertEquals("Hello World", listMock.get(1));
  }

  @Test(expected = RuntimeException.class)
  public void testMockList_throwException(){
    List listMock = mock(List.class);
    when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
    listMock.get(0);
  }
}
