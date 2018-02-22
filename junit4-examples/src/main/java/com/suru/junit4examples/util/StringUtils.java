package com.suru.junit4examples.util;

public class StringUtils {
	public String reverseString(String s) {
		return s == null ? null
				: new StringBuffer(s).reverse()
					.toString();
	}
}
