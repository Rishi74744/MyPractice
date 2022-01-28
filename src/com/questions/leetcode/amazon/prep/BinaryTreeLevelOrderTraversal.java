package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

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

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		helper(root, 0);
		return result;
	}

	public void helper(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		List<Integer> levelList = new ArrayList<>();
		if (result.size() > level && result.get(level) != null) {
			levelList.addAll(result.get(level));
			result.remove(level);
		}
		levelList.add(root.val);
		result.add(level, levelList);
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}

	public static void main(String[] args) {
		List<List<Integer>> n = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(3);
		n.add(l1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(9);
		n.add(l2);

		List<Integer> l3 = n.get(1);
		l3.add(5);
		n.remove(1);
		n.add(1, l3);

		System.out.println(n);

	}

}
