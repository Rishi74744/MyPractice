package com.questions.leetcode.amazon.prep;

public class SumOfNodesWithEvenValuedGrandparent {

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

	int sum = 0;

	public int sumEvenGrandparent(TreeNode root) {
		int result = 0;
		helper(root, null, null);
		return result;
	}

	public void helper(TreeNode node, TreeNode parent, TreeNode grandParent) {
		if (node == null) {
			return;
		}
		if (parent != null && grandParent != null && parent.val % 2 == 0 && grandParent.val % 2 == 0) {
			sum += node.val;
		}
		helper(node.left, node, parent);
		helper(node.right, node, parent);
	}

}
