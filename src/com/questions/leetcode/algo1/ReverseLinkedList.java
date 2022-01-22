package com.questions.leetcode.algo1;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = null;
		ListNode q = null;
		ListNode r = head;
		while (r != null) {
			p = q;
			q = r;
			r = r.next;
			q.next = p;
		}
		return q;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 4 };

		ListNode node1 = null;
		ListNode nextNode1 = null;
		for (int i = 0; i < arr1.length; i++) {
			ListNode currentNode = new ListNode(arr1[i]);
			if (node1 == null) {
				node1 = currentNode;
			} else {
				nextNode1.next = currentNode;
			}
			nextNode1 = currentNode;
		}
		ListNode reversed = reverseList(node1);
		System.out.println(reversed);
	}

}
