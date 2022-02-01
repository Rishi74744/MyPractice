package com.questions.leetcode.amazon.prep;

import com.questions.leetcode.amazon.prep.MergeTwoSortedLists.ListNode;

public class SortList {

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

	public ListNode sortList(ListNode head) {
		if (head.next == null) {
			return head;
		} else {
			ListNode middle = findMiddle(head);
			ListNode leftEnd = middle.next;
			leftEnd.next = null;
			ListNode left = sortList(head);
			ListNode right = sortList(leftEnd);
			return merge(left, right);
		}
	}

	public ListNode findMiddle(ListNode list) {
		if (list == null) {
			return null;
		}
		if (list.next == null) {
			return list;
		}
		if (list.next.next == null) {
			return list.next;
		}
		ListNode current = list;
		ListNode ahead = list.next;
		while (ahead != null && ahead.next != null && ahead.next.next != null) {
			current = current.next;
			ahead = ahead.next.next;
		}
		return current;
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode merged = null;
		ListNode prev = null;
		while (list1 != null || list2 != null) {
			int value = -101;
			if (list1 != null && list2 != null) {
				if (list1.val <= list2.val) {
					value = list1.val;
					list1 = list1.next;
				} else {
					value = list2.val;
					list2 = list2.next;
				}
			} else {
				if (list1 == null && list2 != null) {
					value = list2.val;
					list2 = list2.next;
				}
				if (list2 == null && list1 != null) {
					value = list1.val;
					list1 = list1.next;
				}
			}
			ListNode currentNode = new ListNode(value);
			if (merged == null) {
				merged = currentNode;
			} else {
				prev.next = currentNode;
			}
			prev = currentNode;
		}
		return merged;
	}

}
