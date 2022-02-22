package com.java.prep.tree;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: 24 Explanation: There are two
 * left leaves in the binary tree, with values 9 and 15 respectively.
 * 
 */

public class SumOfLeftLeaves {

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

	int leftSum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		helper(root, false);
		return leftSum;
	}

	private void helper(TreeNode root, boolean isLeft) {
		if (root == null) {
			return;
		}
		if (isLeft && root.left == null && root.right == null) {
			leftSum += root.val;
		}
		helper(root.left, true);
		helper(root.right, false);
	}

}
