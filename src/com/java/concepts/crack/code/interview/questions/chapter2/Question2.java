package com.java.concepts.crack.code.interview.questions.chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Question2 {

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

	public static void findKthElement(SinglyLinkedListNode head, int k) {
		int count = 0;
		SinglyLinkedListNode current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		current = head;
		int j = count - k;
		while (j != 0) {
			current = current.next;
			j--;
		}
		System.out.println(k + " element from last : " + current.data);
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
		int k = scanner.nextInt();
		findKthElement(llist1.head, k);
		scanner.close();
	}

}

/**
 * Question : 2 ---> Return Kth to Last: Implement an algorithm to nd the kth to
 * last element of a singly linked list.
 */