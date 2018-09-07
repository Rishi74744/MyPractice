package com.java.concepts.crack.code.interview.questions.chapter10;

import java.util.Scanner;

public class SortedMerge {

	public static int[] mergeSortedArrays(int a[], int b[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		int mergedArray[] = new int[(a.length + b.length)];
		while (i != a.length || j != b.length) {
			if (i == a.length) {
				mergedArray[k] = b[j];
				j++;
				k++;
				continue;
			}
			if (j == b.length) {
				mergedArray[k] = a[i];
				i++;
				k++;
				continue;
			}
			if (a[i] <= b[j]) {
				mergedArray[k] = a[i];
				i++;
			} else {
				mergedArray[k] = b[j];
				j++;
			}
			k++;
		}
		return mergedArray;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Size of array a : ");
		int aSize = scanner.nextInt();
		System.out.println("Enter Size of array b : ");
		int bSize = scanner.nextInt();
		int a[] = new int[aSize];
		System.out.println("Enter array a elements in sorted order : ");
		for (int i = 0; i < aSize; i++) {
			a[i] = scanner.nextInt();
		}
		int b[] = new int[bSize];
		System.out.println("Enter array b elements in sorted order : ");
		for (int i = 0; i < bSize; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println("Resultant Array");
		int result[] = mergeSortedArrays(a, b);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}
}