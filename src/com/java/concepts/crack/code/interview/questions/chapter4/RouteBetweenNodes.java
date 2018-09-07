package com.java.concepts.crack.code.interview.questions.chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenNodes {

	boolean isPathExists(Graph start, Graph end) {
		Queue<Graph> queue = new LinkedList<>();
		List<Graph> adjacentNodes = start.adjacentNodes;
		queue.addAll(adjacentNodes);
		while (!queue.isEmpty()) {
			Graph currentNode = queue.remove();
			if (currentNode == end) {
				return true;
			} else {
				if (currentNode.adjacentNodes != null && !currentNode.adjacentNodes.isEmpty()) {
					queue.addAll(currentNode.adjacentNodes);
				}
			}
		}
		return false;
	}

}

class Graph {
	int data;
	List<Graph> adjacentNodes;
}