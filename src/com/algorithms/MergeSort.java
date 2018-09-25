package com.algorithms;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = { 12, 43, 23, 6, 145, 78, 94, 56, 648 };
		mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public static void mergeSort(int a[], int p, int r) {
		if (p == r) {
			return;
		} else {
			int mid = (p + r) / 2;
			mergeSort(a, p, mid);
			mergeSort(a, mid + 1, r);
			merge(a, p, mid, r);
		}
	}

	public static void merge(int a[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int l[] = new int[n1];
		int m[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			l[i] = a[p + i];
		}
		for (int j = 0; j < n2; j++) {
			m[j] = a[q + j + 1];
		}
		int i = 0, j = 0, k = p;
		while (i < n1 && j < n2) {
			if (l[i] <= m[j]) {
				a[k] = l[i];
				i++;
				k++;
			} else {
				a[k] = m[j];
				j++;
				k++;
			}
		}
		while (i < n1) {
			a[k] = l[i];
			i++;
			k++;
		}
		while (j < n2) {
			a[k] = m[j];
			j++;
			k++;
		}
	}

}
