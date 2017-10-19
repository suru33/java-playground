package com.suru.j8.test.streams;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapRangeAndSummaryStatistics {

	List<SMovie> movies = new DataProvider().getMoviesWithActors();

	public static void main(String[] args) {
		new FlatMapRangeAndSummaryStatistics();
	}

	public FlatMapRangeAndSummaryStatistics() {
		// flat map

		// flats the inner lists

		Stream<String> flatMap = movies.stream()
			.flatMap(movie -> Stream.of(movie.getActors()));

		flatMap.forEach(System.out::println);

		// Summary Statistics

		DoubleSummaryStatistics summaryStatistics = movies.stream()
			.collect(Collectors.summarizingDouble(SMovie::getRating));

		System.out.println(summaryStatistics);

		IntStream range = IntStream.range(1, 10);
		IntStream rangeClosed = IntStream.rangeClosed(1, 10);

		range.forEach(i -> System.out.print(i + " "));
		System.out.println();
		rangeClosed.forEach(i -> System.out.print(i + " "));

		range = IntStream.range(1, 10);
		OptionalDouble average = range.average();
		System.out.println("\navg: " + average);

	}

}
