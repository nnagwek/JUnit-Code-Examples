package com.mockitoCodeExamples;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TodoServiceTestAsaMock {

	@Test
	public void testretrieveTodosRelatedToSpringAsMock() {
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testretrieveTodosRelatedToSpringBDD() {
		//GIVEN
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		//WHEN
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//THEN
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testEmptyList() {
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(0, filteredTodos.size());
	}

}
