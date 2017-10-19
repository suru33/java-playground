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

class SMovie {
	private int id;
	private String name;
	private int year;
	private String genre;
	private int rating;
	private String[] actors;

	public SMovie(int id, String name, int year, String genre, int rating) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "SMovie [id=" + id + ", name=" + name + ", year=" + year + ", genre=" + genre + ", rating=" + rating
				+ "]";
	}

}

class TwoInts {
	private int numberOne;
	private int numberTwo;

	public TwoInts() {
	}

	public TwoInts(int numberOne, int numberTwo) {
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}

	public int getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	public int getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	public void addIntsTwo(TwoInts i) {
		numberOne += i.getNumberOne();
		numberTwo += i.getNumberTwo();
	}

	@Override
	public String toString() {
		return "TwoInts [numberOne=" + numberOne + ", numberTwo=" + numberTwo + "]";
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

	public List<SMovie> getMoviesList() {
		List<SMovie> movies = new ArrayList<>();
		movies.add(new SMovie(1, "The Shawshank Redemption", 1994, "drama", 4));
		movies.add(new SMovie(2, "The Godfather", 1972, "crime", 4));
		movies.add(new SMovie(3, "The Godfather II", 1974, "crime", 5));
		movies.add(new SMovie(4, "The Good, the Bad, and the Ugly", 1966, "romance", 9));
		movies.add(new SMovie(5, "Pulp Fiction", 1994, "action", 4));
		movies.add(new SMovie(6, "Schindler's List", 1993, "thriller", 7));
		movies.add(new SMovie(7, "12 Angry Men", 1957, "action", 2));
		movies.add(new SMovie(8, "One Flew Over The Cuckoo's Nest", 1975, "crime", 5));
		movies.add(new SMovie(9, "The Dark Knight", 2008, "action", 5));
		movies.add(new SMovie(10, "Fight Club", 1999, "action", 5));
		movies.add(new SMovie(11, "Inception", 2010, "thriller", 5));
		movies.add(new SMovie(12, "The Matrix", 1999, "si-fi", 5));
		movies.add(new SMovie(13, "Star Wars", 1977, "si-fi", 5));
		movies.add(new SMovie(14, "Seven Samurai", 1954, "action", 9));
		movies.add(new SMovie(15, "Se7en", 1995, "thriller", 9));
		movies.add(new SMovie(16, "The Silence of the Lambs", 1991, "thriller", 9));
		movies.add(new SMovie(17, "The Usual Suspects", 1995, "crime", 3));
		movies.add(new SMovie(18, "It's a Wonderful Life", 1946, "romance", 6));
		movies.add(new SMovie(19, "Life Is Beautiful", 1997, "romance", 9));
		movies.add(new SMovie(20, "Once Upon a Time in the West", 1968, "action", 9));
		movies.add(new SMovie(21, "Leon: The Professional", 1994, "drama", 9));
		movies.add(new SMovie(22, "Interstellar", 2014, "drama", 9));
		movies.add(new SMovie(23, "American History X", 1998, "crime", 9));
		movies.add(new SMovie(24, "Psycho", 1960, "thriller", 9));
		movies.add(new SMovie(25, "Rear Window", 1954, "drama", 9));
		movies.add(new SMovie(26, "Casablanca", 1942, "romance", 5));
		movies.add(new SMovie(27, "City Lights", 1931, "action", 5));
		movies.add(new SMovie(28, "Raiders of the Lost Ark", 1981, "si-fi", 5));
		movies.add(new SMovie(29, "Terminator 2: Judgment Day", 1991, "si-fi", 5));
		movies.add(new SMovie(30, "Back to the Future", 1985, "si-fi", 5));
		return movies;
	}

	public List<TwoInts> getTwoIntsList() {
		List<TwoInts> ints = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			TwoInts ix = new TwoInts(i + 1, i * random.nextInt(10));
			ints.add(ix);
		}
		return ints;
	}

	public List<SMovie> getMoviesWithActors() {
		List<SMovie> movies = new ArrayList<>();
		SMovie m1 = new SMovie(1, "The Shawshank Redemption", 1994, "drama", 4);
		m1.setActors(new String[] { "Tim Robbins", "Morgan Freeman", "Bob Gunton", "William Sadler", "Clancy Brown",
				"Gil Bellows", "James Whitmore" });
		SMovie m2 = new SMovie(2, "The Godfather", 1972, "crime", 4);
		m2.setActors(new String[] { "Marlon Brando", "Al Pacino", "James Caan", "Richard Castellano", "Robert Duvall",
				"Sterling Hayden", "John Marley", "Richard Conte", "Diane Keaton" });
		SMovie m3 = new SMovie(3, "The Godfather II", 1974, "crime", 5);
		m3.setActors(new String[] { "Al Pacino", "Robert Duvall", "Diane Keaton", "Robert De Niro", "Talia Shire",
				"Morgana King", "John Cazale", "Marianna Hill", "Lee Strasberg" });
		SMovie m4 = new SMovie(4, "The Good, the Bad, and the Ugly", 1966, "romance", 9);
		m4.setActors(new String[] { "Clint Eastwood", "Lee Van Cleef", "Aldo Giuffrè", "Mario Brega", "Eli Wallach" });
		SMovie m5 = new SMovie(5, "Pulp Fiction", 1994, "action", 4);
		m5.setActors(new String[] { "John Travolta", "Samuel L. Jackson", "Uma Thurman", "Harvey Keitel", "Tim Roth",
				"manda Plummer", "Maria de Medeiros", "Ving Rhames", "Eric Stoltz", "Rosanna Arquette",
				"Christopher Walken", "Bruce Willis" });
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		return movies;
	}

}
