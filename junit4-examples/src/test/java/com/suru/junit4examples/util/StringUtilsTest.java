package com.suru.junit4examples.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testReverseString() {
		StringUtils stringUtils = new StringUtils();
		// success case 1
		assertEquals("CBA", stringUtils.reverseString("ABC"));
		
		// success case 2
		assertEquals(null, stringUtils.reverseString(null));
		
		// success case 3 - not equal
		assertNotEquals("QWERTY", stringUtils.reverseString("ABCDEF"));
		
		// fail case -1 both are equal but used assertNotEquals() 
		assertNotEquals("FREE", stringUtils.reverseString("EERF"));
	}

}
