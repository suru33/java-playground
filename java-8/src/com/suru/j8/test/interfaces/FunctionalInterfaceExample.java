package com.suru.j8.test.interfaces;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		new FunctionalInterfaceExample().testThisExample();
	}

	// annotation is optional use to let developer and implementors
	// to know about the given interface is functional interface
	// implementors will not modify the interface structure

	@FunctionalInterface
	interface Car {
		public boolean start();
	}

	private void testThisExample() {
		Car alwaysStart = () -> true;
		alwaysStart.start();
	}
}
