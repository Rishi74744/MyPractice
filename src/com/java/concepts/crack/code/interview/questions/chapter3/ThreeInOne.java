package com.java.concepts.crack.code.interview.questions.chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeInOne {

	static void push(int arr[], int m, int data, int tos[], int stackNum) {
		if (tos[stackNum - 1] == ((arr.length / m) * stackNum)) {
			System.out.println("Stack Overflow");
		} else {
			arr[tos[stackNum - 1]] = data;
			tos[stackNum - 1]++;
		}
	}

	static int pop(int arr[], int m, int tos[], int stackNum) {
		int data = -1;
		if (tos[stackNum - 1] == ((arr.length / m) * stackNum)) {
			System.out.println("Stack Underflow");
		} else {
			data = arr[tos[stackNum - 1]];
			tos[stackNum - 1]--;
		}
		return data;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int arr[] = new int[n];
		int tos[] = new int[m];
		int count = 0;
		for (int i = 0; i < m; i++) {
			tos[i] = (count * m);
			count++;
		}
		Arrays.fill(arr, -1);
		System.out.println("Enter number of elements to push on stack : ");
		int x = scanner.nextInt();
		for (int i = 0; i < x; i++) {
			int data = scanner.nextInt();
			int stackNum = scanner.nextInt();
			push(arr, m, data, tos, stackNum);
		}
		System.out.println("Enter number of elements to pop from stack : ");
		int y = scanner.nextInt();
		for (int i = 0; i < y; i++) {
			int stackNum = scanner.nextInt();
			int result = pop(arr, m, tos, stackNum);
			System.out.println(result);
		}
		scanner.close();
	}
}