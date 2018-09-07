package com.java.concepts.crack.code.interview.questions.chapter4;

import java.util.Scanner;

public class MinimalTree {

	public static Node createMinimalTree(int arr[], int start, int end, boolean isRight) {
		if (end - start == 0) {
			Node node = new Node(arr[start]);
			return node;
		}
		int mid = end / 2;
		if (isRight) {
			mid = mid + 1;
		}
		Node root = new Node(arr[mid]);
		if (mid - start > 0)
			root.left = createMinimalTree(arr, start, mid - 1, false);
		root.right = createMinimalTree(arr, mid + 1, end, true);
		return root;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		Node node = createMinimalTree(arr, 0, n - 1, false);
		ListOfDepths.queue.add(node);
		ListOfDepths.verticalOrderTraversal(0);
		System.out.println(ListOfDepths.levels);
		scanner.close();
	}

}