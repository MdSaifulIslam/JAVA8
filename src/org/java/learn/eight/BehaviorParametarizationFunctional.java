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

public class BehaviorParametarizationFunctional {

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
		//Predicate<Integer> predicate = (i) -> i % 2 == 0;

		System.out.println("Even Numbers...");
		printOnLogic(numbers, printConsumer, i -> i % 2 == 0);
		
		System.out.println("Odd Numbers...");
		printOnLogic(numbers, printConsumer, i -> i % 2 != 0);
		
		System.out.println("Multiply of three...");
		printOnLogic(numbers, printConsumer, i -> i % 3 == 0);

	}

	private static void printOnLogic(List<Integer> numbers, Consumer<Integer> printConsumer,
			Predicate<Integer> predicate) {
		numbers.stream().filter(predicate).forEach(printConsumer);
	}

}
