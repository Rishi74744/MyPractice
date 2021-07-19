package com.java.hackerrank.implementation;

public class MinimumDistances {

	public static int getMinDistance(int arr[]) {
		boolean foundIdenticalNumber = false;
		int min = arr.length;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j]) {
					foundIdenticalNumber = true;
					int distance = Math.abs(j - i);
					if (distance < min) {
						min = distance;
					}
				}
			}
		}
		return foundIdenticalNumber ? min : -1;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 1, 2, 3 };
		int distance = getMinDistance(arr);
		System.out.println(distance);
	}

}
