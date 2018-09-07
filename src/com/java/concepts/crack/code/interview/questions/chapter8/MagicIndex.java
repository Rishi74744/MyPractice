package com.java.concepts.crack.code.interview.questions.chapter8;

import java.util.Scanner;

public class MagicIndex {

	static int findMagicIndex(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	static int findMagicIndex(int arr[], int start, int end) {
		if (start == end) {
			if (arr[start] == start) {
				return start;
			} else {
				return -1;
			}
		}
		int mid = (start + end) / 2;
		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] < mid) {
			return findMagicIndex(arr, mid + 1, end);
		} else {
			return findMagicIndex(arr, start, mid - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalNumbers = scanner.nextInt();
		int arr[] = new int[totalNumbers];
		for (int i = 0; i < totalNumbers; i++) {
			arr[i] = scanner.nextInt();
		}
		int index = findMagicIndex(arr);
		System.out.println(index);
		scanner.close();
	}

}