package com.java.concepts.crack.code.interview.questions.chapter3;

import java.util.Scanner;
import java.util.Stack;

public class StackMin {

	static Stack<Integer> s = new Stack<>();
	static int min = -1;

	static void push(int data) {
		if (s.isEmpty()) {
			min = data;
		} else {
			if (data < min) {
				min = data;
			}
		}
		s.push(data);
	}

	static void pop() {
		int tos = s.pop();
		if (min >= tos) {
			boolean isFirst = true;
			Stack<Integer> s1 = new Stack<>();
			s1.addAll(s);
			while (!s1.isEmpty()) {
				int next = s1.pop();
				if (isFirst) {
					isFirst = false;
					min = next;
				} else {
					if (min > next) {
						min = next;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		for (int i = 0; i < total; i++) {
			push(scanner.nextInt());
			System.out.println(min);
		}
		for (int i = 0; i < total; i++) {
			pop();
			System.out.println(min);
		}
		scanner.close();
	}

}