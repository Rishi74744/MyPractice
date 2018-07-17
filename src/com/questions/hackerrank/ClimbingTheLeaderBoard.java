package com.questions.hackerrank;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ClimbingTheLeaderBoard {

	static int[] climbingLeaderboard(int[] scores, int[] alice, Stack<Integer> stack1, Map<Integer, Integer> scoreMap,
			int maxRank) {
		int[] aliceRanks = new int[alice.length];
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 0; i < alice.length; i++) {
			int curr = stack1.pop();
			if (curr > alice[i]) {
				aliceRanks[i] = maxRank + 1;
			} else if (curr < alice[i]) {

			} else {

			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, Integer> scoreMap = new LinkedHashMap<>();
		Stack<Integer> stack1 = new Stack<>();
		int[] scores = new int[n];
		for (int scores_i = 0; scores_i < n; scores_i++) {
			scores[scores_i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] alice = new int[m];
		int k = 1;
		for (int alice_i = 0; alice_i < m; alice_i++) {
			alice[alice_i] = in.nextInt();
			stack1.push(alice[alice_i]);
			if (!scoreMap.containsKey(alice[alice_i])) {
				scoreMap.put(alice[alice_i], k);
				k++;
			}
		}
		int[] result = climbingLeaderboard(scores, alice, stack1, scoreMap, k);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

		in.close();
	}

}
