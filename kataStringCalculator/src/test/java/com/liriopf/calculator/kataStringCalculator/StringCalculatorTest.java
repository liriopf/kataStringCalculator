package com.liriopf.calculator.kataStringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;


public class StringCalculatorTest {
	
	private final StringCalculator calculator = new StringCalculator();
	
	@Test
	public void addAnEmptyString() {
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void addAnStringNotEmpty() {
		assertEquals(1, calculator.add("1"));
		assertEquals(2, calculator.add("2"));
	}
	
	@Test 
	public void addNumbersWithCommaSeparator() {
		assertEquals(3, calculator.add("1,2"));
		assertEquals(6, calculator.add("1,2,3"));
		assertEquals(2, calculator.add(", 2"));
		assertEquals(2, calculator.add(" ,2"));
	}
	
	@Test
	public void addNumbersWithOthersSeparator() {
		assertEquals(6, calculator.add("1\n2,3"));
	}

}
