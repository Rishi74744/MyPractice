package com.java.concepts.crack.code.interview.questions.chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Successor {

	static List<Integer> nodes = new LinkedList<>();

	static void inorder(Node node) {
		if (node == null) {
			return;
		} else {
			if (node.left != null) {
				inorder(node.left);
			}
			nodes.add(node.data);
			if (node.right != null) {
				inorder(node.right);
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
		inorder(root);
		System.out.println("Enter the node for which inroder successor is required : ");
		int nodeData = scan.nextInt();
		if (nodes.contains(nodeData)) {
			int index = nodes.indexOf(nodeData);
			if (index + 1 > nodes.size()) {
				System.out.println("No inorder successor");
			} else {
				System.out.println("Inorder successor is : " + nodes.get(index + 1));
			}
		}
		scan.close();
	}

}