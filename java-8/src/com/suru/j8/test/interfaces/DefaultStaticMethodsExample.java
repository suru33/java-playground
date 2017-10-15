package com.suru.j8.test.interfaces;

// not a functional interface because interface has 2 abstract methods
interface ModelMaker {
	public String getModel();

	public void make();

	// default method
	default public void prepare() {
		System.out.println("prepare the model");
	}

	static public void easyIn(String in) {
		System.out.println("Easy IN: " + in);
	}
}

public class DefaultStaticMethodsExample {

	public static void main(String[] args) {
		ModelMaker modelMaker = new ModelMaker() {

			@Override
			public void make() {
				System.out.println("Making the model");
			}

			@Override
			public String getModel() {
				return "prepared model";
			}
		};

		modelMaker.prepare();
		modelMaker.make();
		System.out.println(modelMaker.getModel());
		ModelMaker.easyIn("in the EasyIU");
	}

}
