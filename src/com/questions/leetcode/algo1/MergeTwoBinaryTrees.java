package com.questions.leetcode.algo1;

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

public class MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		int value = -1;
		TreeNode leftSubtree1 = null;
		TreeNode leftSubtree2 = null;
		TreeNode rightSubtree1 = null;
		TreeNode rightSubtree2 = null;
		if (root1 == null && root2 != null) {
			value = root2.val;
			leftSubtree2 = root2.left;
			rightSubtree2 = root2.right;
		} else if (root2 == null && root1 != null) {
			value = root1.val;
			leftSubtree1 = root1.left;
			rightSubtree1 = root1.right;
		} else {
			value = root1.val + root2.val;
			leftSubtree2 = root2.left;
			rightSubtree2 = root2.right;
			leftSubtree1 = root1.left;
			rightSubtree1 = root1.right;
		}
		TreeNode node = new TreeNode(value);
		node.left = mergeTrees(leftSubtree1, leftSubtree2);
		node.right = mergeTrees(rightSubtree1, rightSubtree2);
		return node;
	}

}
