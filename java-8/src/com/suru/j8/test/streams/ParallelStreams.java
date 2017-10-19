package com.suru.j8.test.streams;

import java.util.List;

public class ParallelStreams {

	List<SMovie> movies = new DataProvider().getMoviesList();

	public static void main(String[] args) {
		new ParallelStreams();
	}

	public ParallelStreams() {
		
		// serial stream single thread
		movies.stream()
			.filter(movie -> {
				System.out.println("Filter Id: " + movie.getId() + " thread: " + Thread.currentThread().getName());
				return movie.getRating() >= 5;
			})
			.map(movie -> {
				System.err.println("Map Id: " + movie.getId() + " thread: " + Thread.currentThread().getName());
				return movie.getName();
			}).forEach(movie -> {});
		
		//parallel stream multiple cores and threads 
		movies.stream()
			.parallel() // convert stream to parallel stream or use parallelStream()  
			.filter(movie -> movie.getRating() >= 5)
			.peek(movie -> System.out.println("\nFilter Id: " + movie.getId() + " thread: " + Thread.currentThread().getName()))
			.map(SMovie::getRating)
			.peek(rating -> System.err.println("\nrating: " + rating + " thread: " + Thread.currentThread().getName()))
			.reduce(Integer::sum);
	} 
}
