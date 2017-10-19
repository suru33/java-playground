package com.suru.j8.test.streams;

import java.util.Optional;

public class OptionalExamples {

	public static void main(String[] args) {
		new OptionalExamples();
	}

	public OptionalExamples() {
		// creating Optional type from Object
		// if object is null throws a NullPointerException
		SEmployee e1 = new SEmployee(1, "John", 1500, .25, true);
		Optional<SEmployee> employeeOptional1 = Optional.of(e1);

		// creating Optional type from Object with safe null check
		// if object is null creates as Optional.empty type
		SEmployee e2 = null;
		Optional<SEmployee> employeeOptional2 = Optional.ofNullable(e2);

		System.out.println(employeeOptional1);
		System.out.println(employeeOptional2);

		// prints if object is not null
		employeeOptional1.ifPresent(System.out::println);
		// Won't print because employeeOptional2 is null
		employeeOptional2.ifPresent(System.out::println);

		// filter based on predicate provided
		// if employee is active print to console
		employeeOptional1.filter(SEmployee::isActive)
			.ifPresent(System.out::println);

		// won't execute because employeeOptional2 is Optional.empty (null)
		employeeOptional2.filter(SEmployee::isActive)
			.ifPresent(System.out::println);

		// map convert the object
		// prints a string with id and name ifPresent
		employeeOptional1.map(e -> e.getId() + " > " + e.getName())
			.ifPresent(System.out::println);

		// won't execute because employeeOptional2 is Optional.empty (null)
		employeeOptional2.map(e -> e.getId() + " > " + e.getName())
			.ifPresent(System.out::println);

		// gives a default value if optional is empty or null
		// in this case employeeOptional1 is not null so it returns same
		SEmployee defaultEmployee = new SEmployee(0, "N/A", 0, 0, false);
		SEmployee newEmp = employeeOptional1.orElse(defaultEmployee);
		System.out.println(newEmp);
		// in this case employeeOptional1 null so it returns default object
		newEmp = employeeOptional2.orElse(defaultEmployee);
		System.out.println(newEmp);

		// invoke a supplier to implement dynamic default value
		SEmployee orElseGet = employeeOptional2.orElseGet(() -> new SEmployee(-1, "NoName", -1, -1, false));
		System.out.println(orElseGet);

		Optional<String> flatMap = employeeOptional1.flatMap(e -> Optional.ofNullable(e.getName()));

		System.out.println(flatMap);

	}
}
