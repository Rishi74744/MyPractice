package com.java.sorting;

public class QuickSort {

	public static int partition(int a[], int low, int high) {
		int pivot = a[low];
		int i = low, j = high;
		while (i < j) {
			while (a[i] <= pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i < j) {
				int b = a[i];
				a[i] = a[j];
				a[j] = b;
			}
		}
		int b = a[low];
		a[low] = a[j];
		a[j] = b;
		return j;
	}

	public static void quicksort(int a[], int low, int high) {
		if (low < high) {
			int j = partition(a, low, high);
			quicksort(a, low, j);
			quicksort(a, j + 1, high);
		}
	}

	public static void main(String args[]) {
		int a[] = { 4, 833, 6, 73, 67, 2, 89, 23, 103, 546, 1};
		quicksort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
