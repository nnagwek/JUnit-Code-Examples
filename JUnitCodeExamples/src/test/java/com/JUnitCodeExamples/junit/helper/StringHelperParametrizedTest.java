package com.JUnitCodeExamples.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {
	StringHelper helper = new StringHelper();
	
	private String input;
	private Object expectedOutput;
	
	public StringHelperParametrizedTest(String input, Object expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals(expectedOutput, 
				helper.truncateAInFirst2Positions(input));
	}
	
	
	@Parameters
	public static Collection<Object[]> testConditions2() {
		Object expectedOutputs[][] = {
				{ "AACD", "CD" }, 
				{ "ACD", "CD" },
				{ "ABCD", false }, 
				{ "ABAB", true }
				};
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		assertEquals(expectedOutput, 
				helper.areFirstAndLastTwoCharactersTheSame(input));
	}
	
	
}
