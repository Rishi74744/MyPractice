package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an integer array nums,
 * 
 * return all the triplets [nums[i], nums[j], nums[k]]
 * 
 * such that i != j, i != k, and j != k,
 * 
 * and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1: Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Example 2: Input: nums = [] Output: []
 * 
 * Example 3: Input: nums = [0] Output: []
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 3000
 * 
 * -10^5 <= nums[i] <= 10^5
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				if (nums[i] + nums[low] + nums[high] == 0) {
					result.add(Arrays.asList(nums[i], nums[low], nums[high]));
					low++;
					high--;
					while (low < high && nums[low - 1] == nums[low]) {
						low++;
					}
					while (low < high && nums[high + 1] == nums[high]) {
						high--;
					}
				} else if (nums[i] + nums[low] + nums[high] > 0) {
					high--;
				} else {
					low++;
				}
			}
		}
		return result;
	}

	private void sort(int l, int h, int nums[]) {
		if (l < h) {
			int j = partition(l, h, nums);
			sort(l, j - 1, nums);
			sort(j + 1, h, nums);
		}
	}

	private int partition(int low, int high, int nums[]) {
		int pivot = nums[high];
		int pivotIndex = low - 1;
		for (int i = low; i < high; i++) {
			if (nums[i] <= pivot) {
				pivotIndex++;
				int temp = nums[i];
				nums[i] = nums[pivotIndex];
				nums[pivotIndex] = temp;
			}
		}
		pivotIndex++;
		int temp = nums[high];
		nums[high] = nums[pivotIndex];
		nums[pivotIndex] = temp;
		return pivotIndex;
	}

	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(t.threeSum(nums));
	}

}
