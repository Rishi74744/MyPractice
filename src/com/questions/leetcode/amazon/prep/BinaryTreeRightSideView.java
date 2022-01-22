package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeRightSideView {

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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> view = new ArrayList<>();
		Set<Integer> levels = new HashSet<>();
		traverse(root, 0, view, levels);
		return view;
	}

	void traverse(TreeNode node, int level, List<Integer> view, Set<Integer> levels) {
		if (node == null) {
			return;
		}
		if (!levels.contains(level)) {
			view.add(node.val);
			levels.add(level);
		}
		traverse(node.right, level + 1, view, levels);
		if (!levels.contains(level + 1)) {
			traverse(node.left, level + 1, view, levels);
		}
	}

}
