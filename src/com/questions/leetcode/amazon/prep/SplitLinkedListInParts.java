package com.questions.leetcode.amazon.prep;

public class SplitLinkedListInParts {

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

	public ListNode[] splitListToParts(ListNode head, int k) {
		int n = 0;
		ListNode root = head;
		while (root != null) {
			n++;
			root = root.next;
		}
		int total = 0;
		int extraElement = 0;
		if (n % k == 0) {
			total = n / k;
		} else {
			total = (n / k) + 1;
			extraElement = n % k;
		}
		ListNode[] nodes = new ListNode[total];
		int extra = 0;
		for (int i = 0; i < total; i++) {
			ListNode currentNode = head;
			int num = 0;
			while (head != null) {
				num++;
//				if(num == k)
			}
		}
		return nodes;
	}

}
