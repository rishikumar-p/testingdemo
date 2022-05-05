package com.testing.business;

import com.testing.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockitoInjectMocksTest {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  TodoService todoServiceMock;

  @InjectMocks
  TodoBusinessImpl todoBusinessImpl;

  @Captor
  ArgumentCaptor<String> argumentCaptor;

  @Test
  public void test() {

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Rishi");

    assertNotNull(filteredTodos);
    assertEquals(2, filteredTodos.size());
    assertEquals(filteredTodos.get(0), "Learn Spring MVC");
    assertEquals(filteredTodos.get(1), "Learn Spring Boot");
  }

  @Test
  public void testMethodCalling() {

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    todoBusinessImpl.deleteTodosNotRelatedToSpring("Rishi");

    verify(todoServiceMock, times(1)).deleteTodo("Learn JUnit testing");
    verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
    verify(todoServiceMock, never()).deleteTodo("Learn Spring Boot");
  }

  @Test
  public void test_captureArguments() {

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    todoBusinessImpl.deleteTodosNotRelatedToSpring("Rishi");

    verify(todoServiceMock).deleteTodo(argumentCaptor.capture());
    assertEquals(argumentCaptor.getValue(), "Learn JUnit testing");
  }

  @Test
  public void test_captureMultipleArguments() {

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing", "Learn Skating");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    todoBusinessImpl.deleteTodosNotRelatedToSpring("Rishi");

    verify(todoServiceMock, times(2)).deleteTodo(argumentCaptor.capture());
    assertEquals(argumentCaptor.getAllValues().size(), 2);
  }
}
