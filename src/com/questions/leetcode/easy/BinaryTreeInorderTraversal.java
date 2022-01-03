package com.questions.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorderList = new ArrayList<>();
		inorder(root, inorderList);
		return inorderList;
	}

	public void inorder(TreeNode node, List<Integer> inorderList) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorder(node.left, inorderList);
		}
		inorderList.add(node.val);
		if (node.right != null) {
			inorder(node.right, inorderList);
		}
	}

	public static void main(String[] args) {
		
	}

}
