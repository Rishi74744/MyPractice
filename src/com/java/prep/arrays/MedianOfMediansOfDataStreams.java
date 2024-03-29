package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedianOfMediansOfDataStreams {

	static class MedianFinder {

		Map<Integer, List<Integer>> dataStream;
		List<Integer> medians;
		int currentStream = 0;

		int median[] = new int[2];
		int initial = 0;
		int currentMedian = 0;
		int total = 0;

		public MedianFinder() {
			dataStream = new HashMap<>();
			medians = new ArrayList<>();
		}

		public void addNum(int num) {
			if (total == 5) {

			}
		}

		public double findMedian() {
			return 0.0;
		}

		int findMedianUtil(List<Integer> stream, int k, int low, int high) {
			if (low == high) {
				return stream.get(low);
			}
			int m = partition(stream, low, high);
			return -1;
		}

		int partition(List<Integer> stream, int low, int high) {
			int pivot = getPivotValue(stream, low, high);
			while (low < high) {
				while (stream.get(low) < pivot) {
					low++;
				}
				while (stream.get(high) > pivot) {
					high--;
				}
				if (stream.get(low) == stream.get(high)) {
					low++;
				} else if (low < high) {
					int temp = stream.get(low);
					stream.set(low, stream.get(high));
					stream.set(high, temp);
				}
			}
			return high;
		}

		int getPivotValue(List<Integer> stream, int low, int high) {
			stream.sort((a, b) -> a.compareTo(b));
			return stream.get(stream.size() / 2);
		}
	}

	public static void findMedian(int arr[]) {
		int median = findMedianUtil(arr, (arr.length) / 2 + 1, 0, arr.length - 1);
		System.out.println("Median = " + median);
	}

	private static int findMedianUtil(int arr[], int k, int low, int high) {
		// Uncomment this if you want to print the current subArray being
		// processed/searched
		// printArray(arr, low, high);

		if (low == high) {
			return arr[low];
		}

		// sort the mth largest element in the given array
		int m = partition(arr, low, high);

		// Adjust position relative to the current subarray being processed
		int length = m - low + 1;

		// If mth element is the median, return it
		if (length == k) {
			return arr[m];
		}

		// If mth element is greater than median, search in the left subarray
		if (length > k) {
			return findMedianUtil(arr, k, low, m - 1);
		}
		// otherwise search in the right subArray
		else {
			return findMedianUtil(arr, k - length, m + 1, high);
		}

	}

	private static int partition(int arr[], int low, int high) {
		// Get pivotvalue by finding median of medians
		int pivotValue = getPivotValue(arr, low, high);

		// Find the sorted position for pivotVale and return it's index
		while (low < high) {
			while (arr[low] < pivotValue) {
				low++;
			}

			while (arr[high] > pivotValue) {
				high--;
			}

			if (arr[low] == arr[high]) {
				low++;
			} else if (low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}

		}
		return high;
	}

	// Find pivot value, such the it is always 'closer' to the actual median
	private static int getPivotValue(int arr[], int low, int high) {
		// If number of elements in the array are small, return the actual median
		if (high - low + 1 <= 9) {
			Arrays.sort(arr);
			return arr[arr.length / 2];
		}

		// Otherwise divide the array into subarray of 5 elements each, and recursively
		// find the median

		// Array to hold '5 element' subArray, last subArray may have less than 5
		// elements
		int temp[] = null;

		// Array to hold the medians of all '5-element SubArrays'
		int medians[] = new int[(int) Math.ceil((double) (high - low + 1) / 5)];
		int medianIndex = 0;

		while (low <= high) {
			// get size of the next element, it can be less than 5
			temp = new int[Math.min(5, high - low + 1)];

			// copy next 5 (or less) elements, in the subarray
			for (int j = 0; j < temp.length && low <= high; j++) {
				temp[j] = arr[low];
				low++;
			}

			// sort subArray
			Arrays.sort(temp);

			// find mean and store it in median Array
			medians[medianIndex] = temp[temp.length / 2];
			medianIndex++;
		}

		// Call recursively to find median of medians
		return getPivotValue(medians, 0, medians.length - 1);
	}

	public static void main(String args[]) {
		int nElements = 20;
		int arr[] = new int[nElements];

		for (int i = 0; i < nElements; i++) {
			arr[i] = (int) (2000 * Math.random());
		}

		System.out.print("Array");
		printArray(arr, 0, nElements);

		MedianOfMediansOfDataStreams.findMedian(arr);

		java.util.Arrays.sort(arr);
		System.out.print(" Sorted Array - ");
		printArray(arr, 0, nElements);
		System.out.println("Median using sorting - " + arr[(arr.length) / 2]);
	}

	private static void printArray(int arr[], int low, int high) {
		System.out.print("[  ");
		for (int i = low; i < high; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("]");
	}

}
