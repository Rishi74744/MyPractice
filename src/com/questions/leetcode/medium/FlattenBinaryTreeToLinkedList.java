package com.questions.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

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

	public List<Integer> flatten(TreeNode root) {
		List<Integer> preorderList = new ArrayList<>();
		return preorderList;
	}

}
