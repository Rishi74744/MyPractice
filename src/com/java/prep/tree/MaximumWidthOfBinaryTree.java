package com.java.prep.tree;

public class MaximumWidthOfBinaryTree {

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

	int max = 0;

	public int widthOfBinaryTree(TreeNode root) {
		findWidth(root);
		return max;
	}

	public int findWidth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int left = 1 + findWidth(node.left);
			int right = 1 + findWidth(node.right);
			if (left == right) {
				max = Math.max(max, left);
			}
		}
		return 1;
	}

}
