package com.java.hackerrank.ds.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class CycleDetection {

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

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	static boolean hasCycle(SinglyLinkedListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		SinglyLinkedListNode current = head;
		SinglyLinkedListNode aheadTwo = head.next.next;
		if (current == aheadTwo) {
			return true;
		}
		boolean isCycle = false;
		while (current.next != null && aheadTwo != null) {
			if (current == aheadTwo) {
				isCycle = true;
				break;
			}
			current = current.next;
			if (current.next == null) {
				break;
			}
			aheadTwo = current.next.next;
		}

		return isCycle;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			boolean result = hasCycle(llist.head);

			System.out.println(String.valueOf(result ? 1 : 0));
			/*
			 * bufferedWriter.write(String.valueOf(result ? 1 : 0));
			 * bufferedWriter.newLine();
			 */
		}

		// bufferedWriter.close();

		scanner.close();
	}

}