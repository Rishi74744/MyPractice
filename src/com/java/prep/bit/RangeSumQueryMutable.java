package com.java.prep.bit;

public class RangeSumQueryMutable {

	int nums[];
	int bit[];
	int n = 0;

	public RangeSumQueryMutable(int[] nums) {
		this.n = nums.length;
		this.nums = nums;
		bit = new int[n + 1];
		construct(nums);
	}

	private void construct(int nums[]) {
		for (int i = 0; i < n; i++) {
			updateValue(i, nums[i]);
		}
	}

	public void update(int i, int val) {
		int difference = val - nums[i];
		nums[i] = val;
		update(i, difference);
	}

	private void updateValue(int i, int val) {
		i++;
		while (i <= n) {
			bit[i] += val;
			i += i & (-i);
		}
	}

	public int sumRange(int left, int right) {
		return getSum(right) - getSum(left - 1);
	}

	public int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += bit[i];
			i -= i & (-i);
		}
		return sum;
	}

}

/**
 * ((((((((((((((((((((((Leet Code)))))))))))))))))))))) Given an integer array
 * nums, handle multiple queries of the following types:
 * 
 * Update the value of an element in nums. Calculate the sum of the elements of
 * nums between indices left and right inclusive where left <= right. Implement
 * the NumArray class:
 * 
 * NumArray(int[] nums) Initializes the object with the integer array nums. void
 * update(int index, int val) Updates the value of nums[index] to be val. int
 * sumRange(int left, int right) Returns the sum of the elements of nums between
 * indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
 * nums[right]).
 * 
 * 
 * Example 1:
 * 
 * Input ["NumArray", "sumRange", "update", "sumRange"] [[[1, 3, 5]], [0, 2],
 * [1, 2], [0, 2]] Output [null, 9, null, 8]
 * 
 * Explanation NumArray numArray = new NumArray([1, 3, 5]); numArray.sumRange(0,
 * 2); // return 1 + 3 + 5 = 9 numArray.update(1, 2); // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 -100 <= nums[i] <= 100 0 <= index < nums.length
 * -100 <= val <= 100 0 <= left <= right < nums.length At most 3 * 104 calls
 * will be made to update and sumRange.
 * 
 */