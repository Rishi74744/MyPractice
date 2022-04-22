package com.questions.leetcode.amazon.prep;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SlidingWindowMaximum {
	public static int segment1(int x, List<Integer> space) {
		int chunkNum = 1;
		Stack<Integer> s = new Stack<>();
		s.push(0);

		for (int i = 1; i < space.size(); i++) {
			if (i < x) {
				if (space.get(i) < space.get(s.peek())) {
					s.pop();
					s.push(i);
				}
			} else {
				var peek = s.peek();
				if (peek >= chunkNum) {
					s.push(space.get(i) < space.get(s.peek()) ? i : peek);
				} else {
					s.push(i);

					var j = chunkNum;
					var count = 0;
					while (count++ < x) {
						if (space.get(j) < space.get(s.peek())) {
							s.pop();
							s.push(j);
						}
						j++;
					}
				}
				chunkNum++;
			}
		}

		return s.stream().mapToInt(Integer::intValue).max().getAsInt();
	}

	public static int segment(int x, List<Integer> space) {
		int n = space.size();
		if (n == 1) {
			return space.get(0);
		}
		int count = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (count < x) {
				min = Math.min(min, space.get(i));
			} else {
				max = Math.max(max, min);
				if (space.get(i - count) == min) {
					int idx = i - count + 1;
					min = space.get(i - count + 1);
					while (idx <= i) {
						min = Math.min(min, space.get(idx));
						idx++;
					}
				} else {
					min = Math.min(min, space.get(i));
				}
			}
		}
		return max == Integer.MIN_VALUE ? min : max;
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n < k) {
			return new int[] {};
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int result[] = new int[n - k + 1];
		for (int i = 0; i < k; i++) {
			if (max < nums[i]) {
				maxIndex = i;
				max = nums[i];
			}
		}
		result[0] = max;
		int j = 1;
		for (int i = k; i < nums.length; i++) {
			if (i - k + 1 <= maxIndex && maxIndex <= i) {
				if (max < nums[i]) {
					max = nums[i];
					maxIndex = i;
				}
			} else {
				max = Integer.MIN_VALUE;
				for (int l = i; l >= (i - k + 1); l--) {
					if (max < nums[l]) {
						maxIndex = l;
						max = nums[l];
					}
				}
			}
			result[j] = max;
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = maxSlidingWindow(nums, 3);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
