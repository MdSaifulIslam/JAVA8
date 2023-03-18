package org.java.learn.eight;

import java.util.List;

/**
 * @author Saiful
 *
 */

public class JavaEight {

	public static void main(String[] args) {

		printEvenNumber(List.of(4, 6, 7, 54, 54));

	}

	private static void print(int number) {
		System.out.println(number);
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printEvenNumber(List<Integer> numbers) {
		numbers.stream().filter(JavaEight::isEven).forEach(JavaEight::print);
		
		numbers.stream().filter(JavaEight::isEven).filter(i -> i%3 ==0).forEach(JavaEight::print);
	}

}
