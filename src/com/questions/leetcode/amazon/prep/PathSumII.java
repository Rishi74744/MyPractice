package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		helper(root, 0, targetSum, new ArrayList<>());
		return result;
	}

	public void helper(TreeNode root, int currentSum, int targetSum, List<Integer> currentPath) {
		if (root == null) {
			return;
		}
		currentPath.add(root.val);
		if (root.left == null && root.right == null && (currentSum + root.val) == targetSum) {
			result.add(currentPath);
		}
		List<Integer> newList = new ArrayList<>(currentPath);
		helper(root.left, currentSum + root.val, targetSum, newList);
		helper(root.right, currentSum + root.val, targetSum, newList);
	}

}
