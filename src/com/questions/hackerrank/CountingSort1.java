package com.questions.hackerrank;

import java.util.Scanner;

public class CountingSort1 {

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
		for (int i = 0; i < countArray.length; i++) {
			System.out.print(countArray[i] + " ");
		}
	}

}
