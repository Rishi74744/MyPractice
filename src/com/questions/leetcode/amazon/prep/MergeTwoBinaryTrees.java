package com.questions.leetcode.amazon.prep;

public class MergeTwoBinaryTrees {

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

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		TreeNode currentNode = new TreeNode();
		if (root1 != null && root2 != null) {
			currentNode.val = root1.val + root2.val;
		} else if (root1 != null && root2 == null) {
			currentNode.val = root1.val;
		} else if (root1 == null && root2 != null) {
			currentNode.val = root2.val;
		}
		currentNode.left = mergeTrees(root1 == null ? root1 : root1.left, root2 == null ? root2 : root2.left);
		currentNode.right = mergeTrees(root1 == null ? root1 : root1.right, root2 == null ? root2 : root2.right);
		return currentNode;
	}
}
