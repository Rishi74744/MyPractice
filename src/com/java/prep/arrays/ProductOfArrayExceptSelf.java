package com.java.prep.arrays;

public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int nums[]) {
		int prefix[] = new int[nums.length];
		int suffix = 1;
		prefix[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			prefix[i] = nums[i - 1] * prefix[i - 1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			suffix *= nums[i + 1];
			prefix[i] *= suffix;
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4 };
		int res[] = productExceptSelf(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}
