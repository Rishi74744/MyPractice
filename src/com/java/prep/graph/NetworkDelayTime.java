package com.java.prep.graph;

import java.util.Arrays;

/*
 * 
 * 
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * 
We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2

Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1

Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2

Output: -1
 

Constraints:

1 <= k <= n <= 100

1 <= times.length <= 6000

times[i].length == 3

1 <= ui, vi <= n

ui != vi

0 <= wi <= 100

All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 */
public class NetworkDelayTime {

	public int networkDelayTime(int[][] times, int n, int k) {
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		for (int[] arr : times)
			graph[arr[0] - 1][arr[1] - 1] = arr[2];
		return dijkstra(graph, k, n);

	}

	public int dijkstra(int[][] graph, int k, int n) {
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[k - 1] = 0;

		for (int i = 0; i < n; i++) {
			int u = minDistance(dist, visited, n);
			if (u == -1)
				continue;
			visited[u] = true;

			for (int v = 0; v < n; v++) {

				if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}

			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(dist[i], max);
		}

		return (max == Integer.MAX_VALUE) ? -1 : max;

	}

	public int minDistance(int[] dist, boolean[] visited, int n) {

		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < n; v++) {
			if (visited[v] == false && dist[v] < min) {
				min = dist[v];
				min_index = v;
			}
		}

		return min_index;
	}

}
