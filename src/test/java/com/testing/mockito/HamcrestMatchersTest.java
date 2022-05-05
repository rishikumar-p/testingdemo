package com.testing.mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class HamcrestMatchersTest {

  @Test
  public void test(){
    List<Integer> scores = Arrays.asList(70, 80 , 99, 100, 101, 105, 110, 200);

    assertThat(scores, hasSize(8));
    assertThat(scores, hasItems(80, 100));

    assertThat(scores, everyItem(greaterThan(60)));
    assertThat(scores, everyItem(lessThanOrEqualTo(200)));

    assertThat("", isEmptyString());
    assertThat(null, isEmptyOrNullString());

    Integer[] marks = {2, 4, 6, 9};
    
    assertThat(marks, arrayWithSize(4));
    assertThat(marks, arrayContaining(2, 4, 6 , 9));
    assertThat(marks, arrayContainingInAnyOrder(6, 4, 9, 2));

  }
}
