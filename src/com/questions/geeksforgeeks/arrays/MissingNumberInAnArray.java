package com.questions.geeksforgeeks.arrays;

import java.util.Scanner;

/**
 * Given an array of size n-1 and given that there are numbers from 1 to n with
 * one missing, the missing number is to be found.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The first line of each test case is N,size of array. The second
 * line of each test case contains N-1 input C[i],numbers in array.
 * 
 * Output: Print the missing number in array.
 * 
 * Constraints: 1 ≤ T ≤ 200 1 ≤ N ≤ 1000 1 ≤ C[i] ≤ 1000
 * 
 * Example: Input 2 5 1 2 3 5 10 1 2 3 4 5 6 7 8 10 Output 4 9
 */
public class MissingNumberInAnArray {

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
				for (int j = 0; j < n - 1; j++) {
					array[j] = scanner.nextInt();
				}
				int missingNumber = new MissingNumberInAnArray().findMissingNumber(array);
				System.out.println("Missing Number is : " + missingNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	private int findMissingNumber(int[] array) {
		int arraySum = 0;
		int size = array.length;
		for (int i = 0; i < size; i++) {
			arraySum += array[i];
		}
		return ((size * (size + 1)) / 2) - arraySum;
	}

}
