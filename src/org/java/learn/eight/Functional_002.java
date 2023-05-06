package org.java.learn.eight;

import java.util.List;

/**
 * @author Saiful
 *
 */

public class Functional_002 {

	public static void main(String[] args) {

		System.out.println(sumNumberInFunctionalApproach(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));

	}

	private static int sumNumberInFunctionalApproach(List<Integer> numbers) {
		return numbers.stream()
				//.reduce(0, Functional_002::add);
				.reduce(0, (x, y) -> x + y);
				//.reduce(0, Integer::sum);
	}

	private static int add(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a + b));
		return a + b;
	}
}
