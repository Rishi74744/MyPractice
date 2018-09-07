package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.Scanner;

public class ReturnKthToLast {

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

	public static void kthToLastElement(SinglyLinkedListNode head, int k) {
		int totalNodes = 0;
		SinglyLinkedListNode list = head;
		while (list != null) {
			list = list.next;
			totalNodes++;
		}
		list = head;
		int kth = totalNodes - k;
		for (int i = 0; i < kth; i++) {
			list = list.next;
		}
		System.out.println(list.data);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			SinglyLinkedList llist1 = new SinglyLinkedList();

			int k = scanner.nextInt();

			int llistCount1 = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount1; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llistItem);
			}
			kthToLastElement(llist1.head, k);

			// printSinglyLinkedList(llist1.head, " - > ");

		}
		scanner.close();
	}

}