package com.kjs;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	private static final List<String> DELIMITERS = new ArrayList<String>();
	
	static {
		DELIMITERS.add(",");
		DELIMITERS.add("\n");
	}

	public static int add(String numbers) throws StringCalculatorException {
		if (numbers == null || numbers.equals("")) {
			return 0;
		}
		
		for (int i = 1; i < DELIMITERS.size(); ++i) {
			numbers = numbers.replaceAll(DELIMITERS.get(i), DELIMITERS.get(0));
		}
		
		int value = 0;
		for (String number : numbers.split(DELIMITERS.get(0))) {
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
