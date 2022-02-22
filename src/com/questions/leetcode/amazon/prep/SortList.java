package com.questions.leetcode.amazon.prep;

import java.util.PriorityQueue;

public class SortList {

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

	public static ListNode sortList(ListNode head) {
		if (head.next == null) {
			return head;
		} else {
			ListNode middle = findMiddle(head);
			ListNode rightList = middle.next;
			middle.next = null;
			ListNode left = sortList(head);
			ListNode right = sortList(rightList);
			return merge(left, right);
		}
	}

	public static ListNode findMiddle(ListNode head) {
		ListNode current = head;
		ListNode ahead = head;
		while (ahead != null && ahead.next != null && ahead.next.next != null) {
			current = current.next;
			ahead = ahead.next.next;
		}
		return current;
	}

	public static ListNode merge(ListNode list1, ListNode list2) {
		ListNode mainNode = new ListNode();
		ListNode ahead = mainNode;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				ahead.next = list1;
				list1 = list1.next;
				ahead = ahead.next;
			} else {
				ahead.next = list2;
				list2 = list2.next;
				ahead = ahead.next;
			}
		}
		ahead.next = list1 != null ? list1 : list2;
		return mainNode.next;
	}

	public static void main(String[] args) {
		ListNode head = null;
		int arr[] = { 4, 2, 1, 3, -5, 8 };
		ListNode prevNode = head;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				head = new ListNode(arr[i]);
				prevNode = head;
			} else {
				ListNode nextNode = new ListNode(arr[i]);
				prevNode.next = nextNode;
				prevNode = nextNode;

			}

		}
		ListNode node = sortList(head);
		System.out.println(node.val);
	}

}
