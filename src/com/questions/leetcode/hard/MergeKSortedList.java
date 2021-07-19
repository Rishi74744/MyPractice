package com.questions.leetcode.hard;

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

public class MergeKSortedList {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		ListNode result = mergeTwoLists(lists[0], lists[1]);
		if (lists.length > 2) {
			for (int i = 2; i < lists.length; i++) {
				result = mergeTwoLists(lists[i], result);
			}
		}
		return result;
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