package com.questions.leetcode.algo1;

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

public class MergedTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 4 };
		int arr2[] = { 1, 3, 4 };
		ListNode node1 = null;
		ListNode nextNode1 = null;
		for (int i = 0; i < arr1.length; i++) {
			ListNode currentNode = new ListNode(arr1[i]);
			if (node1 == null) {
				node1 = currentNode;
			} else {
				nextNode1.next = currentNode;
			}
			nextNode1 = currentNode;
		}

		ListNode node2 = null;
		ListNode nextNode2 = null;
		for (int i = 0; i < arr2.length; i++) {
			ListNode currentNode = new ListNode(arr2[i]);
			if (node2 == null) {
				node2 = currentNode;
			} else {
				nextNode2.next = currentNode;
			}
			nextNode2 = currentNode;
		}

		mergeTwoLists(node1, node2);

	}

}
