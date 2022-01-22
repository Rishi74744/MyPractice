package com.questions.randomquestions;

public class BinarySearch {

	static int bs(int a[], int start, int end, int search) {
		if (start == end) {
			return a[start] == search ? start : -1;
		} else {
			int mid = (start + end) / 2;
			if (a[mid] == search) {
				return mid;
			} else if (a[mid] > search) {
				return bs(a, start, mid - 1, search);
			} else {
				return bs(a, mid + 1, end, search);
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 4, 5, 7, 9, 10 };
		System.out.println(bs(nums, 0, nums.length, 0));
		System.out.println(bs(nums, 0, nums.length, 4));
	}

}
