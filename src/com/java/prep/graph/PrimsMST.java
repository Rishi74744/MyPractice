package com.java.prep.graph;

public class PrimsMST {

	int v;

	PrimsMST(int v) {
		this.v = v;
	}

	void primsMst(int graph[][]) {
		int mst[] = new int[v];
		int vertex[] = new int[v];
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			vertex[i] = Integer.MAX_VALUE;
		}
		vertex[0] = 0; // 0 node is picked first
		mst[0] = -1; // first node is always root of MST
		for (int i = 0; i < v - 1; i++) {
			int u = minKey(vertex, visited);
			visited[u] = true;
			for (int j = 0; j < v; j++) {
				if (graph[u][j] != 0 && !visited[j] && graph[u][j] < vertex[j]) {
					mst[j] = u;
					vertex[j] = graph[u][j];
				}
			}
		}
		printMST(mst, graph);
	}

	void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < v; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	private int minKey(int[] vertex, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < v; i++) {
			if (!visited[i] && vertex[i] < min) {
				min = vertex[i];
				minIdx = i;

			}
		}
		return minIdx;
	}

	public static void main(String[] args) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5 |7 | / \
		 * | (3)-------(4) 9
		 */
		PrimsMST t = new PrimsMST(5);
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		// Print the solution
		t.primsMst(graph);
	}

	/**
	 * Time Complexity of the above program is O(V^2). If the input graph is
	 * represented using adjacency list, then the time complexity of Prim’s
	 * algorithm can be reduced to O(E log V) with the help of binary heap.
	 */
}
