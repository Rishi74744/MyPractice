package com.questions.leetcode.amazon.prep;

public class ReverseLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
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

}
