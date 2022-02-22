package com.java.prep.bit;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int nums[] = { 4, 1, 0, 3, 12, 0 };
		m.moveZeroes(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

}
