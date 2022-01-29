package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

	public static int calPoints(String[] ops) {
		List<Integer> s = new ArrayList<>();
		for (int i = 0; i < ops.length; i++) {
			if ("C".equals(ops[i])) {
				s.remove(s.size() - 1);
			} else if ("D".equals(ops[i])) {
				int last = s.get(s.size() - 1);
				last *= 2;
				s.add(last);
			} else if ("+".equals(ops[i])) {
				int l1 = s.get(s.size() - 1);
				int l2 = s.get(s.size() - 2);
				int sum = l1 + l2;
				s.add(sum);
			} else {
				s.add(Integer.parseInt(ops[i]));
			}
		}
		int total = 0;
		for (int i : s) {
			total += i;
		}
		return total;
	}

	public static void main(String[] args) {
		String[] ops = { "1" };
		System.out.println(calPoints(ops));
	}

}
