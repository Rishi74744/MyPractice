package com.questions.leetcode.amazon.prep;

public class CopyListWithRandomPointer {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		Node root = null;
		Node prev = null;
		Node originalList = head;
		while (originalList != null) {
			Node node = new Node(originalList.val);
			if (root == null) {
				root = node;
			} else {
				prev.next = node;
			}
			prev = node;
			originalList = originalList.next;
		}
		Node newList = root;
		while (head.next != null && newList != null) {
//			newList.random = 
		}
		return root;
	}

}
