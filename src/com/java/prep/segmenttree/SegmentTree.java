package com.java.prep.segmenttree;

public class SegmentTree {

	int segmentTreeNodes[];

	public SegmentTree(int arr[], int n) {
		int height = (int) Math.ceil(Math.log(n) / Math.log(2)); // Height of segment tree.
		int totalNodes = 2 * (int) Math.pow(2, height) - 1; // Total nodes in segment tree.
		segmentTreeNodes = new int[totalNodes]; // Memory allocation for segment tree nodes.
		constructSegmentTree(arr, 0, n - 1, 0);
	}

	int constructSegmentTree(int arr[], int start, int end, int currentIndex) {
		// If there is one element in array, store it in current node of segment tree
		// and return.
		if (start == end) {
			segmentTreeNodes[currentIndex] = arr[start];
			return arr[start];
		}
		// If there are more than one elements,
		// then recur for left and right subtrees and store the sum of values in this
		// node
		int mid = getMid(start, end);
		segmentTreeNodes[currentIndex] = constructSegmentTree(arr, start, mid, currentIndex * 2 + 1)
				+ constructSegmentTree(arr, mid + 1, end, currentIndex * 2 + 2);
		return segmentTreeNodes[currentIndex];
	}

	int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	// Return sum of elements in range from index query start to query end.
	int getSum(int n, int queryStart, int queryEnd) {
		if (queryStart < 0 || queryEnd > n - 1 || queryEnd < queryStart) {
			return -1;
		}
		return getSumHelper(0, n - 1, queryStart, queryEnd, 0);
	}

	int getSumHelper(int start, int end, int queryStart, int queryEnd, int currentIndex) {
		// If segment of this node is a part of given range, then return the sum of the
		// segment.
		if (queryStart <= start && queryEnd >= end) {
			return segmentTreeNodes[currentIndex];
		}
		// If segment of this node is outside the given range.
		if (end < queryStart || start > queryEnd) {
			return 0;
		}
		// If a part of this segment overlaps with the given range
		int mid = getMid(start, end);
		return getSumHelper(start, mid, queryStart, queryEnd, 2 * currentIndex + 1)
				+ getSumHelper(mid + 1, end, queryStart, queryEnd, 2 * currentIndex + 2);
	}

	void updateValue(int arr[], int n, int i, int newValue) {
		if (i < 0 || i > n - 1) {
			return;
		}
		// Get difference between new value and old value.
		int difference = newValue - arr[i];

		// Update the value in base array.
		arr[i] = newValue;

		// Update the values of nodes in segment tree.
		updateValueHelper(0, n - 1, i, difference, 0);
	}

	void updateValueHelper(int start, int end, int i, int difference, int currentIndex) {
		if (i < start || i > end) {
			return;
		}

		// If the input index is in range of this node,
		// then update the value of the node and its children.
		segmentTreeNodes[currentIndex] = segmentTreeNodes[currentIndex] + difference;
		if (start != end) {
			int mid = getMid(start, end);
			updateValueHelper(start, mid, i, difference, 2 * currentIndex + 1);
			updateValueHelper(mid + 1, end, i, difference, 2 * currentIndex + 2);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);

		// Build segment tree from given array

		// Print sum of values in array from index 1 to 3
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));

		// Update: set arr[1] = 10 and update corresponding segment
		// tree nodes
		tree.updateValue(arr, n, 1, 10);

		// Find sum after the value is updated
		System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));
	}

}
