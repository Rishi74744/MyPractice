package com.questions.geeksforgeeks.arrays;

import java.util.Scanner;

/**
 * Given an array containing both negative and positive integers. Find the
 * contiguous sub-array with maximum sum.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The description of T test cases follows. The first line of each
 * test case contains a single integer N denoting the size of array. The second
 * line contains N space-separated integers A1, A2, ..., AN denoting the
 * elements of the array.
 * 
 * Output: Print the maximum sum of the contiguous sub-array in a separate line
 * for each test case.
 * 
 * Constraints: 1 ≤ T ≤ 200 1 ≤ N ≤ 100 -100 ≤ A[i] <= 100
 * 
 * Example: Input 2 3 1 2 3 4 -1 -2 -3 -4 Output 6 -1
 */
public class KadanesAlgorithm {

	public static void main(String[] args) {
		Scanner scanner = null;
		int t;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter number of test cases : ");
			t = scanner.nextInt();
			for (int i = 0; i < t; i++) {
				System.out.println("Enter size of array for test case no. " + (i + 1) + " : ");
				int n = scanner.nextInt();
				int[] array = new int[n];
				System.out.println("Enter the array elements for test case no. " + (i + 1) + " : ");
				for (int j = 0; j < n; j++) {
					array[j] = scanner.nextInt();
				}
				int maxSum = new KadanesAlgorithm().findMaximumSum(array);
				System.out.println("Maximum possible sum is : " + maxSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	private int findMaximumSum(int[] array) {
		int sum = 0;
		int intermediateSum = 0;
		for (int i = 0; i < array.length; i++) {
			intermediateSum = sum + array[i];
			if (intermediateSum < 0) {
				intermediateSum = 0;
			}
			if (sum < intermediateSum) {
				sum = intermediateSum;
			}
		}
		return sum;
	}

}
