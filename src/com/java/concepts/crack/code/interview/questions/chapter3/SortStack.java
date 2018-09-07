package com.java.concepts.crack.code.interview.questions.chapter3;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {

	static Stack<Integer> mainStack = new Stack<>();

	static void push(int data) {
		if (mainStack.isEmpty()) {
			mainStack.push(data);
		} else {
			int msTop = mainStack.peek();
			if (msTop > data) {
				mainStack.push(data);
			} else {
				Stack<Integer> tempStack = new Stack<>();
				msTop = mainStack.pop();
				while (msTop < data) {
					tempStack.push(msTop);
					if (!mainStack.isEmpty()) {
						msTop = mainStack.pop();
					} else {
						break;
					}
				}
				if (msTop > data) {
					mainStack.push(msTop);
				}
				mainStack.push(data);
				while (!tempStack.isEmpty()) {
					mainStack.push(tempStack.pop());
				}
			}
		}
	}

	static int pop() {
		if (mainStack.isEmpty()) {
			return -1;
		} else {
			return mainStack.pop();
		}
	}

	static int peek() {
		if (mainStack.isEmpty()) {
			return -1;
		} else {
			return mainStack.peek();
		}
	}

	static boolean isEmpty() {
		return mainStack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements you want to insert in stack : ");
		int total = scanner.nextInt();
		System.out.println("Enter stack elements : ");
		for (int i = 0; i < total; i++) {
			int data = scanner.nextInt();
			push(data);
		}
		System.out.println("Enter number of elements you want to fetch from stack : ");
		total = scanner.nextInt();
		for (int i = 0; i < total; i++) {
			int result = pop();
			if (result == -1) {
				System.out.println("Stack Underflow");
			} else {
				System.out.println(result);
			}
		}
		System.out.println("Top Of Stack after pop : " + peek());
		scanner.close();
	}

}