package com.java.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {
	
	static int arr[] = { 237195, 138582, 149445, 246465, 120528 };

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			if (index.size() > 0) {
				break;
			}
			sum = arr[i];
			for (int j = i + 1; j < n; j++) {
				sum += arr[j];
				if (sum == s) {
					index.add(i + 1);
					index.add(j + 1);
					break;
				}
			}
		}
		if (index.size() == 0) {
			index.add(-1);
		}
		return index;
	}

	public static void main(String[] args) {
		
		List<Integer> l = subarraySum(arr, 12433, 54);
		for (Integer i : l) {
			System.out.println(i);
		}
	}

}
