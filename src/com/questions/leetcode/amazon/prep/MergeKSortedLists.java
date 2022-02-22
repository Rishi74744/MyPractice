package com.questions.leetcode.amazon.prep;

import java.util.PriorityQueue;

public class MergeKSortedLists {

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

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i++) {
			ListNode list = lists[i];
			while (list != null) {
				minHeap.add(list.val);
				list = list.next;
			}
		}
		ListNode merged = null;
		ListNode prev = null;
		while (!minHeap.isEmpty()) {
			ListNode current = new ListNode(minHeap.poll());
			if (merged == null) {
				merged = current;
			} else {
				prev.next = current;
			}
			prev = current;
		}
		return merged;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else {
			if (l1 != null && l2 == null) {
				return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
			} else if (l1 == null && l2 != null) {
				return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
			} else {
				if (l1.val <= l2.val) {
					return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
				} else {
					return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
				}
			}
		}
	}

}
