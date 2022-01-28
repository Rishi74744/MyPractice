package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {

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

	Map<Integer, Integer> frequencyCount = new HashMap<>();

	public int[] findFrequentTreeSum(TreeNode root) {
		calculateSum(root);
		return new int[] {};
	}

	public void calculateSum(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			int count = frequencyCount.getOrDefault(root.val, 0) + 1;
			frequencyCount.put(root.val, count);
		} else if (root.left != null && root.right == null) {
			int count = frequencyCount.getOrDefault(root.val + root.left.val, 0) + 1;
			frequencyCount.put(root.val + root.left.val, count);
		} else if (root.left == null && root.right != null) {
			int count = frequencyCount.getOrDefault(root.val + root.right.val, 0) + 1;
			frequencyCount.put(root.val + root.right.val, count);
		} else {
			int count = frequencyCount.getOrDefault(root.val + root.right.val + root.left.val, 0) + 1;
			frequencyCount.put(root.val + root.right.val + root.left.val, count);
		}
		calculateSum(root.left);
		calculateSum(root.right);
	}

}
