package com.liriopf.practicalunittesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ReveresExerciseTest {

	private static final Object[] getValidString() {
		return new String[][] {{"",""},{"a","a"},{"amor","roma"},{"la casa de pandora", "arodnap ed asac al"}};
	}
	
	private static final Object[] getInvalidString() {
		return new String[][] {{null,null}};
	}
	
	@Test
	@Parameters(method = "getValidString")
	public void checkReverse(String value, String valueReverse) {
		assertEquals(valueReverse, ReveresExercise.reverse(value));
	}
	
	@Test(expected = NullPointerException.class)
	@Parameters (method = "getInvalidString")
	public void checkReverseForNull(String value, String valueReverse) {
		ReveresExercise.reverse(value);
	}
}
