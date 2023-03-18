package org.java.learn.eight;

import java.util.List;

/**
 * @author Saiful
 *
 */

public class Exersice001 {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		//courses.stream().forEach(System.out::println);
		//courses.stream().filter(str -> str.contains("Spring")).forEach(System.out::println);

		courses.stream().filter(str -> str.length() >= 4).forEach(System.out::println);
	}
}
