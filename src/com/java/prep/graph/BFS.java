package com.java.prep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	int vertices;
	List<List<Integer>> adjacencyList = new ArrayList<>();

	public BFS(int vertices) {
		this.vertices = vertices;
		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new LinkedList<>());
		}
	}

	void addEdge(int from, int to) {
		adjacencyList.get(from).add(to);
	}

	void bfs(int source) {
		boolean isVisited[] = new boolean[vertices];
		Queue<Integer> q = new LinkedList<>();
		isVisited[source] = true;
		q.add(source);
		while (!q.isEmpty()) {
			int currentSource = q.poll();
			System.out.print(currentSource + " ");
			for (int next : adjacencyList.get(currentSource)) {
				if (!isVisited[next]) {
					isVisited[next] = true;
					q.add(next);
				}
			}
		}
	}

	// Time Complexity: O(V+E) where V is a number of vertices in the graph and E is
	// a number of edges in the graph.

	public static void main(String[] args) {
		BFS g = new BFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.bfs(1);
	}

}
