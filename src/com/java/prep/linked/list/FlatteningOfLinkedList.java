package com.java.prep.linked.list;

public class FlatteningOfLinkedList {

	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		Node() {

		}
	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node flattened = head;
		if (head.child != null) {
			Node next = flatten(head.child);
			flattened.next = next;
			if (next != null) {
				next.prev = flattened;
			}
			flattened = next;
		}
		Node next = flatten(head.next);
		if (flattened != null) {
			flattened.next = next;
		}
		if (next != null) {
			next.prev = flattened;
		}
		return flattened;
	}

	public static void main(String[] args) {

	}

}
