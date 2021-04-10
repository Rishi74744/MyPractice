package com.questions.leetcode.challenge.twentyone.apr;

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

public class PallindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		StringBuilder str = new StringBuilder();
		while (head != null) {
			str.append(head.val);
			head = head.next;
		}
		return str.toString().equals(str.reverse().toString());
	}

}
