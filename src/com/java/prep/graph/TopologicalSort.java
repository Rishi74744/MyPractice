package com.java.prep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	int vertices;
	List<List<Integer>> adjacencyList = new ArrayList<>();
	Stack<Integer> stack = new Stack<Integer>();
	boolean visited[];

	public TopologicalSort(int vertices) {
		this.vertices = vertices;
		visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new LinkedList<>());
		}
	}

	void addEdge(int from, int to) {
		adjacencyList.get(from).add(to);
	}

	void topologicalSort() {
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				sortHelper(i);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	void sortHelper(int source) {
		visited[source] = true;
		for (int next : adjacencyList.get(source)) {
			if (!visited[next]) {
				sortHelper(next);
			}
		}
		stack.push(source);
	}

	// Time Complexity: O(V+E).
	// The above algorithm is simply DFS with an extra stack. So time complexity is
	// the same as DFS which is.
	// Auxiliary space: O(V).
	// The extra space is needed for the stack.

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		g.topologicalSort();
	}

}
