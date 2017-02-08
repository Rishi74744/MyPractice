package com.questions.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
		}
		int[] subArr = new int[k];
		Arrays.sort(arr);
		int p = 0;
		for(int i = 0; i < n; i++){
			subArr[p] = arr[i];
		}
		
	}

}
