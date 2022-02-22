package com.java.prep.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {

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

	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return false;
		}
		return checkSymmetry(root.left, root.right);
	}

	public boolean checkSymmetry(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val == right.val) {
			return checkSymmetry(left.right, right.left) && checkSymmetry(left.left, right.right);
		}
		return false;
	}

	public boolean isSymmetricIteration(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int s = q.size();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < s; i++) {
				TreeNode node = q.remove();
				if (node == null) {
					l.add(null);
					continue;
				}
				l.add(node.val);
				q.add(node.left);
				q.add(node.right);
			}
			if (!isPalindrome(l)) {
				return false;
			}
		}
		return true;
	}

	private boolean isPalindrome(List<Integer> list) {
		int n = list.size() - 1;
		if (n < 0)
			return true;
		for (int i = 0; i <= n / 2; i++) {
			if (list.get(i) != list.get(n - i)) {
				return false;
			}
		}
		return true;
	}

}
