package com.java.prep.bit;

public class BinaryIndexedTree {
// Also know as Fenwick Tree.
	int nums[];
	int bit[];
	int n = 0;

	public BinaryIndexedTree(int nums[]) {
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
		updateValue(i, difference);
	}

	private void updateValue(int i, int val) {
		i++;
		while (i <= n) {
			bit[i] += val;
			i += i & (-i);
		}
	}

	public int getRangeSum(int left, int right) {
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

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		BinaryIndexedTree b = new BinaryIndexedTree(arr);
		System.out.println(b.getRangeSum(1, 3));
		b.update(1, 10);
		System.out.println(b.getRangeSum(1, 3));
	}

}
