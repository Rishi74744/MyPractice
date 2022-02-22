package com.questions.leetcode.amazon.prep;

public class SwapNodesInPairs {

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

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode nextNode = current.next;
		ListNode newHead = null;
		ListNode prev = null;
		while (current != null) {
			current.next = nextNode.next;
			nextNode.next = current;
			if (prev != null) {
				prev.next = nextNode;
			}
			prev = current;
			if (newHead == null) {
				newHead = nextNode;
			}
			if (current.next != null) {
				current = current.next;
			}
			if (current != null && current.next != null) {
				nextNode = current.next;
			} else {
				break;
			}

		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head2 = null;
		int num2[] = { 1, 2, 3 };
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
		ListNode t = swapPairs(head2);
		while (t != null) {
			System.out.println(t.val);
			t = t.next;
		}
	}

}
