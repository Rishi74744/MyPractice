package com.java.prep.tree;

public class InvertBinaryTree {

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

	public TreeNode invertTree(TreeNode root) {
		helper(root);
		return root;
	}

	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode t = root.left;
		root.left = root.right;
		root.right = t;
		helper(root.left);
		helper(root.right);
	}

}
