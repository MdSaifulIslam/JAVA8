package org.java.learn.eight;

import java.util.List;

/**
 * @author Saiful
 *
 */

public class Map {

	public static void main(String[] args) {

		squareTheNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		System.out.println("=========");
		courses.stream().map(course -> course + " -> " + course.length()).filter(course -> course.contains("3"))
				.forEach(System.out::println);
		
		System.out.println("=========");
		List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes").stream().filter(course -> course.length() >= 7 ).forEach(System.out::println);
		
		List.of(1, 3, 5 ,6, 7, 2).stream().filter(x -> x%2 != 0).forEach(System.out::println);

	}

	private static void squareTheNumbers(List<Integer> numbers) {
		numbers.stream().filter(number -> number % 2 != 0).map(number -> number * number).forEach(System.out::println);
	}

}
