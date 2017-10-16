package com.suru.j8.test.functions;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

class TEmployee {
	private int id;
	private String name;
	private int salary;
	private double bonus;

	public TEmployee(int id, String name, int salary, double bonus) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public double getBonusAmount() {
		return bonus * salary / 100;
	}

	public void printTotalSalary() {
		System.out.println("TEmployee [id=" + id + ", name=" + name + ", bonus=" + (salary * bonus / 100) + ", total="
				+ ((salary * bonus / 100) + salary) + "]");
	}

	@Override
	public String toString() {
		return "TEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus + "%]";
	}

}

public class BiExamples {
	public static void main(String[] args) {
		new BiExamples().testThisExample();
	}

	private void testThisExample() {
		TEmployee employee1 = new TEmployee(1, "John", 15000, 6.99);
		TEmployee employee2 = new TEmployee(2, "Mary", 1000, 15);
		TEmployee employee3 = new TEmployee(1, "Will T", 13500, 3);

		// BiPredicate test
		BiPredicate<TEmployee, TEmployee> e1SalaryGTe2Salary = (e1, e2) -> e1.getSalary() > e2.getSalary();
		BiPredicate<TEmployee, TEmployee> e1BounsGTe2Bonus = (e1, e2) -> e1.getBonus() > e2.getBonus();
		BiPredicate<TEmployee, TEmployee> e1BounsAmountGTe2BonusAmount = (e1,
				e2) -> e1.getBonusAmount() > e2.getBonusAmount();
		BiPredicate<TEmployee, TEmployee> e1GTe2 = e1SalaryGTe2Salary.and(e1BounsAmountGTe2BonusAmount);

		System.out.println("is employee1 salary gt employee2: " + e1SalaryGTe2Salary.test(employee1, employee2));
		System.out.println("is employee1 bonus gt employee2: " + e1BounsGTe2Bonus.test(employee1, employee2));
		System.out.println("is employee1 gt employee2: " + e1GTe2.test(employee1, employee2));

		// BiConsumer test
		BiConsumer<TEmployee, TEmployee> printEmployees = (e1, e2) -> {
			System.out.println(e1);
			System.out.println(e2);
		};

		BiConsumer<TEmployee, TEmployee> printTotals = (e1, e2) -> {
			e1.printTotalSalary();
			e2.printTotalSalary();
		};

		BiConsumer<TEmployee, TEmployee> chainBiConsumer = printEmployees.andThen(printTotals);
		chainBiConsumer.accept(employee2, employee3);

		BiFunction<TEmployee, TEmployee, TEmployee> e1PlusE2 = (e1, e2) -> {
			TEmployee employee = new TEmployee(-1, e1.getName() + " and " + e2.getName(),
					e1.getSalary() + e2.getSalary(), e1.getBonus() + e2.getBonus());
			return employee;
		};

		TEmployee e1AndE2 = e1PlusE2.apply(employee1, employee2);
		System.out.println(e1AndE2);

	}
}
