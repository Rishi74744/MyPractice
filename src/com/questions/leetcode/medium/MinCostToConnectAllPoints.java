package com.questions.leetcode.medium;

import java.util.Arrays;

public class MinCostToConnectAllPoints {

	public static int minCostConnectPoints(int[][] points) {
		int minDistance = 0;
		int currentPoint = 0;
		int count = 0;
		int visited[] = new int[points.length];
		if (points.length == 1) {
			return 0;
		}
		if (points.length == 2) {
			return Math.abs(points[0][0] - points[1][0]) + Math.abs(points[0][1] - points[1][1]);
		}
		Arrays.fill(visited, 0);
		while (count < (points.length - 2)) {
			int min = Integer.MAX_VALUE;
			int minPoint = -1;
			for (int i = 1; i < points.length; i++) {
				if (visited[i] == 1 || currentPoint == i) {
					continue;
				}
				int distance = Math.abs(points[currentPoint][0] - points[i][0])
						+ Math.abs(points[currentPoint][1] - points[i][1]);
				if (distance < min) {
					min = distance;
					minPoint = i;
				}
			}
			visited[currentPoint] = 1;
			currentPoint = minPoint;
			minDistance += min;
			count++;
		}
		visited[currentPoint] = 1;
		int notVisited = -1;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				notVisited = i;
				break;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < points.length; i++) {
			if (i != notVisited) {
				int distance = Math.abs(points[notVisited][0] - points[i][0])
						+ Math.abs(points[notVisited][1] - points[i][1]);
				if (distance < min) {
					min = distance;
				}
			}
		}
		minDistance += min;
		return minDistance;
	}

	public static void main(String[] args) {
		int points[][] = { { -1000000, -1000000 }, { 1000000, 1000000 } };
		System.out.println(minCostConnectPoints(points));
	}
}
