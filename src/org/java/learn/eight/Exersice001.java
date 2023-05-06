package org.java.learn.eight;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Saiful
 *
 */

public class Exersice001 {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		System.out.println("All courses:\n===================");
		courses.stream().forEach(System.out::println);

		System.out.println("\nCourses with 'Spring':\n========================");
		courses.stream().filter(str -> str.contains("Spring")).forEach(System.out::println);

		System.out.println("\nCourses length more than four [4]:\n==================================");
		courses.stream().filter(str -> str.length() >= 4).forEach(System.out::println);

		System.out.println(courses.stream().filter(s -> s.length() > 5).sorted().reduce("", (s, p) -> {
			if (s.equals(""))
				return s + p;
			return s + " " + p;
		}));

		System.out.println(courses.stream().map(s -> s.length()).sorted(Comparator.naturalOrder()).distinct()
				.collect(Collectors.toList()));

		courses.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
	}
}
