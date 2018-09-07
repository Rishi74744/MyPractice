package com.java.concepts.crack.code.interview.questions.chapter4;

public class CheckSubTree {

	static boolean isIdentical = false;

	static void isIdentical(Node t1, Node t2) {
		if (t1 == null) {
			if (t2 == null) {
				isIdentical = true;
			}
			return;
		}
		if (t1 == t2) {
			isIdentical = true;
			return;
		}
		if (t1.left != null) {
			if (t1.left == t2) {
				isIdentical = true;
				return;
			} else {
				isIdentical(t1.left, t2);
			}
		}
		if (t1.right != null) {
			if (t1.right == t2) {
				isIdentical = true;
				return;
			} else {
				isIdentical(t1.right, t2);
			}
		}
	}

	public static void main(String[] args) {

	}

}