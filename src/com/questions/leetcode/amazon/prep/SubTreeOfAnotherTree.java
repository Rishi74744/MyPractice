package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class SubTreeOfAnotherTree {

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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		} else if ((root != null && subRoot == null) || (root == null && subRoot != null)) {
			return false;
		} else {
			boolean checkLeft = false;
			boolean checkRight = false;
			if (root.val == subRoot.val) {
				checkLeft = isSubtree(root.left, subRoot.left);
				checkRight = checkLeft && isSubtree(root.left, subRoot.left);
				return checkRight;
			} else {
				checkLeft = isSubtree(root.left, subRoot);
				checkRight = isSubtree(root.right, subRoot);
				return checkLeft || checkRight;
			}
		}
	}

	public static void main(String[] args) {


	}

}
