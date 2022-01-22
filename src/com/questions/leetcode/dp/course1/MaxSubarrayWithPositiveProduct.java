package com.questions.leetcode.dp.course1;

import java.util.Arrays;
import java.util.List;

public class MaxSubarrayWithPositiveProduct {

	public static int getMaxLen(List<Integer> nums) {
		int n = nums.size();
		int max = 0;

		int start = 0; // start of the subarray
		int first = -1, last = -1; // first negative and last negative index in the subarray
		boolean evenCount = true; // handle odd count in the subarray

		for (int end = 0; end <= n; end++) {
			if (end == n || nums.get(end) == 0) {
				// w/o first odd
				if (first != -1) {
					max = Math.max(max, end - first - 1);
				}

				// w/o last odd
				if (last != -1) {
					max = Math.max(max, last - start);
				}

				// reset
				start = end + 1;
				first = -1;
				last = -1;
				evenCount = true;
			} else if (nums.get(end) < 0) {
				// toggle odd count
				evenCount ^= true;

				// find first and last odd index
				if (first == -1) {
					first = end;
				} else {
					last = end;
				}
			}

			if (evenCount) {
				max = Math.max(end - start + 1, max);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int nums[] = { 1, -1, -1, 1, 1, -1 };
		System.out.println(getMaxLen(Arrays.asList(1, -1, -1, 1, 1, -1)));
	}

}
