package org.java.learn.eight;

import java.util.List;

/**
 * @author Saiful
 *
 */

public class Map {

	public static void main(String[] args) {

		squareTheNumbers(List.of(4, 6, 7, 54, 54));

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		System.out.println("=========");
		courses.stream().map(course -> course + " -> " + course.length()).filter(course -> course.contains("3"))
				.forEach(System.out::println);

	}

	private static void squareTheNumbers(List<Integer> numbers) {
		numbers.stream().filter(number -> number % 2 != 0).map(number -> number * number).forEach(System.out::println);
	}

}
