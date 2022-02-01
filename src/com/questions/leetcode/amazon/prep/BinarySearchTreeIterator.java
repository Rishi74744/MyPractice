package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeIterator {

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

	class BSTIterator {

		private List<Integer> bst;

		public BSTIterator(TreeNode root) {
			bst = new ArrayList<>();
			deserializeBST(root);
		}

		void deserializeBST(TreeNode root) {
			if (root == null) {
				return;
			}
			deserializeBST(root.right);
			bst.add(root.val);
			deserializeBST(root.left);
		}

		public int next() {
			return bst.remove(bst.size() - 1);
		}

		public boolean hasNext() {
			return !bst.isEmpty();
		}
	}
}
