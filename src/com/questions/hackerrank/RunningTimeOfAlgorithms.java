package com.questions.hackerrank;

import java.util.Scanner;

public class RunningTimeOfAlgorithms {
	
	public static void insertionSort(int[] array) {
		int shifts = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					shifts++;
				}
			}
		}
		System.out.println(shifts);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSort(ar);
	}

}
