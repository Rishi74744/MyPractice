package com.questions.leetcode.medium;

public class MiddleOfLinkedList {

	static class ListNode {
		public int data;
		public ListNode next;

		public ListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public ListNode head;
		public ListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			ListNode node = new ListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static ListNode middleNode(ListNode head) {
		ListNode current = head;
		ListNode ahead = head;
		while (ahead != null && ahead.next != null && ahead.next.next != null) {
			current = current.next;
			ahead = ahead.next.next;
		}
		return current;
	}

	public static void main(String[] args) {
		ListNode head = null;
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		ListNode prevNode = head;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				head = new ListNode(arr[i]);
				prevNode = head;
			} else {
				ListNode nextNode = new ListNode(arr[i]);
				prevNode.next = nextNode;
				prevNode = nextNode;

			}

		}
		ListNode middleNode = middleNode(head);
		System.out.println(middleNode.data);
	}

}
