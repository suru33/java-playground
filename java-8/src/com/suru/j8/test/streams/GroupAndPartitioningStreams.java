package com.suru.j8.test.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAndPartitioningStreams {

	private List<SMovie> moviesList = new DataProvider().getMoviesList();

	public static void main(String[] args) {
		new GroupAndPartitioningStreams();
	}

	public GroupAndPartitioningStreams() {
		// group by
		// collector group by genre
		Map<String, List<SMovie>> groupByGenre = moviesList.stream()
			.collect(Collectors.groupingBy(SMovie::getGenre));
		System.out.println(groupByGenre);

		// 2 levels of grouping
		// collector group by rating and group by genre
		Map<Integer, Map<String, List<SMovie>>> groupByRatingAndGenre = moviesList.stream()
			.collect(Collectors.groupingBy(SMovie::getRating, Collectors.groupingBy(SMovie::getGenre)));

		System.out.println(groupByRatingAndGenre);

		// partition based on a predicate
		// 2 groups based on year
		Map<Boolean, List<SMovie>> newMovies = moviesList.stream()
			.collect(Collectors.partitioningBy(this::newMoviePredicate));

		System.out.println(newMovies.get(true));
		// partition based on a predicate and grouping
		// new Movies and group by genre

		Map<Boolean, Map<String, List<SMovie>>> newMoviesGroupByGenre = moviesList.stream()
			.collect(Collectors.partitioningBy(this::newMoviePredicate, Collectors.groupingBy(SMovie::getGenre)));

		System.out.println(newMoviesGroupByGenre.get(true));

		Map<Boolean, Map<Boolean, List<SMovie>>> partitionNewMoviesAndHighRated = moviesList.stream()
			.collect(Collectors.partitioningBy(this::newMoviePredicate,
					Collectors.partitioningBy(this::highRatedMoviePredicate)));

		System.out.println(partitionNewMoviesAndHighRated);

	}

	// predicate for new movie checking
	private boolean newMoviePredicate(SMovie movie) {
		return movie.getYear() > 1990;
	}

	// high rated movie predicate
	private boolean highRatedMoviePredicate(SMovie movie) {
		return movie.getRating() >= 5;
	}
}
