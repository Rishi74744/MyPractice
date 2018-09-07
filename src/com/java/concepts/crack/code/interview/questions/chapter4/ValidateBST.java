package com.java.concepts.crack.code.interview.questions.chapter4;

public class ValidateBST {

	static boolean isValidBST = true;

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void validateBST(Node root) {
		if (root.left == null && root.right == null) {
			return;
		} else {
			if (root.left != null && root.left.data > root.data) {
				isValidBST = false;
				return;
			}
			if (root.right != null && root.right.data <= root.data) {
				isValidBST = false;
				return;
			}
			if (root.left != null) {
				validateBST(root.left);
			}
			if (root.right != null) {
				validateBST(root.right);
			}
		}
	}

}
