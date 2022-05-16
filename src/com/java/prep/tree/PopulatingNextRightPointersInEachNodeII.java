package com.java.prep.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 * 
 * struct Node {
 * 
 * int val;
 * 
 * Node *left;
 * 
 * Node *right;
 * 
 * Node *next;
 * 
 * }
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,7]
 * 
 * Output: [1,#,2,3,#,4,5,7,#]
 * 
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 * 
 * Example 2:
 * 
 * Input: root = []
 * 
 * Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 6000].
 * 
 * -100 <= Node.val <= 100
 * 
 * 
 * Follow-up:
 * 
 * You may only use constant extra space.
 * 
 * The recursive approach is fine. You may assume implicit stack space does not
 * count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNodeII {

	private static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	/**
	 * Complexity - O(n + m) - where n is total nodes and m is edges. It can be
	 * ignored as each node will have atmost 2 edges ~ O(n).
	 * 
	 * Space - O(n) for queue.
	 */
	public Node connectWithDFS(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node lastChild = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node currentNode = queue.poll();
				currentNode.next = lastChild;
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				lastChild = currentNode;
			}
			lastChild = null;

		}
		return root;
	}

	/**
	 * Complexity - O(n)
	 * 
	 * Space - O(1)
	 */
	public Node connect(Node root) {
		Node lastChild = new Node(0);
		Node previousNode = lastChild;
		Node currentNode = root;
		while (root != null) {
			if (root.left != null) {
				previousNode.next = root.left;
				previousNode = previousNode.next;
			}
			if (root.right != null) {
				previousNode.next = root.right;
				previousNode = previousNode.next;
			}
			root = root.next;
			if (root == null) {
				previousNode = lastChild;
				root = lastChild.next;
				lastChild.next = null;
			}
		}
		return currentNode;
	}

}
