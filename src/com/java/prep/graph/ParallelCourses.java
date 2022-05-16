package com.java.prep.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There are N courses, labelled from 1 to N.
 * 
 * We are given relations[i] = [X, Y], representing a prerequisite relationship
 * between course X and course Y: course X has to be studied before course Y.
 * 
 * In one semester you can study any number of courses as long as you have
 * studied all the prerequisites for the course you are studying.
 * 
 * Return the minimum number of semesters needed to study all courses. If there
 * is no way to study all the courses, return -1.
 * 
 * Example 1: Input: N = 3, relations = [[1,3],[2,3]] Output: 2
 * 
 * Explanation: In the first semester, courses 1 and 2 are studied. In the
 * second semester, course 3 is studied.
 * 
 * Example 2: Input: N = 3, relations = [[1,2],[2,3],[3,1]] Output: -1
 * 
 * Explanation: No course can be studied because they depend on each other.
 * 
 * Constraints:
 * 
 * 1 <= N <= 5000
 * 
 * 1 <= relations.length <= 5000
 * 
 * relations[i][0] != relations[i][1]
 * 
 * There are no repeated relations in the input.
 */
public class ParallelCourses {

	/*
	 * Using Topology - Complexity - O(V + E), Space - O(V + E)
	 */
	public int minimumSemesters(int n, int[][] relations) {
		int result = 0;
		int[] preRequisites = new int[n];
		List<List<Integer>> adjList = prepareAdjList(n, preRequisites, relations);
		Queue<Integer> queue = IntStream.range(0, n).filter(index -> preRequisites[index] == 0).boxed()
				.collect(Collectors.toCollection(ArrayDeque::new));
		int count = 0;
		while (!queue.isEmpty()) {
			for (int index = queue.size(); index > 0; --index) {
				int src = queue.poll();
				count++;
				for(int dest: adjList.get(src)) {
					if(--preRequisites[dest] == 0) {
						queue.offer(dest);
					}
				}
			}
			result++;
		}
		return count == n ? result : -1;
	}

	public List<List<Integer>> prepareAdjList(int n, int[] preRequisites, int[][] relations) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < relations.length; i++) {
			adjList.get(relations[i][0] - 1).add(relations[i][1] - 1);
			++preRequisites[relations[i][1] - 1];
		}
		return adjList;
	}


	public static void main(String[] args) {
		ParallelCourses p = new ParallelCourses();
		int rel[][] = { { 1, 3 }, { 2, 3 } };
		int l = p.minimumSemesters(3, rel);
		System.out.println(l);
	}

}
