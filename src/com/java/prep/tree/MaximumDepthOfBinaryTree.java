package com.java.prep.tree;

public class MaximumDepthOfBinaryTree {

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

	int maxDepth = 0;

	public int maxDepth(TreeNode root) {
		findDepth(root, 0);
		return maxDepth;
	}

	private void findDepth(TreeNode root, int currentDepth) {
		if (currentDepth > maxDepth) {
			maxDepth = currentDepth;
		}
		if (root == null) {
			return;
		}
		findDepth(root.left, currentDepth + 1);
		findDepth(root.right, currentDepth + 1);
	}

}
