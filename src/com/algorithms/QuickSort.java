package com.algorithms;

import java.util.Scanner;

public class QuickSort {

	static void quickSort(int arr[], int p, int q) {
		if (p == q) {
			return;
		} else {
			int m = partition(arr, p, q);
			quickSort(arr, p, m - 1);
			quickSort(arr, m + 1, q);
		}
	}

	static int partition(int arr[], int p, int q) {
		int x = arr[p];
		int j = p;
		for (int i = p + 1; i < q; i++) {
			if (arr[i] <= x) {
				j = j + 1;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[j];
		arr[j] = arr[p];
		arr[p] = temp;
		return j;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size : ");
		int arrSize = scanner.nextInt();
		System.out.println("Enter array elements : ");
		int arr[] = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = scanner.nextInt();
		}
		quickSort(arr, 0, arrSize);
		System.out.println("Array after sorting");
		for (int i = 0; i < arrSize; i++) {
			System.out.println(arr[i]);
		}
		scanner.close();
	}

}
