package com.questions.randomquestions;

public class ReverseLinkedList {

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

	public static ListNode reverse(ListNode root) {
		ListNode p = null;
		ListNode q = null;
		ListNode r = root;
		while (r != null) {
			p = q;
			q = r;
			r = r.next;
			q.next = p;
		}
		return q;
	}

	public static void main(String[] args) {
		ListNode head1 = null;
		int num1[] = { 7, 2, 4, 3 };
		ListNode prevNode1 = head1;
		for (int i = 0; i < num1.length; i++) {
			if (i == 0) {
				head1 = new ListNode(num1[i]);
				prevNode1 = head1;
			} else {
				ListNode nextNode = new ListNode(num1[i]);
				prevNode1.next = nextNode;
				prevNode1 = nextNode;
			}

		}

		ListNode rev = reverse(head1);
		while (rev != null) {
			System.out.print(rev.val);
			rev = rev.next;
		}
	}

}
