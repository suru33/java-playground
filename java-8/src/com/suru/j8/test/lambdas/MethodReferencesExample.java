package com.suru.j8.test.lambdas;

public class MethodReferencesExample {

	interface IMovieCheck {
		public boolean check(Movie m);
	}

	public static void main(String[] args) {
		IMovieCheck newMovie = movie -> movie.getAge() <= 10;
		// lambda
		IMovieCheck highRatedMovieLambda = movie -> movie.getRank() >= 1 && movie.getRank() <= 10;

		// method reference - static type
		IMovieCheck highRatedMovieMethodRef = MethodReferencesExample::isHighRatedMovie;

		MethodReferencesExample example = new MethodReferencesExample();
		// method reference - instance type
		IMovieCheck startWithA_MethodRef = example::isStartWithA;

		IMovieCheck startWithA = movie -> movie.getName().charAt(0) == 'A';

		Movie m1 = new Movie(15, 5, "Amber");

		System.out.println("New movie: " + newMovie.check(m1));
		System.out.println("High rated lambda: " + highRatedMovieLambda.check(m1));
		System.out.println("High rated ref: " + highRatedMovieMethodRef.check(m1));
		System.out.println("Start with A: " + startWithA.check(m1));
		System.out.println("Start with A method ref: " + startWithA_MethodRef.check(m1));

	}

	// method signature should be same with lambda method signature
	// static method reference implementation
	public static boolean isHighRatedMovie(Movie movie) {
		return movie.getRank() >= 1 && movie.getRank() <= 10;
	}

	// instance method reference implementation
	private boolean isStartWithA(Movie m) {
		return m.getName().charAt(0) == 'A';
	}

}
