package com.java.prep.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromStreamData {

	Queue<Integer> smaller;
	Queue<Integer> bigger;

	public FindMedianFromStreamData() {
		smaller = new PriorityQueue<Integer>(Collections.reverseOrder());
		bigger = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		bigger.add(num);
		smaller.add(bigger.poll());
		if (smaller.size() - bigger.size() > 1) {
			bigger.add(smaller.poll());
		}
	}

	public double findMedian() {
		return (smaller.size() - bigger.size()) > 0 ? smaller.peek() : ((double) (smaller.peek() + bigger.peek()) / 2);
	}

}
