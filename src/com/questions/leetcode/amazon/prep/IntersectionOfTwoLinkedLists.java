package com.questions.leetcode.amazon.prep;

public class IntersectionOfTwoLinkedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null && headB == null) {
			return null;
		}
		if (headA == null || headB == null) {
			return null;
		}

		int count1 = 1;
		int count2 = 1;

		ListNode nextA = headA.next;
		ListNode nextB = headB.next;

		while (nextA != null) {
			count1++;
			nextA = nextA.next;
		}

		while (nextB != null) {
			count2++;
			nextB = nextB.next;
		}

		if (count1 < count2) {
			while (count1 != count2) {
				headB = headB.next;
				count2--;
			}
		}
		if (count1 > count2) {
			while (count1 != count2) {
				headA = headA.next;
				count1--;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

}
