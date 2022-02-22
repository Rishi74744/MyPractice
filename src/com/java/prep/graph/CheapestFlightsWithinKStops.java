package com.java.prep.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		for (int[] flight : flights) {
			map.computeIfAbsent(flight[0], x -> new ArrayList<int[]>()).add(new int[] { flight[1], flight[2] });
		}
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { src, 0 });
		int[] minDist = new int[n];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		int count = -1;
		while (!q.isEmpty()) {
			if (count == k) {
				break;
			}
			for (int i = q.size() - 1; i >= 0; i--) {
				int[] currentNode = q.poll();
				int node = currentNode[0];
				int weight = currentNode[1];
				if (map.containsKey(node)) {
					for (int[] edges : map.get(node)) {
						int edgeNode = edges[0];
						int w = weight + edges[1];
						if (w < minDist[edgeNode]) {
							minDist[edgeNode] = w;
							q.add(new int[] { edgeNode, w });
						}
					}
				}
			}
			count++;
		}
		return minDist[dst] != Integer.MAX_VALUE ? minDist[dst] : -1;
	}

	public static void main(String[] args) {
		CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
		int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		System.out.println(c.findCheapestPrice(3, flights, 0, 2, 0));
	}

}
