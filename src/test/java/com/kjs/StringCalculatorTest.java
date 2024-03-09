package com.kjs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	public void ensureNullStringIsHandled() throws StringCalculatorException {
		assertEquals(0, StringCalculator.add(null));
	}
	
	@Test
	public void ensureEmptyStringIsHandled() throws StringCalculatorException {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void ensureSingleValueIsHandled() throws StringCalculatorException {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void ensureTwoValuesAreAdded() throws StringCalculatorException {
		assertEquals(15, StringCalculator.add("8,7"));
	}
	
	@Test
	public void ensureMoreThanTwoValuesAreHandled() throws StringCalculatorException {
		assertEquals(6, StringCalculator.add("1,2,3"));
	}
	
	@Test
	public void ensureNewLinesHandledAsDelimiter() throws StringCalculatorException {
		assertEquals(6, StringCalculator.add("1,2\n3"));
	}
	
	@Test
	public void ensureCustomDelimiterHandled() throws StringCalculatorException {
		assertEquals(10, StringCalculator.add("//;\n1,2\n3;4"));
	}
	
	@Test
	public void ensureNonNumericValueCausesException() {
		try {
			StringCalculator.add("1,a");
			fail("Expected Exception");
		}
		catch (StringCalculatorException e) {
			assertEquals("Non numeric value provided", e.getMessage());
		}
	}
}
