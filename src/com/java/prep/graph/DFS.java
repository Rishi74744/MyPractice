package com.java.prep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS {

	int vertices;
	List<List<Integer>> adjacencyList = new ArrayList<>();
	boolean visited[];

	public DFS(int vertices) {
		this.vertices = vertices;
		visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new LinkedList<>());
		}
	}

	void addEdge(int from, int to) {
		adjacencyList.get(from).add(to);
	}

	void dfs(int source) {
		visited[source] = true;
		System.out.print(source + " ");
		for (int next : adjacencyList.get(source)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	// Time complexity: O(V + E), where V is the number of vertices and E is the
	// number of edges in the graph.
	// Space Complexity: O(V), since an extra visited array of size V is required.

	public static void main(String[] args) {
		DFS g = new DFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.dfs(3);
	}

}
