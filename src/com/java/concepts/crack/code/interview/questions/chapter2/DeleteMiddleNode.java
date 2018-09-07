package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.Scanner;

public class DeleteMiddleNode {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
		while (node != null) {
			System.out.print(node.data);

			node = node.next;

			if (node != null) {
				System.out.print(sep);
			}
		}
	}

	public static void deleteMiddleNode(SinglyLinkedListNode head) {
		if (head == null || head.next == null) {
			head = null;
			return;
		}
		SinglyLinkedListNode list = head;
		int nodeCount = 0;
		while (list != null) {
			nodeCount++;
			list = list.next;
		}
		int middle = 0;
		if (nodeCount % 2 == 0) {
			middle = nodeCount / 2;
		} else {
			middle = (nodeCount / 2) + 1;
		}
		list = head;
		SinglyLinkedListNode prev = list;
		while ((middle - 1) != 0) {
			prev = list;
			list = list.next;
			middle--;
		}
		prev.next = list.next;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llistCount1 = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount1; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llistItem);
			}
			deleteMiddleNode(llist1.head);

			printSinglyLinkedList(llist1.head, " - > ");

		}
		scanner.close();
	}

}