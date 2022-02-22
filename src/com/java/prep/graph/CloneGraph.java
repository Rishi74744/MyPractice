package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Map<Node, Node> visited = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		Node newNode = new Node(node.val);
		visited.put(node, newNode);
		List<Node> newNeighbors = new ArrayList<>();
		for (Node adjNodes : node.neighbors) {
			if (!visited.containsKey(adjNodes)) {
				Node newAdjNode = cloneGraph(adjNodes);
				visited.put(adjNodes, newAdjNode);
				newNeighbors.add(newAdjNode);
			} else {
				newNeighbors.add(visited.get(adjNodes));
			}
		}
		newNode.neighbors = newNeighbors;
		return newNode;
	}

}
