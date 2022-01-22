package com.questions.leetcode.dp.course1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day12PascalsTriangleII {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> prevList = Arrays.asList(1);
		if (rowIndex == 0) {
			return prevList;
		}
		for (int i = 1; i < rowIndex + 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					prevList.add(1);
				} else {
					int sum = prevList.get(j - 1) + prevList.get(j);
					prevList.add(sum, j);
				}
			}
		}
		return prevList;
	}

	public static void main(String[] args) {
		System.out.println(getRow(2));
	}

}
