package com.questions.hackerrank;

import java.util.Scanner;

public class CorrectnessAndLoopInvariant {
	public static void insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			
		}
		printArray(array);
		/*for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i;
			while (j > 0 && A[j] > value) {
				A[j] = A[j - 1];
				j = j - 1;
			}
			A[j] = value;
		}

		printArray(A);*/
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		insertionSort(ar);
	}
}
