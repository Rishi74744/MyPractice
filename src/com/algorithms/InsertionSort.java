package com.algorithms;

public class InsertionSort {

	public static void sort(int arr[]) {
		int swaps = 0;
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > key; j--) {
				arr[j + 1] = arr[j];
				swaps++;
			}
			arr[j + 1] = key;
		}
		System.out.println(swaps);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 25, 15, 5, 50, 60 };
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
