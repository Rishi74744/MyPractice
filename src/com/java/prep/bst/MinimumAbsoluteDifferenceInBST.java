package com.java.prep.bst;

public class MinimumAbsoluteDifferenceInBST {

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

	int minDiff = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return minDiff;
	}

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			minDiff = Math.min(Math.abs(root.val - root.left.val), minDiff);
			dfs(root.left);
		}
		if (root.right != null) {
			minDiff = Math.min(Math.abs(root.val - root.right.val), minDiff);
			dfs(root.right);
		}
	}

}
