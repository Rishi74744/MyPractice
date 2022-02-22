package com.java.prep.stacks.queues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	Queue<Integer> q;
	int tos = -1;

	public ImplementStackUsingQueues() {
		q = new LinkedList<>();
	}

	public void push(int x) {
		tos = x;
		q.add(x);
		int stackSize = q.size();
		int total = 0;
		while (total != stackSize - 1) {
			q.add(q.poll());
			total++;
		}
	}

	public int pop() {
		int element = q.poll();
		if (!q.isEmpty()) {
			tos = q.peek();
		}
		return element;
	}

	public int top() {
		return tos;
	}

	public boolean empty() {
		return q.isEmpty();
	}

	public static void main(String[] args) {
		ImplementStackUsingQueues myStack = new ImplementStackUsingQueues();
		myStack.push(1);
//		myStack.push(2);
//		myStack.push(3);
//		myStack.push(4);
//		System.out.println(myStack.top()); // return 2
		System.out.println(myStack.pop()); // return 4
//		myStack.push(5);
//		System.out.println(myStack.pop()); // return 5
		System.out.println(myStack.empty()); // return False
	}

}
