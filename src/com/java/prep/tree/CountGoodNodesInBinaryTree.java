package com.java.prep.tree;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * 
 * Return the number of good nodes in the binary tree.
 * 
 * Input: root = [3,1,4,3,null,1,5] Output: 4 Explanation: Nodes in blue are
 * good. Root Node (3) is always a good node. Node 4 -> (3,4) is the maximum
 * value in the path starting from the root. Node 5 -> (3,4,5) is the maximum
 * value in the path Node 3 -> (3,1,3) is the maximum value in the path.
 *
 */

public class CountGoodNodesInBinaryTree {

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

	int goodNodes = 0;

	public int goodNodes(TreeNode root) {
		helper(root);
		return goodNodes;
	}

	private TreeNode helper(TreeNode currentNode) {
		if (currentNode == null) {
			return null;
		}
		if (currentNode.left == null && currentNode.right == null) {
			return currentNode;
		}
		return helper(currentNode.left);
	}

}
