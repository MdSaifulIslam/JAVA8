package org.java.learn.eight;

import java.util.List;

/**
 * @author Saiful
 *
 */

public class FirstFunctional {

	public static void main(String[] args) {

		printNumberInFunctionalApproach(List.of(4, 6, 7, 54, 54));

	}

//	private static void print(int number) {
//		System.out.println(number);
//	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printNumberInFunctionalApproach(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);

		System.out.println("Even Numbers...");

		numbers.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

		System.out.println("Divided By [3] Numbers...");

		numbers.stream().filter(FirstFunctional::isEven).filter(i -> i % 3 == 0).forEach(System.out::println);
	}

}
