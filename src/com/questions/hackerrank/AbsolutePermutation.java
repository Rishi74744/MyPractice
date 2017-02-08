package com.questions.hackerrank;

import java.util.Scanner;

public class AbsolutePermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int arr[] = new int[n];
			int count = n - k + 1;
			int l = k;
			boolean isOk = true;
			if (n % k != 0) {
				System.out.println("-1");
			} else {
				for (int i = 0; i < n; i++) {
					if (l != 0 && isOk) {
						arr[i] = count;
						count++;
						l--;
					} else {
						isOk = false;
						l++;
						arr[i] = l;
					}
				}
				int absPerm[] = new int[n];
				for (int i = 0; i < n; i++) {
					absPerm[i] = Math.abs((i + 1) - arr[i]);
				}
				int orderVal = 0;
				for (int i = k; i < n; i++) {
					if (absPerm[i] == k) {
						orderVal++;
					}
					if (orderVal == k) {
						break;
					}
				}
				int noOfItr = n / k;
				int nxtItr = k;
				int curr = 0;
				boolean isFirst = true;
				while (noOfItr != 0) {
					for (int i = 0; i < k; i++) {
						if (isFirst) {
							System.out.print(arr[nxtItr]);
							isFirst = false;
						} else {
							System.out.print(" " + arr[nxtItr]);
						}
						if((i+1) != k){
							nxtItr++;
						}
					}
					if (curr % 2 == 0) {
						nxtItr = nxtItr - 2 * k + 1;
					} else {
						nxtItr = nxtItr + 2 * k - 1;
					}
					curr++;
					noOfItr--;
				}
			}
			System.out.println();
		}
	}
}