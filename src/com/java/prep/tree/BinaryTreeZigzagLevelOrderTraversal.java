package com.java.prep.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]]
 * 
 * Example 2:
 * 
 * Input: root = [1] Output: [[1]]
 * 
 * Example 3:
 * 
 * Input: root = [] Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000].
 * 
 * -100 <= Node.val <= 100
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int currentLevel = 0;
		while (!queue.isEmpty()) {
			System.out.println("Current Level : " + currentLevel + " Queue : " + queue);
			int size = queue.size();
			List<Integer> elements = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				elements.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (currentLevel % 2 == 0) {
				Collections.reverse(elements);
			}
			result.add(elements);
			currentLevel++;
		}
		return result;
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		zigZagTraverse(1, root, result);
		return result;
	}

	public void zigZagTraverse(int currentLevel, TreeNode node, List<List<Integer>> result) {
		if (result.size() < currentLevel) {
			result.add(new ArrayList<>());
		}
		if (currentLevel % 2 == 0) {
			result.get(currentLevel - 1).add(0, node.val);
		} else {
			result.get(currentLevel - 1).add(node.val);
		}
		if (node.left != null) {
			zigZagTraverse(currentLevel + 1, node.left, result);
		}
		if (node.right != null) {
			zigZagTraverse(currentLevel + 1, node.right, result);
		}
	}

}
