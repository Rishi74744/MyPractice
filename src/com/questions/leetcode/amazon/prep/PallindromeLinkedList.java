package com.questions.leetcode.amazon.prep;

public class PallindromeLinkedList {

	class ListNode {
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

	public boolean isPalindrome(ListNode head) {
		ListNode current = head;
		ListNode ahead = head;
		while (ahead != null && ahead.next != null) {
			current = current.next;
			ahead = ahead.next.next;
		}
		current = reverse(current);
		ahead = head;
		while (current != null) {
			if (current.val != ahead.val) {
				return false;
			}
			current = current.next;
			ahead = ahead.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode start = null;
		ListNode next = null;
		ListNode current = head;
		while (current != null) {
			start = next;
			next = current;
			current = current.next;
			next.next = start;
		}
		return next;
	}

}
