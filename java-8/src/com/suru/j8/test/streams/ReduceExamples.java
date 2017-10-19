package com.suru.j8.test.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class ReduceExamples {
	private List<SEmployee> randomEmployeeData = new DataProvider().getRandomEmployeeData();

	public static void main(String[] args) {
		new ReduceExamples();
	}

	public ReduceExamples() {

		// reduce for aggregation

		Optional<Double> reduce = randomEmployeeData.stream()
			.map(SEmployee::getBonus)
			.reduce(Double::sum);

		// Using BinaryOperator
		Optional<String> reduce2 = randomEmployeeData.stream()
			.map(SEmployee::getName)
			.reduce(new BinaryOperator<String>() {

				@Override
				public String apply(String t, String u) {
					return t + ", " + u;
				}
			});

		// Using lambda
		Optional<String> reduce3 = randomEmployeeData.stream()
			.map(SEmployee::getName)
			.reduce((a, b) -> a + ", " + b);

		System.out.println(reduce.get());
		System.out.println(reduce2);
		System.out.println(reduce3);

		IntStream ints = IntStream.of(1, 2, 3, 4);
		int reduce4 = ints.reduce(10, Integer::sum);
		System.out.println("sum along with 10: " + reduce4);
	}

}
