package com.questions.leetcode.amazon.prep;

public class DiameterOfBinaryTree {

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

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			return 1 + Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
		} else if (root.left != null && root.right == null) {
			return 1 + diameterOfBinaryTree(root.left);
		} else if (root.left == null && root.right != null) {
			return 1 + diameterOfBinaryTree(root.right);
		} else {
			return 1;
		}
	}

}
