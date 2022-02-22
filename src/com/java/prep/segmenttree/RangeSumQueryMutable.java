package com.java.prep.segmenttree;

public class RangeSumQueryMutable {

	int nums[];
	int segmentTree[];
	int n = 0;

	public RangeSumQueryMutable(int[] nums) {
		this.nums = nums;
		n = nums.length;
		int height = (int) Math.ceil(Math.log(n) / Math.log(2));
		int totalNodes = 2 * (int) Math.pow(2, height) - 1;
		segmentTree = new int[totalNodes];
		generateSegmentTree(0, n - 1, 0);
	}

	private int generateSegmentTree(int start, int end, int currentIndex) {
		if (start == end) {
			segmentTree[currentIndex] = nums[start];
			return nums[start];
		}
		int mid = getMid(start, end);
		segmentTree[currentIndex] = generateSegmentTree(start, mid, 2 * currentIndex + 1)
				+ generateSegmentTree(mid + 1, end, 2 * currentIndex + 2);
		return segmentTree[currentIndex];
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	public void update(int index, int val) {
		if (index < 0 || index > n - 1) {
			return;
		}
		int difference = val - nums[index];
		nums[index] = val;
		updateHelper(0, n - 1, index, difference, 0);
	}

	private void updateHelper(int start, int end, int index, int difference, int currentIndex) {
		if (index < start || index > end) {
			return;
		}
		segmentTree[currentIndex] += difference;
		if (start != end) {
			int mid = getMid(start, end);
			updateHelper(start, mid, index, difference, 2 * currentIndex + 1);
			updateHelper(mid + 1, end, index, difference, 2 * currentIndex + 2);
		}
	}

	public int sumRange(int left, int right) {
		if (left < 0 || right > n - 1 || left > right) {
			return -1;
		}
		return sum(0, n - 1, left, right, 0);
	}

	private int sum(int start, int end, int left, int right, int currentIndex) {
		if (left <= start && right >= end) {
			return segmentTree[currentIndex];
		}
		if (end < left || start > right) {
			return 0;
		}
		int mid = getMid(start, end);
		return sum(start, mid, left, right, 2 * currentIndex + 1)
				+ sum(mid + 1, end, left, right, 2 * currentIndex + 2);
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