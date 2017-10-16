package com.suru.j8.test.functions;

import java.util.function.Function;

class Employee {
	private String name;
	private Manager manager;

	public Employee(String name, Manager manager) {
		this.name = name;
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", manager=" + manager + "]";
	}

}

class Manager {
	private String name;
	private Employee employee;
	private Manager asstManager;

	public Manager(String name, Employee employee, Manager asstManager) {
		this.name = name;
		this.employee = employee;
		this.asstManager = asstManager;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Manager getAsstManager() {
		return asstManager;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", employee=" + employee + ", asstManager=" + asstManager + "]";
	}

}

public class AndThenAndComposeExample {

	public static void main(String[] args) {
		new AndThenAndComposeExample().testThisExample();
	}

	private void testThisExample() {
		Manager asstManager = new Manager("asst. Jack", null, null);
		Manager manager = new Manager("man. Sam", null, asstManager);
		Employee employee = new Employee("emp. Viky", manager);

		Function<Employee, Manager> managerForEmployee = e -> e.getManager();
		Function<Manager, Manager> astManagerForManager = m -> m.getAsstManager();

		Function<Employee, Manager> astManagerForEmployee = managerForEmployee.andThen(astManagerForManager);

		System.out.println(astManagerForEmployee.apply(employee));

		
		// compose is reverse to andThen
		
		Function<Employee, Manager> astManagerForEmployeeCompose = astManagerForManager.compose(managerForEmployee);

		System.out.println(astManagerForEmployeeCompose.apply(employee));

	}

}
