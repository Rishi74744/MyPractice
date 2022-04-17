package com.java.sorting;

public class QuickSort {

	/**
	 * Fails for -ve numbers. Check second approach to partition.
	 */
	public static int partitionFail(int a[], int low, int high) {
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

	/**
	 * Correct Approach for both -ve and +ve numbers.
	 */
	private static int partition(int nums[], int low, int high) {
		int pivot = nums[high];
		int pivotIndex = low - 1;
		for (int i = low; i < high; i++) {
			if (nums[i] <= pivot) {
				pivotIndex++;
				int temp = nums[i];
				nums[i] = nums[pivotIndex];
				nums[pivotIndex] = temp;
			}
		}
		pivotIndex++;
		int temp = nums[pivotIndex];
		nums[pivotIndex] = nums[high];
		nums[high] = temp;
		return pivotIndex;
	}

	public static void quicksort(int a[], int low, int high) {
		if (low < high) {
			int j = partition(a, low, high);
			quicksort(a, low, j - 1);
			quicksort(a, j + 1, high);
		}
	}

	public static void main(String args[]) {
		int a[] = { 4, 833, 6, 73, 67, 2, 89, 23, 103, 546, 1 };
		quicksort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
