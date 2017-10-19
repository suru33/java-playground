package com.suru.j8.test.streams;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCollector {

	private List<SMovie> movieList = new DataProvider().getMoviesList();
	private List<TwoInts> twoIntList = new DataProvider().getTwoIntsList();

	public static void main(String[] args) {
		new CustomCollector();
	}

	public CustomCollector() {
		StringBuilder collectAsCsv1 = movieList.stream()
			.collect(new MovieNamesCsvCollector());
		System.out.println(collectAsCsv1);

		// 2nd method

		Supplier<StringBuilder> supplier = StringBuilder::new;
		BiConsumer<StringBuilder, SMovie> accumulator = (sb, m) -> sb.append(m.getName() + ", ");
		BiConsumer<StringBuilder, StringBuilder> combiner = (sb1, sb2) -> sb1.append(sb2);

		StringBuilder collectAsCsv2 = movieList.stream()
			.collect(supplier, accumulator, combiner);
		System.out.println(collectAsCsv2);

		twoIntsExample();

	}

	private void twoIntsExample() {
		Supplier<TwoInts> supplier = TwoInts::new;
		BiConsumer<TwoInts, TwoInts> accumulator = (i1, i2) -> i1.addIntsTwo(i2);
		BiConsumer<TwoInts, TwoInts> combiner = (i1, i2) -> i1.addIntsTwo(i2);

		TwoInts twoIntsSum = twoIntList.stream()
			.collect(supplier, accumulator, combiner);
		System.out.println(twoIntsSum);

	}

	// 1st method
	class MovieNamesCsvCollector implements Collector<SMovie, StringBuilder, StringBuilder> {

		@Override
		public Supplier<StringBuilder> supplier() {
			return StringBuilder::new;
		}

		@Override
		public BiConsumer<StringBuilder, SMovie> accumulator() {
			return (sb, m) -> sb.append(m.getName())
				.append(", ");
		}

		@Override
		public BinaryOperator<StringBuilder> combiner() {
			return (sb1, sb2) -> sb1.append(sb2);
		}

		@Override
		public Function<StringBuilder, StringBuilder> finisher() {
			return sb -> sb;
		}

		@Override
		public Set<Characteristics> characteristics() {
			return Stream.of(Characteristics.CONCURRENT, Characteristics.UNORDERED)
				.collect(Collectors.toSet());
		}

	}

}
