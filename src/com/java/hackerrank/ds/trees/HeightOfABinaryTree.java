package com.java.hackerrank.ds.trees;

import java.util.Scanner;

public class HeightOfABinaryTree {

	public static int height(Node root) {
		int h = countLevels(root);
		System.out.println(h);
		System.out.println(h - 1);
		return countLevels(root) - 1;
	}

	public static int countLevels(Node root) {
		if (root.left == null && root.right == null) {
			return 1;
		}
		int l = 1;
		if (root.left != null) {
			l = l + countLevels(root.left);
		}
		int r = 1;
		if (root.right != null) {
			r = r + countLevels(root.right);
		}
		return (l >= r) ? l : r;
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
		int height = height(root);
		System.out.println(height);
	}

}
