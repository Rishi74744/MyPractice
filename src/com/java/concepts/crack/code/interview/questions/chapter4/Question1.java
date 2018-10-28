package com.java.concepts.crack.code.interview.questions.chapter4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1 {

	static Queue<Integer> queue = new LinkedList<>();

	static boolean findIfPathExists(int graph[][], int source, int destination) {
		boolean isPathExists = false;
		queue.add(source);
		while (!queue.isEmpty()) {
			if (isPathExists) {
				break;
			}
			int currentNode = queue.poll();
			for (int i = 0; i < graph.length; i++) {
				if (graph[currentNode - 1][i] == 1 && !queue.contains(i + 1)) {
					if (i + 1 == destination) {
						isPathExists = true;
						break;
					} else {
						queue.add(i + 1);
					}
				}
			}
		}
		return isPathExists;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int numOfNodes = scanner.nextInt();
		int[][] graph = new int[numOfNodes][numOfNodes];
		for (int i = 0; i < numOfNodes; i++) {
			for (int j = 0; j < numOfNodes; j++) {
				graph[i][j] = scanner.nextInt();
			}
		}
		int source = scanner.nextInt();
		int destination = scanner.nextInt();
		System.out.println("Is Path Exists Between " + source + " and " + destination + " : "
				+ findIfPathExists(graph, source, destination));
	}

}
/**
 * Question : 1 ---> Route Between Nodes: Given a directed graph, design an
 * algorithm to find out whether there is a route between two nodes.
 */