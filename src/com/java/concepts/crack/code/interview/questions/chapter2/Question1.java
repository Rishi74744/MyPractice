package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question1 {

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

	static void removeDupsWithBuffer(SinglyLinkedListNode node) {
		Set<Integer> dups = new HashSet<>();
		SinglyLinkedListNode head = node;
		SinglyLinkedListNode prev = node;
		while (head != null) {
			if (!dups.contains(head.data)) {
				dups.add(head.data);
				prev = head;
			} else {
				prev.next = head.next;
			}
			head = head.next;
		}
	}

	static void removeDupsWithOutBuffer(SinglyLinkedListNode node) {
		SinglyLinkedListNode head = node;
		while (head != null) {
			SinglyLinkedListNode prev = head.next;
			SinglyLinkedListNode current = head.next;
			while (current != null) {
				if (head.data == current.data) {
					prev.next = current.next;
				} else {
					prev = current;
					current = current.next;
				}
			}
			head = head.next;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		SinglyLinkedList llist1 = new SinglyLinkedList();
		int llistCount1 = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < llistCount1; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			llist1.insertNode(llistItem);
		}
		removeDupsWithBuffer(llist1.head);
		printSinglyLinkedList(llist1.head, " - > ");
		scanner.close();
	}

}

/**
 * Question : 1 ---> Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP How would you solve this problem if a temporary buffer is not
 * allowed?
 */
