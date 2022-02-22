package com.java8.streams.udemy;

import java.util.PriorityQueue;

public class StreamMapReduceExample {

	public static void main(String[] args) {
//		System.out
//				.println(StudentDatabase.getAllStudents().stream().map(Student::getNoteBooks).reduce(0, Integer::sum));
//
//		System.out.println(StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(
//				Student::getGradeLevel,
//				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get))));
//
//		System.out.println(
//				StudentDatabase.getAllStudents().stream().collect(Collectors.partitioningBy(s -> s.getGpa() >= 3.8)));
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		p.add(45);
		p.add(5);
		p.add(15);
		p.add(70);
		System.out.println(p);
		System.out.println(p.remove());
		System.out.println(p);
		p.add(2);
		System.out.println(p);
		System.out.println(p.remove());
		System.out.println(p);
	}

}
