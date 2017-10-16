package com.suru.j8.test.functions;

import java.util.function.Consumer;

class XMovie {
	private String name;
	private int year;

	public XMovie(String name, int year) {
		this.name = name;
		this.year = year;
	}

	@Override
	public String toString() {
		return "XMovie [name=" + name + ", year=" + year + "]";
	}
}

public class ConsumerExample {

	public static void main(String[] args) {
		new ConsumerExample().testThisExample();
	}

	private void testThisExample() {
		Consumer<XMovie> notifyConsumer = this::notifyXMovie;
		Consumer<XMovie> persistConsumer = this::persistXMovie;
		Consumer<XMovie> printConsumer = this::printXMovie;
		Consumer<XMovie> chainConsumer = notifyConsumer.andThen(persistConsumer).andThen(printConsumer);

		XMovie movie = new XMovie("Die another day", 2001);
		chainConsumer.accept(movie);
	}

	private void notifyXMovie(XMovie movie) {
		System.out.println("notify: " + movie);
	}

	private void persistXMovie(XMovie movie) {
		System.out.println("persist: " + movie);
	}

	private void printXMovie(XMovie movie) {
		System.out.println("print: " + movie);
	}

}
