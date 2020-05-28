package com.JUnitCodeExamples.junit.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringHelperTest {
	StringHelper helper;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All.");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("After all.");
	}

	@BeforeEach
	public void creatingHelper() {
		helper = new StringHelper();
		System.out.println("Creating a new Helper Class instance.");
	}

	@AfterEach
	public void deletingHelper() {
		helper = null;
		System.out.println("Deleting the Helper instance created.");
	}

	@Test
	void test() {
		assertEquals("ABC", "ABC");
	}

	@Test
	void testTruncateAInFirst2PositionsTest() {

		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegative() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositive() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

	@Test
	public void testArraySort() {
		int[] arr1 = { 12, 3, 1, 4 };
		int[] arr2 = { 1, 3, 4, 12 };

		Arrays.sort(arr1);
		assertArrayEquals(arr1, arr2, " checking sort method of Arrays");

	}

	@Test()
	public void testNullArray() {
		int[] nullArr = null;
		Assertions.assertThrows(NullPointerException.class, ()->{
			Arrays.sort(nullArr);
		});
	}
}
