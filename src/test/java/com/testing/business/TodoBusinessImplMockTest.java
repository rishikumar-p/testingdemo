package com.testing.business;

import com.testing.api.TodoService;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

  @Test
  public void test() {
    TodoService todoServiceMock = mock(TodoService.class);

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Rishi");

    assertNotNull(filteredTodos);
    assertEquals(2, filteredTodos.size());
    assertEquals(filteredTodos.get(0), "Learn Spring MVC");
    assertEquals(filteredTodos.get(1), "Learn Spring Boot");
  }

  @Test
  public void testMethodCalling() {
    TodoService todoServiceMock = mock(TodoService.class);

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("Rishi");

    verify(todoServiceMock, times(1)).deleteTodo("Learn JUnit testing");
    verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
    verify(todoServiceMock, never()).deleteTodo("Learn Spring Boot");
  }

  @Test
  public void test_captureArguments() {

    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    TodoService todoServiceMock = mock(TodoService.class);

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("Rishi");

    verify(todoServiceMock).deleteTodo(argumentCaptor.capture());
    assertEquals(argumentCaptor.getValue(), "Learn JUnit testing");
  }

  @Test
  public void test_captureMultipleArguments() {
    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    TodoService todoServiceMock = mock(TodoService.class);

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn JUnit testing", "Learn Skating");
    when(todoServiceMock.retrieveTodos(any())).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("Rishi");

    verify(todoServiceMock, times(2)).deleteTodo(argumentCaptor.capture());
    assertEquals(argumentCaptor.getAllValues().size(), 2);
  }

}
