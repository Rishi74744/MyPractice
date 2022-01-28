package com.questions.leetcode.amazon.prep;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Queue<Integer> q = new LinkedList<>();

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		StringBuilder tree = new StringBuilder();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			if (q != null) {
				tree.append(n.val);
				q.add(n.left);
				q.add(n.right);
			}
		}
		return tree.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return null;
	}

}
