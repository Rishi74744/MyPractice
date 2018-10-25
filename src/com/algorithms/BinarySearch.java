package com.algorithms;

public class BinarySearch {

	static int binarySearch(int a[], int start, int end, int x) {
		if (start == end) {
			if (a[start] == x) {
				return start;
			} else {
				return -1;
			}
		} else {
			int mid = (start + end) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] > x) {
				return binarySearch(a, start, mid - 1, x);
			} else {
				return binarySearch(a, mid + 1, end, x); 
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8, 21, 44, 67, 86, 99, 102, 355 };
		int x = 27;
		System.out.println(binarySearch(a, 0, a.length - 1, x));
	}

}
