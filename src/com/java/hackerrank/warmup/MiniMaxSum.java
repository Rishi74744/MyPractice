package com.java.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MiniMaxSum {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		int esc = 0;
		List<Long> sum = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			long s = 0;
			for (int j = 0; j < arr.length; j++) {
				if (esc != j) {
					s += arr[j];
				}
			}
			esc++;
			sum.add(s);
		}
		Collections.sort(sum);
		System.out.print(sum.get(0) + " " + sum.get(sum.size() - 1));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		miniMaxSum(arr);
		scanner.close();
	}

}
