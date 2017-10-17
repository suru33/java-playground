package com.suru.j8.test.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

class SEmployee {
	private int id;
	private String name;
	private int salary;
	private double bonus;
	private boolean active;

	public SEmployee(int id, String name, int salary, double bonus, boolean active) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
		this.active = active;
	}

	public int getId() {
		return id;
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

	public boolean isActive() {
		return active;
	}

	public void printTotalSalary() {
		System.out.println("TEmployee [id=" + id + ", name=" + name + ", bonus=" + (salary * bonus / 100) + ", total="
				+ ((salary * bonus / 100) + salary) + "]");
	}

	@Override
	public String toString() {
		return "SEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus + ", active="
				+ active + "]";
	}

}

public class DataProvider {
	private Random random = new Random();

	public List<SEmployee> getRandomEmployeeData() {
		List<SEmployee> list = new ArrayList<>();

		for (int i = 1; i <= 50; i++) {
			list.add(new SEmployee(i, UUID.randomUUID()
				.toString()
				.replaceAll("[0-9\\-]", ""), random.nextInt(50000), random.nextInt(99), random.nextInt(99) < 44));
		}
		return list;
	}

	public List<SEmployee> getRandomDuplicateEmployeeData() {
		List<SEmployee> list = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {

			SEmployee sEmployee = new SEmployee(i, UUID.randomUUID()
				.toString()
				.replaceAll("[0-9\\-]", ""), random.nextInt(50000), random.nextInt(99), random.nextInt(99) < 44);
			list.add(sEmployee);
			list.add(sEmployee);
		}
		return list;
	}

}
