package com.questions.leetcode.amazon.prep;

public class SumRootToLeafNumbers {

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

	int total = 0;

	public int sumNumbers(TreeNode root) {
		helper(root, 0);
		return total;
	}

	public void helper(TreeNode root, int currentNum) {
		if (root == null) {
			return;
		}
		currentNum = (currentNum * 10) + root.val;
		if (root.left == null && root.right == null) {
			total += currentNum;
		} else {
			helper(root.left, currentNum);
			helper(root.right, currentNum);
		}
	}

}
