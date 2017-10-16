package com.suru.j8.test.lambdas;

public class ConstructorReferenceExample {

	class IMovie {
		int id;
		String name;

		public IMovie(int id) {
			this.id = id;
		}

		public IMovie(int id, String name) {
			this.id = id;
			this.name = name;
		}

	}

	public static void main(String[] args) {
		new ConstructorReferenceExample().testThisExampel();
	}

	interface MovieFactory {
		public IMovie create(int id);
	}

	interface NameMovieFactory {
		public IMovie create(int id, String name);
	}

	private void testThisExampel() {
		// with out java 8
		MovieFactory factory1 = new MovieFactory() {

			@Override
			public IMovie create(int id) {
				return new IMovie(id);
			}
		};

		// with java 8
		// one of the constructors signature and create method signature same
		// directly go for public IMovie(int id) constructor
		MovieFactory factory2 = IMovie::new;

		// directly go for public IMovie(int id, String name) constructor
		NameMovieFactory nameMovieFactory = IMovie::new;
		
		factory1.create(10);
		factory2.create(12);
		nameMovieFactory.create(1, "Spy");

	}

}
