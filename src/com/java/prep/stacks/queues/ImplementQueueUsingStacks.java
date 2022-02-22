package com.java.prep.stacks.queues;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	Stack<Integer> enqueue;
	Stack<Integer> dequeue;

	public ImplementQueueUsingStacks() {
		enqueue = new Stack<>();
		dequeue = new Stack<>();
	}

	public void push(int x) {
		while (!enqueue.isEmpty()) {
			dequeue.push(enqueue.pop());
		}
		enqueue.push(x);
		while (!dequeue.isEmpty()) {
			enqueue.push(dequeue.pop());
		}
	}

	public int pop() {
		return enqueue.pop();
	}

	public int peek() {
		return enqueue.peek();
	}

	public boolean empty() {
		return enqueue.isEmpty();
	}

	public static void main(String[] args) {
		ImplementQueueUsingStacks i = new ImplementQueueUsingStacks();
		i.push(1);
		i.push(2);
		i.push(3);
		i.push(4);
		System.out.println(i.pop());
		i.push(5);
		System.out.println(i.pop());
		System.out.println(i.pop());
		System.out.println(i.pop());
		System.out.println(i.pop());
	}

}
