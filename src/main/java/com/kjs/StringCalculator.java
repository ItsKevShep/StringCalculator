package com.kjs;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	private static final List<String> DELIMITERS = new ArrayList<String>();
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	
	static {
		DELIMITERS.add(",");
		DELIMITERS.add("\n");
	}

	public static int add(String numbers) throws StringCalculatorException {
		if (numbers == null || numbers.equals("")) {
			return 0;
		}
		
		List<String> delimiterValues = new ArrayList<String>(DELIMITERS);
		if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
			int firstNewLine = numbers.indexOf("\n");
			delimiterValues.add(numbers.substring(CUSTOM_DELIMITER_PREFIX.length(), firstNewLine));
			numbers = numbers.substring(firstNewLine).trim();
		}
		
		for (int i = 1; i < delimiterValues.size(); ++i) {
			numbers = numbers.replaceAll(delimiterValues.get(i), delimiterValues.get(0));
		}
		
		int value = 0;
		String invalidValues = "";
		for (String number : numbers.split(DELIMITERS.get(0))) {
			try {
				int numericValue = Integer.parseInt(number);
				if (numericValue < 0) {
					invalidValues += number + ",";
				}
				value += numericValue;
			}
			catch (NumberFormatException e) {
				throw new StringCalculatorException("Non numeric value provided");
			}
		}
		
		if (!invalidValues.isEmpty()) {
			throw new StringCalculatorException("Negatives not allowed: " + invalidValues.substring(0, invalidValues.length() - 1));
		}
		
		return value;
	}
}
