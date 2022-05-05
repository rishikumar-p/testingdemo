package com.testing.mockito;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

  @Test
  public void test(){
    List arrayListSpy = spy(ArrayList.class);
    assertEquals(0, arrayListSpy.size());
    arrayListSpy.add("Hello");
    assertEquals(1, arrayListSpy.size());
    stub(arrayListSpy.size()).toReturn(5);
    arrayListSpy.add("Hello world");
    assertEquals(arrayListSpy.indexOf("Hello world"), 1);

    arrayListSpy.add("HI");
    System.out.println(arrayListSpy);

    assertEquals(arrayListSpy.size(), 5);
  }

}
