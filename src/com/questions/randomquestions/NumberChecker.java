package com.questions.randomquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberChecker {

	public static void main(String[] args) {
		int[] i = { 1243325, 124, 52351, 1245 };
		List<Integer> l = new ArrayList<>();
		for (int j : i) {
			String k = Integer.toString(j);
			if (k.contains("1") && k.contains("2") && k.contains("3")) {
				l.add(j);
			}
		}
		Collections.sort(l);
		System.out.println(l.toString().replace("[", "").replace("]", "").replace(" ", ""));
	}

}
