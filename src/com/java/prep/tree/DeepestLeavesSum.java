package com.java.prep.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the sum of values of its deepest
 * leaves.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8] Output: 15 Example
 * 2:
 * 
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5] Output: 19
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. 1 <= Node.val <=
 * 100
 */
public class DeepestLeavesSum {

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

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public int deepestLeavesSumWithBFS(TreeNode root) {
		// return 0 if root is null.
		if (root == null) {
			return 0;
		}
		int leavesSum = 0;
		
		// queue to keep track of next node to visit.
		Queue<TreeNode> bfsQueue = new LinkedList<>();
		
		// add the root node to the queue.
		bfsQueue.offer(root);
		
		// iterate through queue until it is empty.
		while (!bfsQueue.isEmpty()) {
			
			// take the queue size.
			int size = bfsQueue.size();
			
			// reset the leaves sum to 0 for this level
			leavesSum = 0;
			
			// iterate through queue elements till the queue size.
			for (int i = 0; i < size; i++) {
				
				// pop the element at the first position.
				TreeNode current = bfsQueue.poll();
				
				// add the node value to leaves sum.
				leavesSum += current.val;
				
				// add the left node to queue if present.
				if (current.left != null) {
					bfsQueue.offer(current.left);
				}
				
				// add the right node to queue if present.
				if (current.right != null) {
					bfsQueue.offer(current.right);
				}

			}
		}
		
		// return the leaves sum.
		return leavesSum;
	}

	int sum = 0;
	int maxLevel = Integer.MIN_VALUE;

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public int deepestLeavesSum(TreeNode root) {
		// call helper method to calculate deepest leaves sum recursively.
		helper(0, root);
		
		// return the final sum.
		return sum;
	}

	public void helper(int currentLevel, TreeNode node) {

		// return if node is null
		if (node == null) {
			return;
		}

		// if current level is same as max level then add the node value to the sum.
		if (currentLevel == maxLevel) {
			sum += node.val;
		}

		// if current level is greater than max level then updated max level as current
		// level and sum with current node value.
		if (currentLevel > maxLevel) {
			sum = node.val;
			maxLevel = currentLevel;
		}

		// check for left sub tree.
		helper(currentLevel + 1, node.left);

		// check for right sub tree.
		helper(currentLevel + 1, node.right);
	}

}
