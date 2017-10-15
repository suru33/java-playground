package com.suru.j8.test.lambdas;

public class TestLambdas {

	interface Greeting {
		public String sayHello(String s);
	}

	public void testGreeting(String s, Greeting g) {
		System.out.println(g.sayHello(s));
	}

	public static void main(String[] args) {
		new TestLambdas().testGreeting("Sam", (String s) -> "Hello, " + s);
		new TestLambdas().testGreeting("", (String s) -> s == null || s.isEmpty() ? "Something wrong!" : "Hello, " + s);
	}

}
