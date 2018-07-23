package com.java.hackerrank.ds.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

	private static Queue<Node> queue = new LinkedList<>();

	public static void levelOrder(Node root) {
		if (root != queue.peek()) {
			queue.add(root);
		}
		if (root.left != null) {
			queue.add(root.left);
		}
		if (root.right != null) {
			queue.add(root.right);
		}
		System.out.print(queue.poll().data + " ");
		while (queue.peek() != null) {
			levelOrder(queue.peek());
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
		levelOrder(root);
	}
}