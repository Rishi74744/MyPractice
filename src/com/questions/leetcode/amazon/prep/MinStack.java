package com.questions.leetcode.amazon.prep;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> mainStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public MinStack() {

	}

	public void push(int val) {
		if (mainStack.isEmpty()) {
			mainStack.add(val);
			minStack.add(val);
		} else {
			mainStack.add(val);
			Stack<Integer> min = new Stack<>();
			while (!minStack.isEmpty() && val > minStack.peek()) {
				min.add(minStack.pop());
			}
			min.add(val);
			while (!min.isEmpty()) {
				minStack.add(min.pop());
			}
		}
	}

	public void pop() {
		int tos = mainStack.pop();
		Stack<Integer> min = new Stack<>();
		while (minStack.peek() != tos) {
			min.add(minStack.pop());
		}
		minStack.pop();
		while (!min.isEmpty()) {
			minStack.add(min.pop());
		}
	}

	public int top() {
		return mainStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-1);
		m.push(5);

		System.out.println(m.getMin());
		System.out.println(m.top());
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());
	}
}
