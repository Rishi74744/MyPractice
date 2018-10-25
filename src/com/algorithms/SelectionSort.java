package com.algorithms;

public class SelectionSort {

	static void selectionSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}

	public static void main(String[] args) {
		int a[] = { 64, 25, 12, 22, 11 };
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
