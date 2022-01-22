package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

	public class TreeNode {
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

	public static boolean isValidBST(TreeNode root) {
		List<Integer> preorder = new ArrayList<>();
		preorder(root, preorder);
		boolean isValid = true;
		System.out.print(preorder);
		for (int i = 1; i < preorder.size(); i++) {
			if (preorder.get(i) <= preorder.get(i - 1)) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	private boolean validate(TreeNode root, String subTreeDir, int rootValue) {
		if (root == null) {
			return true;
		}
		boolean checkLeft = true;
		boolean checkRight = true;
		if (root.left != null && root.val > root.left.val) {
			if ("R".equals(subTreeDir)) {
				checkLeft = root.left.val > rootValue;
			}
			if ("L".equals(subTreeDir)) {
				checkLeft = root.left.val < rootValue;
			}
			checkLeft = checkLeft && validate(root.left, "L", root.val);
		} else {
			if (root.left != null && root.val <= root.left.val) {
				checkLeft = false;
			}
		}
		if (root.right != null && root.val < root.right.val) {
			if ("R".equals(subTreeDir)) {
				checkRight = root.right.val > rootValue;
			}
			if ("L".equals(subTreeDir)) {
				checkRight = root.right.val < rootValue;
			}
			checkRight = checkRight && validate(root.right, "R", root.val);
		} else {
			if (root.right != null && root.val >= root.right.val) {
				checkRight = false;
			}
		}
		return checkLeft && checkRight;

	}

	private static void preorder(TreeNode root, List<Integer> preorder) {
		if (root == null) {
			return;
		}
		preorder(root.left, preorder);
		preorder.add(root.val);
		preorder(root.right, preorder);
	}

}
