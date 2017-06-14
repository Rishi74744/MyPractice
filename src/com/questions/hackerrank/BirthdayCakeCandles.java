package com.questions.hackerrank;

import java.util.Scanner;

public class BirthdayCakeCandles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int height[] = new int[n];
		for (int height_i = 0; height_i < n; height_i++) {
			height[height_i] = in.nextInt();
		}
		int height1[] = new int[n];
		for (int height_i = 0; height_i < n; height_i++) {
			height1[height_i] = height[height_i];
		}
		int max = findMax(height1);
		int count = 0;
		for (int j = 0; j < n; j++) {
			if (height[j] == max) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static int findMax(int array[]) {
		for (int j = 0; j < array.length - 1; j++) {
			if (array[j] > array[j + 1]) {
				int temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		return array[array.length - 1];
	}

}