package com.java.concepts.crack.code.interview.questions.chapter3;

import java.util.Scanner;
import java.util.Stack;

public class QueueViaStacks {

	static Stack<Integer> mainStack = new Stack<>();
	static Stack<Integer> nextStack = new Stack<>();

	static void add(int data) {
		mainStack.push(data);
	}

	static void poll() {
		while (!mainStack.isEmpty()) {
			nextStack.push(mainStack.pop());
		}
		System.out.println(nextStack.pop());
		while (!nextStack.isEmpty()) {
			mainStack.push(nextStack.pop());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalElements = scanner.nextInt();
		for (int i = 0; i < totalElements; i++) {
			add(scanner.nextInt());
		}
		for (int i = 0; i < totalElements; i++) {
			poll();
		}
		scanner.close();
	}

}
