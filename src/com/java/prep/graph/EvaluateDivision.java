package com.java.prep.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * jth query where you must find the answer for Cj / Dj = ?.
 * 
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 * 
 * 
 * Example 1:
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 
 * Explanation:
 * 
 * Given: a / b = 2.0, b / c = 3.0
 * 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 
 * Example 2:
 * 
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * 
 * Example 3:
 * 
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 
 * Constraints:
 * 
 * 1 <= equations.length <= 20
 * 
 * equations[i].length == 2
 * 
 * 1 <= Ai.length, Bi.length <= 5
 * 
 * values.length == equations.length
 * 
 * 0.0 < values[i] <= 20.0
 * 
 * 1 <= queries.length <= 20
 * 
 * queries[i].length == 2
 * 
 * 1 <= Cj.length, Dj.length <= 5
 * 
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 */
public class EvaluateDivision {

	/**
	 * Time Complexity: O((N+Q)logA) N is the size of @equations Q is the size
	 * of @queries A is the number of distinct string in @equations
	 * 
	 * Space Complexity : O(n)
	 */
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int size = equations.size();
		UnionFind unionFind = new UnionFind(2 * size);
		Map<String, Integer> hashMap = new HashMap<>(2 * size);
		int id = 0;
		for (int i = 0; i < size; i++) {
			List<String> equation = equations.get(i);
			String var1 = equation.get(0);
			String var2 = equation.get(1);
			if (!hashMap.containsKey(var1)) {
				hashMap.put(var1, id);
				id++;
			}
			if (!hashMap.containsKey(var2)) {
				hashMap.put(var2, id);
				id++;
			}
			unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
		}

		int queriesSize = queries.size();
		double[] res = new double[queriesSize];
		for (int i = 0; i < queriesSize; i++) {
			String var1 = queries.get(i).get(0);
			String var2 = queries.get(i).get(1);

			Integer id1 = hashMap.get(var1);
			Integer id2 = hashMap.get(var2);

			if (id1 == null || id2 == null) {
				res[i] = -1.0d;
			} else {
				res[i] = unionFind.isConnected(id1, id2);
			}
		}
		return res;
	}
	
	private class UnionFind {
		private int[] parent;
		private double[] weight;

		public UnionFind(int size) {
			parent = new int[size];
			weight = new double[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
			Arrays.fill(weight, 1.0);
		}

		public void union(int x, int y, double value) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY) {
				return;
			}
			parent[rootX] = rootY;
			weight[rootX] = weight[y] * value / weight[x];
		}

		public int find(int x) {
			if (parent[x] != x) {
				int origin = parent[x];
                parent[x] = find(parent[x]);
				weight[x] = weight[x] * weight[origin];
			}
			return parent[x];
		}

		public double isConnected(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY) {
				return weight[x] / weight[y];
			} else {
				return -1.0d;
			}
		}

	}

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		List<String> e = new ArrayList<>();
		e.add("a");
		e.add("b");
		equations.add(e);
		List<String> e1 = new ArrayList<>();
		e1.add("b");
		e1.add("c");
		equations.add(e1);
		List<String> e2 = new ArrayList<>();
		e2.add("bc");
		e2.add("cd");
		equations.add(e2);
		List<List<String>> queries = new ArrayList<>();
		List<String> q = new ArrayList<>();
		q.add("a");
		q.add("c");
		queries.add(q);
		double values[] = { 1.5, 2.5, 5.0 };
		EvaluateDivision evaluateDivision = new EvaluateDivision();
		double res[] = evaluateDivision.calcEquation(equations, values, queries);
		for (double r : res) {
			System.out.println(r);
		}
	}

}
