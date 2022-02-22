package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascals = new ArrayList<>();
		List<Integer> prevList = Arrays.asList(1);
		pascals.add(prevList);
		if (numRows == 1) {
			return pascals;
		}
		for (int i = 1; i < numRows; i++) {
			List<Integer> currentList = new ArrayList<>();
			currentList.add(1);
			for (int j = 1; j <= (i - 1); j++) {
				currentList.add(prevList.get(j - 1) + prevList.get(j));
			}
			currentList.add(1);
			pascals.add(currentList);
			prevList = currentList;
		}
		return pascals;
	}

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

}
