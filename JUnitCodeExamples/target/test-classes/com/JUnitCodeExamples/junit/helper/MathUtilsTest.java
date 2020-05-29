package com.JUnitCodeExamples.junit.helper;

//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
	
	private MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
//	@BeforeAll
//	 static void init() {
//		System.out.println("Starting all the tests");
//	}
//	
//	@AfterAll
//	static void tearDown() {
//		System.out.println("Completed all the tests");
//	}
	
	@BeforeEach
	void initEach(TestInfo testInfo , TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
//		System.out.println("Starting the test");
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running the test using reporter  "+testInfo.getDisplayName()+" with tags " + testInfo.getTags());
	}
	
//	@AfterEach
//	void cleanupEach() {
//		System.out.println("Completed the test");
//		mathUtils = null;
//	}

	@Nested
	@Tag("Math")
	class AddTest {
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, mathUtils.add(1, 1), 
					"Add method should return the sum of two numbers");
		}
		
		@Test
		void testAddingTwoNegatives() {
			int actual = mathUtils.add(-1, -1);
			int expected = -2;
			assertEquals(expected, actual , 
					() -> "Add method should return "+expected+"but returned"+actual);
		}
		
		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, mathUtils.add(-1, 1), 
					"Add method should return the sum of two numbers");
		}
	}
	
	@Test 
	@DisplayName("Testing the multiply method")
	@Tag("Math")
	void testMultiply() {
		System.out.println("Running the test "+testInfo.getDisplayName()+" with tags " + testInfo.getTags());
//		Boolean isServerUp = false;
//		assumeTrue(isServerUp);
		assertAll(
				() -> assertEquals(0, mathUtils.multiply(1, 0)),
				() -> assertEquals(1, mathUtils.multiply(1, 1)),
				() -> assertEquals(6, mathUtils.multiply(2, 3))
				);
	}
	
	@Test
	@Tag("Circle")
	void computeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), 
				() -> "Should return right circle area");
	}
	
//	@Test 
//	void testDivideHappyPath() {
//		assertAll(
//				() -> assertEquals(2, mathUtils.divide(4, 2)),
//				() -> assertEquals(4, mathUtils.divide(8, 2))
//				);
//	}
	
	@RepeatedTest(3)
	@Tag("Math")
	void testDivide(RepetitionInfo repetitionInfo) {
		System.out.println(repetitionInfo.getCurrentRepetition());
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	
	@Test
	@Disabled
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	
}