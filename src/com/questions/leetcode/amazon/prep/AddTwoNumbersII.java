package com.questions.leetcode.amazon.prep;

import com.questions.leetcode.amazon.prep.AddTwoNumbers.ListNode;

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
		ListNode num1 = null;
		ListNode num2 = null;
		ListNode sum = null;
		ListNode prev = null;
		int carry = 0;
		while (true) {
			num1 = l1;
			num2 = l2;
			ListNode prev1 = null;
			while (num1.next != null) {
				prev1 = num1;
				num1 = num1.next;
			}
			ListNode prev2 = null;
			while (num2.next != null) {
				prev2 = num2;
				num2 = num2.next;
			}
			if (prev1 != null) {
				prev1.next = null;
			}
			if (prev2 != null) {
				prev2.next = null;
			}
			int val = 0;
			if (num1 != null && num2 != null) {
				val = num1.val + num2.val + carry;
			} else if (num2 == null && num1 != null) {
				val = num1.val + carry;
			} else if (num1 == null && num2 != null) {
				val = num2.val + carry;
			}
			if (val >= 10) {
				val = 10 - val;
				carry = 1;
			}
			ListNode currentNode = new ListNode(val);
			if (sum == null) {
				currentNode.next = null;
			} else {
				currentNode.next = sum;
			}
			sum = currentNode;
			if (num1 == null && num2 == null) {
				break;
			}
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
		int num1[] = { 7, 2, 4, 3 };
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
		int num2[] = { 5, 6, 4 };
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

		ListNode sum = addTwoNumbersBruteForce(head1, head2);
		while (sum != null) {
			System.out.print(sum.val);
			sum = sum.next;
		}

	}

}
