package com.questions.hackerrank;

import java.util.Scanner;

public class CountingSort2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int arraySize = scanner.nextInt();
			int array[] = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				array[i] = scanner.nextInt();
			}
			performSorting(array, arraySize);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static void performSorting(int array[], int max) {
		int countArray[] = new int[max];
		for (int i = 0; i < array.length; i++) {
			countArray[array[i]] = countArray[array[i]] + 1;
		}
		for (int i = 1; i < max; i++) {
			countArray[i] = countArray[i - 1] + countArray[i];
		}
		int sortedArray[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sortedArray[countArray[array[i]] - 1] = array[i];
			countArray[array[i]] = countArray[array[i]] - 1;
		}
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}

}
