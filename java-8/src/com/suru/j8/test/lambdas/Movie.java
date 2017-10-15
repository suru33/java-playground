package com.suru.j8.test.lambdas;

public class Movie {

	private int age;
	private int rank;
	private String name;

	public Movie(int age, int rank, String name) {
		this.age = age;
		this.rank = rank;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}