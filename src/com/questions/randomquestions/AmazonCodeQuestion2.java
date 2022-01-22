package com.questions.randomquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AmazonCodeQuestion2 {

	static List<Integer> findValidDiscountCoupons(List<String> discounts) {
		List<Integer> result = new ArrayList<>();
		for (String coupon : discounts) {
			result.add(isValid(coupon) ? 1 : 0);
		}
		return result;
	}

	static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		for (char c : s.toCharArray()) {
			if (st.isEmpty()) {
				st.push(c);
			} else if (st.peek() == c) {
				st.pop();
			} else {
				st.push(c);
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		List<String> coupons = new ArrayList<>();
		coupons.add("abba");
		coupons.add("abca");
		System.out.println(findValidDiscountCoupons(coupons));

		boolean aa = false;
		aa ^= true;
		System.out.println(aa);
	}

}
