package com.java.concepts.crack.code.interview.questions.chapter3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackOfPlates {

	static List<Stack<Integer>> stacks = new LinkedList<>();
	static int threshold = 0;
	static int currentStackNum = 0;

	static void push(int data) {
		if (!stacks.isEmpty() && stacks.get(currentStackNum).size() == threshold) {
			currentStackNum++;
		}
		Stack<Integer> currentStack = new Stack<>();
		if (!stacks.isEmpty()) {
			if (stacks.size() == currentStackNum + 1) {
				currentStack = stacks.get(currentStackNum);
			}
		}
		currentStack.push(data);
		if (stacks.size() != 0 && stacks.size() == currentStackNum + 1) {
			stacks.set(currentStackNum, currentStack);
		} else {
			stacks.add(currentStack);
		}
	}

	static int pop() {
		int data = -1;
		Stack<Integer> currentStack = null;
		if (stacks.isEmpty()) {
			data = -1;
		} else {
			currentStack = stacks.get(currentStackNum);
			data = currentStack.pop();
			if (currentStack.isEmpty()) {
				stacks.remove(currentStackNum);
				currentStackNum--;
			}
		}
		return data;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter threshold : ");
		threshold = scanner.nextInt();
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
		scanner.close();
	}

}
