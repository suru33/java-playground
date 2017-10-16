package com.suru.j8.test.functions;

import java.util.function.Supplier;

public class SupplierExample {

	private Supplier<String[]> fruits = () -> new String[] { "Orange", "Lemon", "Mango" };

	public static void main(String[] args) {
		new SupplierExample().testThisExample();
	}

	private void testThisExample() {
		String[] strings = fruits.get();
		for (String string : strings) {
			System.out.println(string);
		}
	}
}
