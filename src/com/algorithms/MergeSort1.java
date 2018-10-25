package com.algorithms;

public class MergeSort1 {

	static void mergeSort(int a[], int i, int j) {
		if (i == j) {
			return;
		} else {
			int mid = (i + j) / 2;
			mergeSort(a, i, mid);
			mergeSort(a, mid + 1, j);
			merge(a, i, mid, j);
		}
	}

	static void merge(int a[], int i, int mid, int j) {
		int n1 = mid - i + 1;
		int n2 = j - mid;
		int l[] = new int[n1];
		int r[] = new int[n2];
		for (int p = 0; p < n1; p++) {
			l[p] = a[i + p];
		}

		for (int q = 0; q < n2; q++) {
			r[q] = a[mid + q + 1];
		}

		int m = 0;
		int n = 0;
		int k = i;
		while (m < n1 && n < n2) {
			if (l[m] <= r[n]) {
				a[k] = l[m];
				m++;
				k++;
			} else {
				a[k] = r[n];
				n++;
				k++;
			}
		}
		while (m < n1) {
			a[k] = l[m];
			m++;
			k++;
		}
		while (n < n2) {
			a[k] = r[n];
			n++;
			k++;
		}
	}

	public static void main(String[] args) {
		int a[] = { 12, 24, 11, 6, 325, 95, 124, 51 };
		mergeSort(a, 0, 7);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}