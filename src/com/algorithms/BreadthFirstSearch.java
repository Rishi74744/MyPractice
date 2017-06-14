package com.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

	public static Queue<Integer> queue = new PriorityQueue<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes in graph :");
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		System.out.println("Enter the graph matrix");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter the start node");
		int start = sc.nextInt();
		queue.add(start - 1);
		boolean isVisited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			isVisited[i] = false;
		}
		while (!queue.isEmpty()) {
			int pointer = queue.remove();
			System.out.println(pointer + 1);
			isVisited[pointer] = true;
			for (int i = 0; i < n; i++) {
				if (arr[pointer][i] == 1 && !isVisited[i] && !queue.contains(i)) {
					queue.add(i);
				}
			}
		}
	}

}
