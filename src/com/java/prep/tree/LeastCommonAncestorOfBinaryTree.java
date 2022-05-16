package com.java.prep.tree;

import com.java.prep.tree.LeastCommonAncestorOfBinarySearchTree.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3
 * 
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5
 * 
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition. Example 3:
 * 
 * Input: root = [1,2], p = 1, q = 2 Output: 1
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 105].
 * 
 * -10^9 <= Node.val <= 10^9
 * 
 * All Node.val are unique.
 * 
 * p != q
 * 
 * p and q will exist in the tree.
 *
 */
public class LeastCommonAncestorOfBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (right == null) {
			return left;
		}
		return right;
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		return checkLCA(root, p, q);
	}

	public TreeNode checkLCA(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null) {
			return null;
		}
		TreeNode currNode = null;
		if (node.val == p.val || node.val == q.val) {
			currNode = node;
		}
		TreeNode left = checkLCA(node.left, p, q);
		TreeNode right = checkLCA(node.right, p, q);
		if (currNode != null && (left != null || right != null)) {
			return currNode;
		}
		if (currNode != null && left == null && right == null) {
			return currNode;
		}
		if (currNode == null && left != null && right != null && left.val == right.val) {
			return left;
		}
		if (currNode == null && left == null && right != null) {
			return right;
		}
		if (currNode == null && right == null && left != null) {
			return left;
		}
		if (currNode == null && left != null && right != null && left.val != right.val) {
			return node;
		}
		return null;
	}

}
