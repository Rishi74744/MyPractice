package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one
 * of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 
 * The town judge trusts nobody.
 * 
 * Everybody (except for the town judge) trusts the town judge.
 * 
 * There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given an array trust where trust[i] = [ai, bi] representing that the
 * person labeled ai trusts the person labeled bi.
 * 
 * Return the label of the town judge if the town judge exists and can be
 * identified, or return -1 otherwise.
 * 
 * Example 1: Input: n = 2, trust = [[1,2]] Output: 2
 * 
 * Example 2: Input: n = 3, trust = [[1,3],[2,3]] Output: 3
 * 
 * Example 3: Input: n = 3, trust = [[1,3],[2,3],[3,1]] Output: -1
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 * 
 * 0 <= trust.length <= 10^4
 * 
 * trust[i].length == 2
 * 
 * All the pairs of trust are unique.
 * 
 * ai != bi 1 <= ai, bi <= n
 */
public class FindTheTownJudge {

	/**
	 * Complexity - O(n), Space - O(n^2)
	 */
	public int findJudge(int n, int[][] trust) {
		Map<Integer, List<Integer>> trustMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			trustMap.put(i, new ArrayList<>());
		}
		for (int i = 0; i < trust.length; i++) {
			List<Integer> trusted = trustMap.getOrDefault(trust[i][0], new ArrayList<>());
			trusted.add(trust[i][1]);
			trustMap.put(trust[i][0], trusted);
		}
		int judge = -1;
		for (int key : trustMap.keySet()) {
			if (trustMap.get(key).isEmpty()) {
				judge = key;
				break;
			}
		}
		int trustees = 0;
		for (int key : trustMap.keySet()) {
			if (key != judge && trustMap.get(key).contains(judge)) {
				trustees++;
			}
		}
		return trustees == n - 1 ? judge : -1;
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public int findJudge2(int n, int[][] trust) {
		int trustees[] = new int[n + 1];
		boolean isTrusting[] = new boolean[n + 1];
		for (int i = 0; i < trust.length; i++) {
			trustees[trust[i][1]]++;
			isTrusting[trust[i][0]] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (!isTrusting[i] && trustees[i] == n - 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindTheTownJudge f = new FindTheTownJudge();
		int trust[][] = { { 1, 2 } };
		System.out.println(f.findJudge2(2, trust));
	}

}
