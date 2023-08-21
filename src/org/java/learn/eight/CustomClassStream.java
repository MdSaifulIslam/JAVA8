package org.java.learn.eight;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Course {
	private String courseName;
	private String group;
	private int reviewScore;
	private int noOfStudents;

	public Course(String courseName, String group, int reviewScore, int noOfStudents) {
		this.courseName = courseName;
		this.group = group;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "\nCourse [courseName=" + courseName + ", group=" + group + ", reviewScore=" + reviewScore
				+ ", noOfStudents=" + noOfStudents + "]";
	}
}

public class CustomClassStream {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Java", "Programming", 70, 64), 
				new Course("DLD", "EEE", 65, 90),
				new Course("VLSI", "EEE", 88, 60), 
				new Course("C/C++", "Programming", 88, 30),
				new Course("Tharmal", "Physic", 15, 75), 
				new Course("Soil", "Chemistry", 15, 25));

		Predicate<Course> allMatchPredicate = course -> course.getReviewScore() > 3;

		System.out.println(courses.stream().allMatch(allMatchPredicate));
		System.out.println(courses.stream().anyMatch(allMatchPredicate));
		System.out.println(courses.stream().noneMatch(allMatchPredicate));

		Comparator<Course> courseComparator = Comparator.comparing(Course::getReviewScore)
				.thenComparing(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(courseComparator).collect(Collectors.toList()));
		
		Comparator<Course> courseNameComparatorAndGroup = Comparator.comparing(Course::getGroup)
				.thenComparing(courseComparator);
		
		System.out.println(courses.stream().sorted(courseNameComparatorAndGroup)
				//.skip(2)
				.limit(2)
				.collect(Collectors.toList()));
		
		System.out.println(
				courses.stream()
				.filter(course -> course.getGroup().equals("EEE"))
				.max(courseNameComparatorAndGroup)
				.orElse(new Course("else", "else", 2, 5))
				);
		
		System.out.println(
				courses.stream()
				.filter(course -> course.getGroup().equals("EEE"))
				.mapToInt(course -> course.getReviewScore())
				.average()
				);
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getReviewScore))
				);
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getGroup, Collectors.partitioningBy(course -> course.getReviewScore() > 50)))
				);
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getGroup, Collectors.mapping(Course::getCourseName, Collectors.toList())))
				);
		
		
		System.out.println(IntStream.range(1, 1000).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
		
		
	}

}
