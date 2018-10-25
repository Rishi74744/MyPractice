package com.algorithms;

public class QuickSort1 {

	static void quickSort(int a[], int i, int j) {
		if (i < j) {
			int m = partition(a, i, j);
			quickSort(a, i, m - 1);
			quickSort(a, m + 1, j);
		}
	}

	static int partition(int a[], int i, int j) {
		int x = a[j];
		int k = i;
		for (int m = i + 1; m < j; m++) {
			if (a[m] <= x) {
				k++;
				int temp = a[m];
				a[m] = a[k - 1];
				a[k - 1] = temp;
			}
		}
		int temp = a[k];
		a[k] = a[j];
		a[j] = temp;
		return k;
	}

	public static void main(String[] args) {
		int a[] = { 12, 24, 11, 6, 325, 95, 124, 51 };
		quickSort(a, 0, 7);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
