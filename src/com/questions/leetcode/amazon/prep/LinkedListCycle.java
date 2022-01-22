package com.questions.leetcode.amazon.prep;

import com.questions.leetcode.amazon.prep.ReverseLinkedList.ListNode;

public class LinkedListCycle {

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

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return false;
		}
		ListNode p = head;
		ListNode q = head.next;
        boolean hasCycle = false;
		while (q != null && q.next  != null && q.next.next != null) {
			if (p == q) {
				hasCycle = true;
                break;
			}
			p = p.next;
		    q = q.next.next;
		}
		return hasCycle;
	}

}
