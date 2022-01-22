package com.java8.streams.udemy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.udemy.Student;
import com.java8.udemy.StudentDatabase;

public class StreamMapReduceExample {

	public static void main(String[] args) {
		System.out
				.println(StudentDatabase.getAllStudents().stream().map(Student::getNoteBooks).reduce(0, Integer::sum));

		System.out.println(StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(
				Student::getGradeLevel,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get))));

		System.out.println(
				StudentDatabase.getAllStudents().stream() .collect(Collectors.partitioningBy(s -> s.getGpa() >= 3.8)));

	}
	
	Collections

}
