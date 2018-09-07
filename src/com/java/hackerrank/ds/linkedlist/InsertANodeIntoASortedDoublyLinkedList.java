package com.java.hackerrank.ds.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;

public class InsertANodeIntoASortedDoublyLinkedList {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if (head == null) {
			return node;
		}
		if (head.next == null) {
			if (head.data > data) {
				node.next = head;
				head.prev = node;
				return node;
			} else {
				head.next = node;
				node.prev = head;
				return node;

			}
		}
		DoublyLinkedListNode current = head;
		while (current.next != null) {
			if (current.data <= data) {
				current = current.next;
			} else {
				if (current.next.data > data) {
					current.next = node;
					node.prev = current;
					current.next.prev = node;
				}
			}
		}
		return head;

	}

}