package com.java.prep.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		List<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > sub.get(sub.size() - 1)) {
				sub.add(nums[i]);
			} else {
				sub.set(binarySearch(nums[i], sub), nums[i]);
			}
		}
		System.out.println(sub);
		return sub.size();
	}

	private int binarySearch(int num, List<Integer> nums) {
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
		int nums[] = { 1, 0, 1, 3, 2, 3, 4, 7, 8, 9 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(nums));
	}

}
