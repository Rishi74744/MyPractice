package com.questions.leetcode.amazon.prep;

public class SubTreeOfAnotherTree {

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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (root.val == subRoot.val) {
			if (isSimilar(root, subRoot)) {
				return true;
			}
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean isSimilar(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		} else if (root != null && subRoot == null) {
			return false;
		} else if (root == null && subRoot != null) {
			return false;
		}
		if (root.val != subRoot.val) {
			return false;
		}
		return isSimilar(root.left, subRoot.left) && isSimilar(root.right, subRoot.right);
	}

	public static void main(String[] args) {

	}

}
