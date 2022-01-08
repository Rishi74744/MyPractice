package com.questions.leetcode.algo1;

public class FirstBadVersion {

	public static int firstBadVersion(int n) {
		return findingBad(1, n);
	}

	public static int findingBad(int start, int end) {
		if (start >= end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		boolean isMidBad = isBadVersion(mid);
		boolean isPrevBad = isBadVersion(mid - 1);
		if (isMidBad && !isPrevBad) {
			return mid;
		}
		if (!isPrevBad) {
			start = mid + 1;
			return findingBad(start, end);
		} else {
			end = mid - 1;
			return findingBad(start, end);
		}
	}

	private static boolean isBadVersion(long mid) {
		return mid == 1702766719;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(2126753390));
	}

}
