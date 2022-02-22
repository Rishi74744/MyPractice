package com.java8.streams.udemy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8.udemy.Student;
import com.java8.udemy.StudentDatabase;

public class StreamsExample {

	public static void main(String[] args) {
		Map<String, List<String>> studentActivities = StudentDatabase.getAllStudents().stream()
				.filter(student -> student.getGradeLevel() >= 3).filter(student -> student.getGpa() >= 3.9)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println(studentActivities);
		StudentDatabase.getAllStudents().stream().map(Student::getName).collect(Collectors.toList());
		System.out.println(StudentDatabase.getAllStudents().stream().map(Student::getActivities).flatMap(List::stream)
				.distinct().sorted().collect(Collectors.toList()));
	}

}
