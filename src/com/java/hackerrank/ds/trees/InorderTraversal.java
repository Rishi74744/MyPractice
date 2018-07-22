package com.java.hackerrank.ds.trees;

import java.util.Scanner;

public class InorderTraversal {

	public static void inOrder(Node root) {
		if (root.left != null) {
			inOrder(root.left);
		}
		System.out.print(root.data + " ");
		if (root.right != null) {
			inOrder(root.right);
		}
	}

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

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		inOrder(root);
	}

}
