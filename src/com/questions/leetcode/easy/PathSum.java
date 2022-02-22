package com.questions.leetcode.easy;

public class PathSum {

	class TreeNode {
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

	boolean isValid = false;

	public boolean hasPathSum(TreeNode root, int targetSum) {
		helper(root, 0, targetSum);
		return isValid;
	}

	public void helper(TreeNode root, int currentSum, int targetSum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && (currentSum + root.val) == targetSum) {
			isValid = true;
		}
		helper(root.left, currentSum + root.val, targetSum);
		helper(root.right, currentSum + root.val, targetSum);
	}

}
