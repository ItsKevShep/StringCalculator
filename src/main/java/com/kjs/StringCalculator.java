package com.kjs;

public class StringCalculator {

	public static int add(String numbers) throws StringCalculatorException {
		if (numbers == null || numbers.equals("")) {
			return 0;
		}
		
		String[] numberParts = numbers.split(",");
		if (numberParts.length > 2) {
			throw new StringCalculatorException("More than two numbers provided");
		}
		
		int value = 0;
		for (String number : numbers.split(",")) {
			try {
				value += Integer.parseInt(number);
			}
			catch (NumberFormatException e) {
				throw new StringCalculatorException("Non numeric value provided");
			}
		}
		
		return value;
	}
}
