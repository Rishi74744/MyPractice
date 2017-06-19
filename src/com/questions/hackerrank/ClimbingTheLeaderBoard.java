package com.questions.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClimbingTheLeaderBoard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] scores = new int[n];
		Map<Integer, Integer> m1 = new HashMap<>();
		int i = 1;
		for (int scores_i = 0; scores_i < n; scores_i++) {
			scores[scores_i] = in.nextInt();
			if (!m1.containsKey(scores[scores_i])) {
				m1.put(scores[scores_i], i);
				i++;
			}
		}
		int m = in.nextInt();
		int[] alice = new int[m];
		for (int alice_i = 0; alice_i < m; alice_i++) {
			alice[alice_i] = in.nextInt();
		}
	}

}
