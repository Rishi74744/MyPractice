package com.java.concepts.crack.code.interview.questions.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ListOfDepths {

	static List<List<Integer>> levels = new ArrayList<>();
	static Queue<Node> queue = new LinkedList<>();

	public static void verticalOrderTraversal(int currentLevel) {
		while (!queue.isEmpty()) {
			List<Integer> list = null;
			Node current = queue.poll();
			if (levels.size() < currentLevel + 1) {
				list = new ArrayList<>();
				list.add(current.data);
				levels.add(list);
			} else {
				list = levels.get(currentLevel);
				list.add(current.data);
				levels.set(currentLevel, list);
			}
			if (current.left != null) {
				queue.add(current.left);
				verticalOrderTraversal(currentLevel + 1);
			}
			if (current.right != null) {
				queue.add(current.right);
				verticalOrderTraversal(currentLevel + 1);
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
		queue.add(root);
		verticalOrderTraversal(0);
		System.out.println(levels);
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
