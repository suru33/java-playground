package com.suru.junit5examples.util;

public class StringUtil {

	public static String reverseString(String str) {
		return new StringBuffer(str).reverse()
			.toString();
	}

}
