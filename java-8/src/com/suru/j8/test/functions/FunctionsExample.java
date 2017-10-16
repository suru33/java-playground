package com.suru.j8.test.functions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionsExample {

	public static void main(String[] args) {
		new FunctionsExample().testThisExample();
	}

	private void testThisExample() {
		Supplier<Map<Integer, String>> dataSupplier = this::prepareData;
		Function<Integer, String> dataFunction = i -> dataSupplier.get().get(i);

		System.out.println(dataFunction.apply(1));

	}

	private Map<Integer, String> prepareData() {
		Map<Integer, String> data = new HashMap<>();
		data.put(1, "One");
		data.put(2, "Two");
		data.put(3, "Three");
		data.put(4, "Four");
		data.put(5, "Five");
		return data;
	}

}
