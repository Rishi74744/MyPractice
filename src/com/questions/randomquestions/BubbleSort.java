package com.questions.randomquestions;

public class BubbleSort {

	static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 78, 55, 21, 69, 90, 15, 11, 29 };
		bubbleSort(a);
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}

}
