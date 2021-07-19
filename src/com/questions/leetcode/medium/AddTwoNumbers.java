package com.questions.leetcode.medium;

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

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addWithCarry(l1, l2, 0);
	}

	public ListNode addWithCarry(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null) {
			if (carry != 0) {
				return new ListNode(carry);
			} else {
				return null;
			}
		}
		int topNum = 0;
		int bottomNum = 0;
		if (l1 != null) {
			topNum = l1.val;
			l1 = l1.next;
		}
		if (l2 != null) {
			bottomNum = l2.val;
			l2 = l2.next;
		}
		return new ListNode((topNum + bottomNum + carry) % 10, addWithCarry(l1, l2, (topNum + bottomNum + carry) / 10));
	}

	public static void main(String[] args) {

	}

}
