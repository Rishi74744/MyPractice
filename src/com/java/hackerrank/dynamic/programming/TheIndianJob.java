package com.java.hackerrank.dynamic.programming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheIndianJob {

	static String indianJob(int g, int[] arr) {
		int sum = 0;
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int max = Collections.max(arrList);
		long count = arrList.stream().filter(p -> p == max).count();
		if (max > g / 2 && count > 1) {
			return "NO";
		}
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum <= (2 * g)) {
			return "YES";
		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(scanner.nextLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			String[] ng = scanner.nextLine().split(" ");

			int n = Integer.parseInt(ng[0].trim());

			int g = Integer.parseInt(ng[1].trim());

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");

			for (int arrItr = 0; arrItr < n; arrItr++) {
				int arrItem = Integer.parseInt(arrItems[arrItr].trim());
				arr[arrItr] = arrItem;
			}

			String indianJob = indianJob(g, arr);
			System.out.println(indianJob);
		}

	}

}