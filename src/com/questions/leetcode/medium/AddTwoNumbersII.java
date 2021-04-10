package com.questions.leetcode.medium;

public class AddTwoNumbersII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		addWithCarry(l1, l2, result);
		return result;
	}

	public int addWithCarry(ListNode l1, ListNode l2, ListNode prevNode) {
		if (l1 == null && l2 == null) {
			prevNode.next = null;
			return 0;
		} else {
			int topNum = 0;
			int bottomNum = 0;
			if (l1.next != null) {
				topNum = l1.val;
				l1 = l1.next;
			}
			if (l2.next != null) {
				bottomNum = l2.val;
				l2 = l2.next;
			}
			ListNode currentNode = new ListNode();
			int carry = addWithCarry(l1, l2, currentNode);
			currentNode.val = (topNum + bottomNum + carry) % 10;
			prevNode.next = currentNode;
			return (topNum + bottomNum + carry) / 10;
		}
	}

}
