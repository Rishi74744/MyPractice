package com.questions.palo.alto;

public class TotalPairWithEvenSum {
	public static int solution(int[] A) {
		int n = A.length;
		int pair1 = 0;
		int pair2 = 0;
		int arr[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = A[i];
		}
		arr[n] = A[0];
		for (int i = 0; i < n - 1; i++) {
			if ((arr[i] & 1) == (arr[i + 1] & 1)) {
				pair1++;
				i++;
			}
		}
		for (int i = 1; i < n; i++) {
			if ((arr[i] & 1) == (arr[i + 1] & 1)) {
				pair2++;
				i++;
			}
		}
		return Math.max(pair1, pair2);
	}

	public static void main(String[] args) {
		int nums[] = { 14, 21, 16, 35, 22 };
		System.out.println(solution(nums));
	}
}
