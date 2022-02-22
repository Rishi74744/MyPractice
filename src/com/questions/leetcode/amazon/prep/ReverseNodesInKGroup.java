package com.questions.leetcode.amazon.prep;

import com.questions.leetcode.amazon.prep.SwapNodesInPairs.ListNode;

public class ReverseNodesInKGroup {

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

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		int num = 1;
		ListNode prevNode = null;
		ListNode newNode = null;
		ListNode currentHead = head;
		ListNode endNode = head;
		ListNode startNode = currentHead;
		while (currentHead != null) {
			endNode = currentHead.next;
			num++;
			if (num % k == 0) {
				num = 1;
				ListNode nextNode = endNode.next;
				ListNode rev = reverse(startNode, endNode, k);
				ListNode l = rev;
				while (l.next != null) {
					l = l.next;
				}
				l.next = nextNode;
				currentHead = nextNode;
				startNode = nextNode;
				if (newNode == null) {
					newNode = rev;
				}
				if (prevNode != null) {
					prevNode.next = rev;
				}
				prevNode = rev;
			} else {
				currentHead = currentHead.next;
			}
		}
		if (num % k != 0) {
			prevNode.next = startNode;
		}
		return newNode;
	}

	public static ListNode reverse(ListNode node, ListNode endNode, int k) {
		ListNode p = null;
		ListNode q = null;
		int j = 0;
		while (node != null) {
			p = q;
			q = node;
			node = node.next;
			if (p == null) {
				q.next = node;
			} else {
				q.next = p;
			}
			j++;
			if (j == k) {
				break;
			}
		}
		return q;
	}

	public static void main(String[] args) {
		ListNode head2 = null;
		int num2[] = { 1, 2, 3, 4, 5, 6, 7 };
		ListNode prevNode2 = head2;
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
		ListNode t = reverseKGroup(head2, 3);
		while (t != null) {
			System.out.println(t.val);
			t = t.next;
		}
	}

}
