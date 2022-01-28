package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		if (rowIndex == 0) {
			return result;
		}
		result.add(1);
		for (int i = 2; i <= rowIndex; i++) {
			Integer[] currentRow = new Integer[i + 1];
			currentRow[0] = 1;
			for (int j = 1; j <= (i + 1) / 2; j++) {
				int value = result.get(j) + result.get(j - 1);
				currentRow[j] = value;
				currentRow[i - j] = value;
			}
			currentRow[i] = 1;
			result = Arrays.<Integer>asList(currentRow);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getRow(10));
	}

}
