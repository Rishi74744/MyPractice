package com.questions.randomquestions;

public class SelectionSort {

	static void selectionSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}

	public static void main(String[] args) {
		int a[] = { 78, 55, 21, 69, 90, 15, 11, 29 };
		selectionSort(a);
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}

}
