package com.questions.leetcode.medium;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode currentHead = head;
		ListNode nextNode = head.next;
		ListNode nextToNextNode = head.next.next;
		nextNode.next = currentHead;
		currentHead.next = nextToNextNode;
		currentHead.next = swapPairs(nextToNextNode);
		return nextNode;
	}
}
