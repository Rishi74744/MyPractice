package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.Scanner;

public class PallindromeList {

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

	public static SinglyLinkedListNode createPallindrome(SinglyLinkedListNode node) {
		if (node == null) {
			return null;
		}
		if (node.next == null) {
			return node;
		}
		StringBuilder str = new StringBuilder();
		while (node != null) {
			str.append(node.data);
			node = node.next;
		}
		str = str.reverse();
		SinglyLinkedList llist1 = new SinglyLinkedList();
		for (int i = 0; i < str.length(); i++) {
			llist1.insertNode(Integer.parseInt(Character.toString(str.charAt(i))));
		}
		return llist1.head;
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
			SinglyLinkedListNode llist2 = createPallindrome(llist1.head);

			printSinglyLinkedList(llist2, " - > ");

		}
		scanner.close();
	}

}