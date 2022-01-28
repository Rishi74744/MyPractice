package com.questions.leetcode.amazon.prep;

import com.questions.leetcode.amazon.prep.SubTreeOfAnotherTree.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

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

	int maxTotal = 0;

	public TreeNode bstToGst(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = bstToGst(root.right);
		int newVal = root.val + maxTotal;
		TreeNode currentNode = new TreeNode(newVal);
		maxTotal = newVal;
		currentNode.right = right;
		currentNode.left = bstToGst(root.left);
		return currentNode;
	}
}
