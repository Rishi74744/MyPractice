package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(1);
		if (n == 1) {
			return result;
		}
		int index = 1;
		int total = (int) Math.pow(2, n);
		while (result.size() < total) {
			if (index % 2 == 1) {
				result.add(2 * result.get(index) + 1);
				result.add(2 * result.get(index));
			} else {
				result.add(2 * result.get(index));
				result.add(2 * result.get(index) + 1);
			}
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(grayCode(4));
	}

}
