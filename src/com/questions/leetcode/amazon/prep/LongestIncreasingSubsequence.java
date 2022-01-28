package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		int max = 0;
		int n = nums.length;
		int dp[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > nums[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static int lengthOfLIS1(int[] nums) {
		List<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > sub.get(sub.size() - 1)) {
				sub.add(nums[i]);
			} else {
				sub.set(binarySearch(nums[i], sub), nums[i]);
			}
		}
		return sub.size();
	}

	private static int binarySearch(int num, List<Integer> nums) {
		int l = 0, r = nums.size() - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (num == nums.get(mid))
				return mid;
			else if (num > nums.get(mid))
				l = mid + 1;
			else
				r = mid;
		}
		return l;
	}

	public static void main(String[] args) {
		int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS1(nums));
	}

}
