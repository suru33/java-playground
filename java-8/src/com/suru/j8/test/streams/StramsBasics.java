package com.suru.j8.test.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StramsBasics {

	private List<SEmployee> randomEmployeeData = new DataProvider().getRandomEmployeeData();
	private List<SEmployee> randomEmployeeDuplicateData = new DataProvider().getRandomDuplicateEmployeeData();

	public static void main(String[] args) {
		new StramsBasics();
	}

	public StramsBasics() {
		// filter
		// filter employee salary > 40000 and active
		randomEmployeeData.stream()
			.filter(SEmployee::isActive) // filter active or not
			.filter(e -> e.getSalary() > 40000) // filter high salary
			.forEach(System.out::println); // print to console

		// map
		// convert one form to another form
		// get employee names whose salary > 40000
		// and convert to upper case
		randomEmployeeData.stream()
			.filter(this::isHighSalary) // filter high salary
			.map(SEmployee::getName) // map the names
			.map(String::toUpperCase) // convert to upper case
			.forEach(System.out::println); // print to console

		// collect

		List<SEmployee> highSalaryEmployeesList = randomEmployeeData.stream()
			.filter(SEmployee::isActive) // filter active or not
			.collect(Collectors.toList()); // collect as list

		System.out.println(highSalaryEmployeesList);

		Set<SEmployee> highSalaryEmployeesSet = randomEmployeeData.stream()
			.filter(SEmployee::isActive) // filter active or not
			.collect(Collectors.toSet()); // collect as set
		System.out.println(highSalaryEmployeesSet);

		Map<String, SEmployee> highSalaryEmployeesMap = randomEmployeeData.stream()
			.filter(SEmployee::isActive) // filter active or not
			// collect as map key: name and value: object it self
			.collect(Collectors.toMap(SEmployee::getName, emp -> emp));
		System.out.println(highSalaryEmployeesMap);

		// distinct
		randomEmployeeDuplicateData.stream()
			.distinct() // remove duplicates
			.forEach(System.out::println); // print to console

		// skip
		randomEmployeeDuplicateData.stream()
			.distinct()// remove duplicates
			.skip(5) // skip first 5 elements
			.forEach(System.out::println); // print to console

		// limit
		randomEmployeeDuplicateData.stream()
			.distinct()// remove duplicates
			.limit(5) // only first 5 elements
			.forEach(System.out::println); // print to console
	}

	// predicate definitions
	public boolean isHighSalary(SEmployee e) {
		return e.getSalary() > 40000;
	}

}
