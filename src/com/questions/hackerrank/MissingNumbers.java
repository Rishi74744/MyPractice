package com.questions.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		Map<Integer, Integer> m1 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
			if (m1.containsKey(arr1[i])) {
				int val = m1.get(arr1[i]) + 1;
				m1.put(arr1[i], val);
			} else {
				m1.put(arr1[i], 1);
			}
		}
		int m = sc.nextInt();
		int arr2[] = new int[m];
		Map<Integer, Integer> m2 = new HashMap<>();
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
			if (m2.containsKey(arr2[i])) {
				int val = m2.get(arr2[i]) + 1;
				m2.put(arr2[i], val);
			} else {
				m2.put(arr2[i], 1);
			}
		}
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < m; i++) {
			int freq1 = m1.get(arr2[i]);
			int freq2 = m2.get(arr2[i]);
			if (freq1 != freq2) {
				s.add(arr2[i]);
			}
		}
		List<Integer> l = new ArrayList<>(s);
		Collections.sort(l);
		print(l);
	}

	private static void print(List<Integer> ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
