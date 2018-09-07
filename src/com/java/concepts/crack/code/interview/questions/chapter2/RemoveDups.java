package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDups {

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

	public static void removeDups(SinglyLinkedListNode node) {
		Set<Integer> s = new HashSet<>();
		SinglyLinkedListNode prev = node;
		SinglyLinkedListNode current = node;
		while (current != null) {
			if (s.contains(current.data)) {
				prev.next = current.next;
			} else {
				s.add(current.data);
				prev = current;
			}
			current = current.next;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

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

			removeDups(llist1.head);

			printSinglyLinkedList(llist1.head, " - > ");

			/*
			 * bufferedWriter.write(String.valueOf(result));
			 * bufferedWriter.newLine();
			 */
		}

		// bufferedWriter.close();

		scanner.close();
	}

}
