package com.java.prep.graph;

import java.util.Arrays;

/**
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * You are given a graph that started as a tree with n nodes labeled from 1 to
 * n, with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi] indicates
 * that there is an edge between nodes ai and bi in the graph.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of n
 * nodes. If there are multiple answers, return the answer that occurs last in
 * the input.
 * 
 * Example 1:
 * 
 * Input: edges = [[1,2],[1,3],[2,3]] Output: [2,3]
 * 
 * Example 2:
 * 
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]] Output: [1,4]
 * 
 * 
 * Constraints:
 * 
 * n == edges.length
 * 
 * 3 <= n <= 1000
 * 
 * edges[i].length == 2
 * 
 * 1 <= ai < bi <= edges.
 * 
 * length ai != bi There are no repeated edges.
 * 
 * The given graph is connected.
 */
public class RedundantConnection {

	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void union(int parent[], int x, int y) {
		parent[x] = y;
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int result[] = new int[2];
		if (n <= 2) {
			return result;
		}
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		for (int i = 0; i < n; ++i) {
			int x = find(parent, edges[i][0] - 1);
			int y = find(parent, edges[i][1] - 1);

			if (x == y) {
				result = edges[i];
				break;
			}
			union(parent, x, y);
		}
		return result;
	}

	public static void main(String[] args) {
		RedundantConnection r = new RedundantConnection();
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		int result[] = r.findRedundantConnection(edges);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
