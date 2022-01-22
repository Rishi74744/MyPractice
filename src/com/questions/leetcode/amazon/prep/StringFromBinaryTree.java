package com.questions.leetcode.amazon.prep;

public class StringFromBinaryTree {
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

	public String tree2str(TreeNode root) {
		StringBuilder result = new StringBuilder("");
		convert(root, result);
		return result.toString();
	}

	private void convert(TreeNode node, StringBuilder treeStr) {
		treeStr.append(node.val);
		if (node.left != null) {
			treeStr.append("(");
			convert(node.left, treeStr);
			treeStr.append(")");
		}
		if (node.right != null) {
			if (node.left == null) {
				treeStr.append("()");
			}
			treeStr.append("(");
			convert(node.right, treeStr);
			treeStr.append(")");
		}
	}

	public static void main(String[] args) {

	}

}
