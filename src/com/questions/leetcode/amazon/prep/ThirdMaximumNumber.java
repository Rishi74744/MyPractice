package com.questions.leetcode.amazon.prep;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

	public int thirdMax1(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!s.contains(nums[i])) {
				s.add(nums[i]);
			}
		}
		Integer[] a = s.stream().toArray(Integer[]::new);
		if (a.length == 1) {
			return a[0];
		}
		if (a.length == 2) {
			return a[1];
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a[a.length - 3];
	}

	public static int thirdMax(int[] nums) {
		Integer first = null;
		Integer second = null;
		Integer third = null;
		for (int i = 0; i < nums.length; i++) {
			if (first == null) {
				first = nums[i];
			} else {
				if (first == nums[i] || (second != null && second == nums[i]) || (third != null && third == nums[i])) {
					continue;
				}
				if (first < nums[i]) {
					third = second;
					second = first;
					first = nums[i];
				} else if (second == null || second < nums[i]) {
					third = second;
					second = nums[i];
				} else if (third == null || third < nums[i]) {
					third = nums[i];
				}
			}
		}
		return third == null ? first : third;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 2, 3, 2, 1, 4, 5, 5, 1 };
		System.out.println(thirdMax(nums));
	}

}
