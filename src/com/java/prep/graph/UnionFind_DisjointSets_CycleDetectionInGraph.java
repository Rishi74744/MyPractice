package com.java.prep.graph;

/**
 * A disjoint-set data structure is a data structure that keeps track of a set
 * of elements partitioned into a number of disjoint (non-overlapping) subsets.
 * A union-find algorithm is an algorithm that performs two useful operations on
 * such a data structure:
 * 
 * Find: Determine which subset a particular element is in. This can be used for
 * determining if two elements are in the same subset.
 * 
 * Union: Join two subsets into a single subset. Here first we have to check if
 * the two subsets belong to same set. If no, then we cannot perform union.
 * 
 * Union-Find Algorithm can be used to check whether an undirected graph
 * contains cycle or not. Note that we have discussed an algorithm to detect
 * cycle. This is another method based on Union-Find. This method assumes that
 * the graph doesn’t contain any self-loops.
 * 
 * We can keep track of the subsets in a 1D array, let’s call it parent[]. Let
 * us consider the following graph:
 * 
 * cycle-in-graph
 * 
 * For each edge, make subsets using both the vertices of the edge. If both the
 * vertices are in the same subset, a cycle is found.
 * 
 * Initially, all slots of parent array are initialized to -1 (means there is
 * only one item in every subset).
 * 
 * 0 1 2
 * 
 * -1 -1 -1
 * 
 * Now process all edges one by one.
 * 
 * Edge 0-1: Find the subsets in which vertices 0 and 1 are. Since they are in
 * different subsets, we take the union of them. For taking the union, either
 * make node 0 as parent of node 1 or vice-versa.
 * 
 * 0 1 2 <----- 1 is made parent of 0 (1 is now representative of subset {0, 1})
 * 1 -1 -1
 * 
 * Edge 1-2: 1 is in subset 1 and 2 is in subset 2. So, take union.
 * 
 * 0 1 2 <----- 2 is made parent of 1 (2 is now representative of subset {0, 1,
 * 2})
 * 
 * 1 2 -1
 * 
 * Edge 0-2: 0 is in subset 2 and 2 is also in subset 2. Hence, including this
 * edge forms a cycle. How subset of 0 is same as 2? 0->1->2 // 1 is parent of 0
 * and 2 is parent of 1
 */
public class UnionFind_DisjointSets_CycleDetectionInGraph {

	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all edges

	class Edge {
		int src, dest;
	};

	// Creates a graph with V vertices and E edges
	UnionFind_DisjointSets_CycleDetectionInGraph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// A utility function to find the subset of an element i
	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	// A utility function to do union of two subsets
	void Union(int parent[], int x, int y) {
		parent[x] = y;
	}

	// The main function to check whether a given graph
	// contains cycle or not
	boolean isCycle(UnionFind_DisjointSets_CycleDetectionInGraph graph) {
		// Allocate memory for creating V subsets
		int parent[] = new int[graph.V];

		// Initialize all subsets as single element sets
		for (int i = 0; i < graph.V; ++i)
			parent[i] = -1;

		// Iterate through all edges of graph, find subset of both
		// vertices of every edge, if both subsets are same, then
		// there is cycle in graph.
		for (int i = 0; i < graph.E; ++i) {
			int x = graph.find(parent, graph.edge[i].src);
			int y = graph.find(parent, graph.edge[i].dest);

			if (x == y)
				return true;

			graph.Union(parent, x, y);
		}
		return false;
	}

	/**
	 * Note that the implementation of union() and find() is naive and takes O(n)
	 * time in the worst case. These methods can be improved to O(Logn) using Union
	 * by Rank or Height.
	 */
	public static void main(String[] args) {
		/*
		 * Let us create the following graph 0 | \ | \ 1---2
		 */
		int V = 4, E = 3;
		UnionFind_DisjointSets_CycleDetectionInGraph graph = new UnionFind_DisjointSets_CycleDetectionInGraph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 3;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph))
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}

}
