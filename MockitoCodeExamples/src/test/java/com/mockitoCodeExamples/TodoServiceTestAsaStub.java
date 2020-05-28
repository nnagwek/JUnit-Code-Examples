package com.mockitoCodeExamples;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TodoServiceTestAsaStub {

	@Test
	public void test() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}

}
