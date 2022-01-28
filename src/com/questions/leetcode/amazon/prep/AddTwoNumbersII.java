package com.questions.leetcode.amazon.prep;

import java.util.Stack;

public class AddTwoNumbersII {

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
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode sum = null;
		while (!stack1.isEmpty() && !stack2.empty()) {
			int val = stack1.pop() + stack2.pop() + carry;
			if (val > 9) {
				val = val - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode currentNode = new ListNode(val);
			currentNode.next = sum;
			sum = currentNode;
		}
		while (!stack1.isEmpty()) {
			int val = stack1.pop() + carry;
			if (val > 9) {
				val = val - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode currentNode = new ListNode(val);
			currentNode.next = sum;
			sum = currentNode;
		}

		while (!stack2.isEmpty()) {
			int val = stack2.pop() + carry;
			if (val > 9) {
				val = val - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode currentNode = new ListNode(val);
			currentNode.next = sum;
			sum = currentNode;
		}
		if (carry != 0) {
			ListNode currentNode = new ListNode(carry);
			currentNode.next = sum;
			sum = currentNode;
		}
		return sum;
	}

	public static ListNode addTwoNumbersBruteForce(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		l1 = reverse(l1);
		l2 = reverse(l2);
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

	public static ListNode reverse(ListNode root) {
		ListNode p = null;
		ListNode q = null;
		ListNode r = root;
		while (r != null) {
			p = q;
			q = r;
			r = r.next;
			q.next = p;
		}
		return q;
	}

	public static void main(String[] args) {
		ListNode head1 = null;
		int num1[] = { 5 };
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
		int num2[] = { 5 };
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
