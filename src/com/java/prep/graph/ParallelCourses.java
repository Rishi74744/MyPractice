package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public int minimumSemesters(int n, int[][] relations) {
		boolean visited[] = new boolean[n];
		Set<Integer> st = new HashSet<>();
		List<List<Integer>> adjList = prepareAdjList(n, relations);
		topologicalSort(n, visited, adjList, st);
		return 0;
	}

	public List<List<Integer>> prepareAdjList(int n, int[][] relations) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < relations.length; i++) {
			adjList.get(relations[i][0] - 1).add(relations[i][1] - 1);
		}
		return adjList;
	}

	public boolean topologicalSort(int n, boolean visited[], List<List<Integer>> adjList, Set<Integer> st) {
		for (int i = 0; i < n; i++) {
			if (!sort(i, visited, adjList, st)) {
				return false;
			}
		}
		return true;
	}

	public boolean sort(int source, boolean visited[], List<List<Integer>> adjList, Set<Integer> st) {
		visited[source] = true;
		st.add(source);
		for (int node : adjList.get(source)) {
			if (!visited[node]) {
				if (!sort(node, visited, adjList, st)) {
					return false;
				}
			}
			if (visited[node] && st.contains(node)) {
				return false;
			}
		}
		st.remove(source);
		return true;
	}

	public static void main(String[] args) {

	}

}
