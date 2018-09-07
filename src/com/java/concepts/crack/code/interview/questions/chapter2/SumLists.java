package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.Scanner;

public class SumLists {

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

	public static SinglyLinkedListNode sumList(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode l1 = head1;
		SinglyLinkedListNode l2 = head2;
		SinglyLinkedList llist = new SinglyLinkedList();
		if (head1 == null && head2 == null) {
			return null;
		}
		if (head1 == null && head2 != null) {
			return head2;
		}
		if (head2 == null && head1 != null) {
			return head1;
		}
		StringBuilder list1 = new StringBuilder();
		StringBuilder list2 = new StringBuilder();
		while (l1 != null) {
			list1.append(l1.data);
			l1 = l1.next;
		}
		while (l2 != null) {
			list2.append(l2.data);
			l2 = l2.next;
		}
		int sum = Integer.parseInt(list1.reverse() + "") + Integer.parseInt(list2.reverse() + "");
		StringBuilder result = new StringBuilder(sum + "");
		result = result.reverse();
		int i = 0;
		while (i != result.length()) {
			llist.insertNode(Integer.parseInt(Character.toString(result.charAt(i))));
			i++;
		}
		return llist.head;
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

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llistCount2 = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount2; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llistItem);
			}

			SinglyLinkedListNode result = sumList(llist1.head, llist2.head);

			printSinglyLinkedList(result, " - > ");

			/*
			 * bufferedWriter.write(String.valueOf(result));
			 * bufferedWriter.newLine();
			 */
		}

		// bufferedWriter.close();

		scanner.close();
	}

}
