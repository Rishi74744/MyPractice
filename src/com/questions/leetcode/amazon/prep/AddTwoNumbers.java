package com.questions.leetcode.amazon.prep;

public class AddTwoNumbers {

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

	public static ListNode addTwoNumbersBruteForce(ListNode l1, ListNode l2) {
		int num1 = 0;
		int num2 = 0;
		while (l1 != null) {
			num1 = num1 * 10 + l1.val;
			l1 = l1.next;
		}
		while (l2 != null) {
			num2 = num2 * 10 + l2.val;
			l2 = l2.next;
		}
		int sum = num1 + num2;
		ListNode sumNum = null;
		ListNode prev = null;
		while (sum != 0) {
			int rem = sum % 10;
			ListNode current = new ListNode(rem);
			if (sumNum == null) {
				sumNum = current;
			} else {
				prev.next = current;
			}
			prev = current;
			sum /= 10;
		}
		return sumNum;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int carry = 0;
		ListNode sum = null;
		ListNode prev = null;
		while (l1 != null && l2 != null) {
			int currentSum = l1.val + l2.val + carry;
			if (currentSum >= 10) {
				currentSum = currentSum - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode currentNode = new ListNode(currentSum);
			if (sum == null) {
				sum = currentNode;
			} else {
				prev.next = currentNode;
			}
			prev = currentNode;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int currentSum = l1.val + carry;
			if (currentSum >= 10) {
				currentSum = currentSum - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode currentNode = new ListNode(currentSum);
			prev.next = currentNode;
			prev = currentNode;
			l1 = l1.next;
		}
		while (l2 != null) {
			int currentSum = l2.val + carry;
			if (currentSum >= 10) {
				currentSum = currentSum - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode currentNode = new ListNode(currentSum);
			prev.next = currentNode;
			prev = currentNode;
			l2 = l2.next;
		}
		if (carry != 0) {
			ListNode currentNode = new ListNode(carry);
			prev.next = currentNode;
			prev = currentNode;
		}
		return sum;
	}

	public static void main(String[] args) {
		ListNode head1 = null;
		int num1[] = { 9, 9, 9, 9, 9, 9, 9 };
		ListNode prevNode1 = head1;
		for (int i = 0; i < num1.length; i++) {
			if (i == 0) {
				head1 = new ListNode(num1[i]);
				prevNode1 = head1;
			} else {
				ListNode nextNode = new ListNode(num1[i]);
				prevNode1.next = nextNode;
				prevNode1 = nextNode;
			}

		}
		ListNode head2 = null;
		int num2[] = { 9, 9, 9, 9 };
		ListNode prevNode2 = head1;
		for (int i = 0; i < num2.length; i++) {
			if (i == 0) {
				head2 = new ListNode(num2[i]);
				prevNode2 = head2;
			} else {
				ListNode nextNode = new ListNode(num2[i]);
				prevNode2.next = nextNode;
				prevNode2 = nextNode;
			}
		}

		ListNode sum = addTwoNumbers(head1, head2);
		while (sum != null) {
			System.out.print(sum.val);
			sum = sum.next;
		}

	}
}
