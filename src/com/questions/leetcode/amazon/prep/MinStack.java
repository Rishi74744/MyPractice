package com.questions.leetcode.amazon.prep;

import java.util.LinkedList;
import java.util.List;

public class MinStack {
	private List<Integer> mainStack = new LinkedList<>();
	int min = Integer.MAX_VALUE;
	int stackPointer;

	public MinStack() {
		stackPointer = 0;
	}

	public void push(int val) {
		mainStack.add(val);
		if (stackPointer == 0) {
			min = val;
		} else if (val < min) {
			min = val;
		}
		stackPointer++;
	}

	public void pop() {
		stackPointer--;
		int tos = mainStack.remove(stackPointer);
		if (min == tos && stackPointer > 0) {
			min = mainStack.get(stackPointer - 1);
			int t = stackPointer - 1;
			while (t >= 0) {
				if (mainStack.get(t) < min) {
					min = mainStack.get(t);
				}
				t--;
			}
		}
	}

	public int top() {
		return mainStack.get(stackPointer - 1);
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-3);

		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());
	}
}
