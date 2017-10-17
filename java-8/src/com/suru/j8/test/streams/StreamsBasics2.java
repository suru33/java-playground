package com.suru.j8.test.streams;

import java.util.List;
import java.util.Optional;

public class StreamsBasics2 {

	private List<SEmployee> randomEmployeeData = new DataProvider().getRandomEmployeeData();

	public static void main(String[] args) {
		new StreamsBasics2();
	}

	public StreamsBasics2() {
		Optional<SEmployee> findFirst = randomEmployeeData.stream()
			.findFirst(); // find fist and discards next elements
		System.out.println(findFirst.get());

		Optional<SEmployee> findAny = randomEmployeeData.stream()
			.findAny(); // find any and discards rest
						// this operation shows difference while using parallel streams
		System.out.println(findAny.get());

		boolean anyMatch = randomEmployeeData.stream()
			.anyMatch(SEmployee::isActive); // checks any based on predicate provided
											// checks any active employee is present or not
		System.out.println(anyMatch);

		boolean allMatch = randomEmployeeData.stream()
			.allMatch(emp -> emp.getId() > 0); // checks all based on predicate provided
												// checks all employee id > 0
		System.out.println(allMatch);

		boolean noneMatch = randomEmployeeData.stream()
			.noneMatch(SEmployee::isActive); // check none elements satisfy predicate provided
												// checks no employees are active
		System.out.println(noneMatch);
	}

}
