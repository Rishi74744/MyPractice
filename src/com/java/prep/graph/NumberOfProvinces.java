package com.java.prep.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * Example 1:
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]] Output: 2
 * 
 * Example 2:
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]] Output: 3
 * 
 * Constraints:
 * 
 * 1 <= n <= 200
 * 
 * n == isConnected.length
 * 
 * n == isConnected[i].length
 * 
 * isConnected[i][j] is 1 or 0.
 * 
 * isConnected[i][i] == 1
 * 
 * isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvinces {

	/**
	 * Complexity - O(N^2), Space - O(N)
	 */
	public int findCircleNum(int[][] isConnected) {
		Set<Integer> visited = new HashSet<>();
		int count = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited.contains(i)) {
				dfs(i, visited, isConnected);
				count++;
			}
		}
		return count;
	}

	void dfs(int currentNode, Set<Integer> visited, int[][] isConnected) {
		if (visited.contains(currentNode)) {
			return;
		}
		visited.add(currentNode);
		for (int i = 0; i < isConnected.length; i++) {
			if (isConnected[currentNode][i] == 1) {
				dfs(i, visited, isConnected);
			}
		}
	}

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		NumberOfProvinces n = new NumberOfProvinces();
		System.out.println(n.findCircleNum(isConnected));
	}

}
