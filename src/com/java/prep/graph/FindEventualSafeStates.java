package com.java.prep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i]
 * is an integer array of nodes adjacent to node i, meaning there is an edge
 * from node i to each node in graph[i].
 * 
 * A node is a terminal node if there are no outgoing edges. A node is a safe
 * node if every possible path starting from that node leads to a terminal node.
 * 
 * Return an array containing all the safe nodes of the graph. The answer should
 * be sorted in ascending order.
 * 
 * Example 1:
 * 
 * Illustration of graph
 * 
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]] Output: [2,4,5,6]
 * 
 * Explanation: The given graph is shown above. Nodes 5 and 6 are terminal nodes
 * as there are no outgoing edges from either of them. Every path starting at
 * nodes 2, 4, 5, and 6 all lead to either node 5 or 6. Example 2:
 * 
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]] Output: [4]
 * 
 * Explanation: Only node 4 is a terminal node, and every path starting at node
 * 4 leads to node 4.
 * 
 * 
 * Constraints:
 * 
 * n == graph.length
 * 
 * 1 <= n <= 10^4
 * 
 * 0 <= graph[i].length <= n
 * 
 * 0 <= graph[i][j] <= n - 1
 * 
 * graph[i] is sorted in a strictly increasing order.
 * 
 * The graph may contain self-loops.
 * 
 * The number of edges in the graph will be in the range [1, 4 * 10^4].
 */
public class FindEventualSafeStates {

	public boolean isTerminalNode(int node, int graph[][]) {
		return graph[node].length == 0;
	}

	public List<Integer> eventualSafeNodes(int[][] graph) {
		if (graph.length == 0) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[graph.length];
		for (int j = 0; j < graph.length; j++) {
			if (visited[j]) {
				continue;
			}
			q.offer(j);
			if (isTerminalNode(j, graph) && !result.contains(j)) {
				result.add(j);
			}
			int edgeNodes[] = graph[j];
			boolean isTerminated = true;
			for (int i = 0; i < edgeNodes.length; i++) {
				if (!isTerminalNode(edgeNodes[i], graph)) {
					isTerminated = false;
				}
			}
			if (isTerminated && !result.contains(j)) {
				result.add(j);
			}
			visited[j] = true;
		}
		return result;
	}

	public static void main(String[] args) {
		FindEventualSafeStates f = new FindEventualSafeStates();
		int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		int graph2[][] = { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {}, { 5 } };
		int graph3[][] = { {}, { 0, 2, 3, 4 }, { 3 }, { 4 }, {} };
		System.out.println(f.eventualSafeNodes(graph));
		System.out.println(f.eventualSafeNodes(graph2));
		System.out.println(f.eventualSafeNodes(graph3));
	}

}
