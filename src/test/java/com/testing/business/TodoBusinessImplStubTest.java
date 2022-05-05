package com.testing.business;

import com.testing.api.TodoService;
import com.testing.api.TodoServiceStub;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TodoBusinessImplStubTest {

  @Test
  public void test() {
    TodoService todoServiceStub = new TodoServiceStub();
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Rishi");
    assertNotNull(filteredTodos);
    assertEquals(2, filteredTodos.size());
    assertEquals(filteredTodos.get(0), "Learn Spring MVC");
    assertEquals(filteredTodos.get(1), "Learn Spring Boot");
  }

}
