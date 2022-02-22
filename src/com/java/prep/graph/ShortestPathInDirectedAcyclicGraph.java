package com.java.prep.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {

	static final int INF = Integer.MAX_VALUE;

	static class AdjListNode {
		private int v;
		private int weight;

		AdjListNode(int v, int w) {
			this.v = v;
			this.weight = w;
		}

		int getV() {
			return v;
		}

		int getWeight() {
			return weight;
		}
	}

	int v;
	List<List<AdjListNode>> adjNode = new ArrayList<>();
	boolean visited[];
	Stack<Integer> stack = new Stack<>();

	ShortestPathInDirectedAcyclicGraph(int v) {
		this.v = v;
		visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			adjNode.add(new ArrayList<>());
		}
	}

	void addEdge(int from, int to, int weight) {
		adjNode.get(from).add(new AdjListNode(to, weight));
	}

	void topologicalSort() {
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				sort(i);
			}
		}
	}

	void sort(int source) {
		visited[source] = true;
		for (AdjListNode node : adjNode.get(source)) {
			if (!visited[node.getV()]) {
				sort(node.getV());
			}
		}
		stack.add(source);
	}

	void findShortestPath(int source) {
		topologicalSort();
		int distances[] = new int[this.v];
		for (int i = 0; i < this.v; i++) {
			distances[i] = INF;
		}
		distances[source] = 0;
		while (!stack.isEmpty()) {
			int current = stack.pop();
			if (distances[current] != INF) {
				for (AdjListNode node : adjNode.get(current)) {
					if (distances[node.getV()] > distances[current] + node.getWeight()) {
						distances[node.getV()] = distances[current] + node.getWeight();
					}
				}
			}
		}

		for (int i = 0; i < v; i++) {
			if (distances[i] == INF)
				System.out.print("INF ");
			else
				System.out.print(distances[i] + " ");
		}
	}

	public static void main(String[] args) {
		ShortestPathInDirectedAcyclicGraph g = new ShortestPathInDirectedAcyclicGraph(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		g.findShortestPath(1);
	}

	/**
	 * Time complexity of topological sorting is O(V+E). After finding topological
	 * order, the algorithm process all vertices and for every vertex, it runs a
	 * loop for all adjacent vertices. Total adjacent vertices in a graph is O(E).
	 * So the inner loop runs O(V+E) times. Therefore, overall time complexity of
	 * this algorithm is O(V+E).
	 */

}
