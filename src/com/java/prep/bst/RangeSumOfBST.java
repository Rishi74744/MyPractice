package com.java.prep.bst;

public class RangeSumOfBST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int rangeSum = 0;

	public int rangeSumBST(TreeNode root, int low, int high) {
		helper(root, low, high);
		return rangeSum;
	}

	public void helper(TreeNode root, int low, int high) {
		if (root == null) {
			return;
		}
		if (root.val >= low && root.val <= high) {
			rangeSum += root.val;
		} else {
			if (root.val > low) {
				helper(root.left, low, high);
			}
			if (root.val < high) {
				helper(root.right, low, high);
			}
		}
	}

}
