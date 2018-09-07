package com.algorithms;

import java.util.Scanner;

public class DeepestNodeInBinaryTree {

	static int maxLevel = -1;

	public static int deepestNode(Node root) {
		if (root == null) {
			return -1;
		}
		Node deepestNode = new Node(-1);
		Integer currentLevel = new Integer(-1);
		// Integer maxLevel = new Integer(-1);
		levelLastNode(currentLevel + 1, deepestNode, root);
		return deepestNode.data;
	}

	public static void levelLastNode(Integer currentLevel, Node deepestNode, Node root) {
		if (root != null) {
			if (root.left == null && root.right == null && currentLevel >= maxLevel) {
				deepestNode.data = root.data;
				deepestNode.left = root.left;
				deepestNode.right = root.right;
				maxLevel = new Integer(currentLevel);
			} else {
				if (root.left != null) {
					levelLastNode(currentLevel + 1, deepestNode, root.left);
				}
				if (currentLevel >= maxLevel) {
					deepestNode.data = root.data;
					deepestNode.left = root.left;
					deepestNode.right = root.right;
					maxLevel = new Integer(currentLevel);
				}
				if (root.right != null) {
					levelLastNode(currentLevel + 1, deepestNode, root.right);
				}
			}
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
		int deepestNodeValue = deepestNode(root);
		System.out.println(deepestNodeValue);
		scan.close();
	}

}

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
