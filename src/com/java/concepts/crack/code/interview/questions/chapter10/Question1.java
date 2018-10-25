package com.java.concepts.crack.code.interview.questions.chapter10;

import java.util.Scanner;

public class Question1 {

	public static void mergeArrays(int a[], int b[], int aSize) {
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] >= b[j]) {
				shiftArray(a, i, aSize);
				a[i] = b[j];
				aSize++;
				j++;
			} else {
				i++;
			}
		}
		while (j < b.length) {
			a[aSize] = b[j];
			aSize++;
			j++;
		}
	}

	public static void shiftArray(int a[], int start, int end) {
		for (int i = end - 1; i >= start; i--) {
			a[i + 1] = a[i];
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter Size of array a : ");
		int aSize = scanner.nextInt();
		// System.out.println("Enter Size of array b : ");
		int bSize = scanner.nextInt();
		int a[] = new int[aSize + bSize];
		// System.out.println("Enter array a elements in sorted order : ");
		for (int i = 0; i < aSize; i++) {
			a[i] = scanner.nextInt();
		}
		int b[] = new int[bSize];
		// System.out.println("Enter array b elements in sorted order : ");
		for (int i = 0; i < bSize; i++) {
			b[i] = scanner.nextInt();
		}
		mergeArrays(a, b, aSize);
		System.out.println("Resultant Array");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		scanner.close();
	}

}

/**
 * Question : 1 ---> Sorted Merge: You are given two sorted arrays, A and B,
 * where A has a large enough buffer at the end to hold B. Write a method to
 * merge B into A in sorted order.
 */
