package com.liriopf.calculator.kataStringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String items) {
		int result = 0;
		List<String> values = getValues(items);
		for(String value: values) {
			result = result + convertToInt(value);
		}
		return result;
	}
	
	private List<String> getValues(String items) {
		List<String> values = new ArrayList<String>();
		StringBuffer value = new StringBuffer();
		for(int i = 0; i<items.length(); i++) {
			String digit = getChar(items, i);
			boolean isDigit = isADigit(digit);
			if(isDigit) {
				value.append(digit);
			}
			if(i+1==items.length()|| !isDigit) {
			 	values.add(value.toString());
				value = new StringBuffer() ;
			}
		}
		return values;
	}
	
	private String getChar(String value, int index) {
		if(index<value.length()) {
			return value.substring(index, index+1);
		}else {
			return "";
		}
	}
	
	private boolean isADigit(String value) {
		return value.compareTo("0")>=0 && value.compareTo("9")<=0;
	}

	private int convertToInt(String value) {
		if(value.trim().length()>0) {
			return Integer.valueOf(value.trim());
		}
		return 0;
	}

}
