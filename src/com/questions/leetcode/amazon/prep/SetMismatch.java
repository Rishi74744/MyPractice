package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

	public static int[] findErrorNums(int[] nums) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			int j = nums[i] - 1;
			if (nums[i] != nums[j]) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			} else {
				i++;
			}
		}
		for (i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return new int[] { nums[i], i + 1 };
			}
		}
		return new int[] {};
	}

	public static int[] findErrorNums1(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i : nums) {
			int c = 1;
			if (m.containsKey(i)) {
				c = m.get(i) + 1;
			}
			m.put(i, c);
		}
		int rep = 0;
		int mis = 0;
		for (int i = 1; i <= nums.length; i++) {
			if (!m.containsKey(i)) {
				mis = i;
			} else if (m.containsKey(i) && m.get(i) > 1) {
				rep = i;
			}
		}
		return new int[] { rep, mis };
	}

	public static void main(String[] args) {
		int n[] = { 3, 2, 3, 4, 6, 5 };
		int r[] = findErrorNums(n);
		for (int i : r) {
			System.out.println(i);
		}
	}
}
