package com.java8.functional.interfaces.udemy;

import java.util.List;
import java.util.function.Consumer;

import com.java8.udemy.Student;
import com.java8.udemy.StudentDatabase;

public class ComsumerExample {

	static Consumer<Student> c2 = (student) -> {
		System.out.println(student);
	};

	static Consumer<Student> c3 = (student) -> {
		System.out.print(student.getName());
	};
	static Consumer<Student> c4 = (student) -> {
		System.out.println(student.getActivities());
	};

	public static void printName() {

		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(c2);
	}

	public static void printNameAndActivities() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(c3.andThen(c4));
	}

	public static void printNameAndActivitiesUsingConditions() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach((student) -> {
			if(student.getGradeLevel()>=3) {
				c3.andThen(c4).accept(student);
			}
		});
	}

	public static void main(String[] args) {
		Consumer<String> c = (s) -> {
			System.out.println(s.toUpperCase());
		};
		c.accept("java 8");
		printNameAndActivitiesUsingConditions();
	}

}
