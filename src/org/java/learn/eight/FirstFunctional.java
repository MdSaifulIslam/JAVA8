package org.java.learn.eight;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Saiful
 *
 */

public class FirstFunctional {

	public static void main(String[] args) {

		printNumberInFunctionalApproach(List.of(4, 6, 7, 12, 54, 54));

	}

//	private static void print(int number) {
//		System.out.println(number);
//	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printNumberInFunctionalApproach(List<Integer> numbers) {
		Consumer<Integer> printConsumer = System.out::println;
		numbers.stream().forEach(printConsumer);

		System.out.println("Even Numbers...");

		numbers.stream().filter((i) -> {
			if (i % 2 == 0) {
				return i % 3 == 0;
			}
			return false;
		}).forEach(printConsumer);

		System.out.println("Divided By [3] Numbers...");

		numbers.stream().filter(FirstFunctional::isEven).filter(i -> i % 3 == 0).forEach(printConsumer);

		Predicate<? super Integer> isEvenPredicate = i -> i % 2 == 0;
		Function<? super Integer, ? extends Integer> dataMapper = x -> x / 2;
		
		Consumer<Integer> printConsumer2 = new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println(t);
			}
		};

		Function<Integer, Integer> dataMapper2 = new Function<Integer, Integer>() {
			public Integer apply(Integer t) {
				return t / 2;
			}
		};

		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};

		System.out.println("Functional Interface: ==>");
		numbers.stream().filter(isEvenPredicate2).map(dataMapper2).forEach(printConsumer2);

		System.out.println("reduce functional interface: ==>>");
		BinaryOperator<Integer> sumAccumulator = Integer::sum;
		BinaryOperator<Integer> sumAccumulator2 = new BinaryOperator<Integer>() {
			public Integer apply(Integer t, Integer u) {
				return t + u + 3;
			}
		};
		System.out.println(numbers.stream().reduce(0, sumAccumulator2));
	}

}
