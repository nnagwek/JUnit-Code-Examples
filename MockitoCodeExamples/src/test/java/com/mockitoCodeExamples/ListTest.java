package com.mockitoCodeExamples;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testListSize() {
		List mocklist = mock(List.class);
		when(mocklist.size()).thenReturn(10);
		
		assertEquals(10, mocklist.size());
	}
	
	@Test
	public void testListSizeWithMultipleReturnValues() {
		List mocklist = mock(List.class);
		when(mocklist.size()).thenReturn(10).thenReturn(20);
		
		assertEquals(10, mocklist.size());
		assertEquals(20, mocklist.size());
	}
	
	@Test
	public void testListGet() {
		List mocklist = mock(List.class);
		when(mocklist.get(0)).thenReturn("First Value");
		
		assertEquals("First Value" , mocklist.get(0));
		assertEquals( null  , mocklist.get(1));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testListGetBDD() {
		//Given
		List mocklist = mock(List.class);
		given(mocklist.get(0)).willReturn("First Value");
		
		// when
		String firstElement = (String) mocklist.get(0);
		
		//then
		assertThat(firstElement, is("First Value"));
	}
	
	@Test
	public void testListGetWithAny() {
		List mocklist = mock(List.class);
		when(mocklist.get(anyInt())).thenReturn("First Value");
		
		assertEquals("First Value" , mocklist.get(20));
	}

	@Test(expected = RuntimeException.class)
	public void testListThrowingAnException() {
		List mocklist = mock(List.class);
		when(mocklist.get(anyInt())).thenThrow(new RuntimeException("Somenting is messed up"));
		
		 mocklist.get(20);
	}
	
	@Test(expected = RuntimeException.class)
	public void testListThrowingAnException_MixingUp() {
		List mocklist = mock(List.class);
		when(mocklist.subList(anyInt(), 5)).thenThrow(new RuntimeException("Somenting is messed up"));
		
		 mocklist.subList(20,5);
	}
}
