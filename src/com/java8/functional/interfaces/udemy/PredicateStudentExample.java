package com.java8.functional.interfaces.udemy;

import java.util.List;
import java.util.function.Predicate;

import com.java8.udemy.Student;
import com.java8.udemy.StudentDatabase;

public class PredicateStudentExample {

	static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

	public static void filterStudentByGradeLevel() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(student -> {
			if (p1.test(student)) {
				System.out.println(student);
			}
		});
	}

	public static void filterStudentByGradeLevelAndGpa() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(student -> {
			if (p1.and(p2).test(student)) {
				System.out.println(student);
			}
		});
	}

	public static void main(String[] args) {
//		filterStudentByGradeLevel();
		filterStudentByGradeLevelAndGpa();
	}

}
