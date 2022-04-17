package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1. Return true if you can finish all courses. Otherwise,
 * return false.
 * 
 * Example 1:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true
 * 
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible. Example 2:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false
 * 
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * Constraints:
 * 
 * 1 <= numCourses <= 10^5
 * 
 * 0 <= prerequisites.length <= 5000
 * 
 * prerequisites[i].length == 2
 * 
 * 0 <= ai, bi < numCourses
 * 
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {

	List<List<Integer>> adjMap = new ArrayList<>();
	boolean visited[];
	Set<Integer> st = new HashSet<>();

	/**
	 * Complexity - O(V+E). Space - O(V^2)
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			adjMap.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			adjMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		return topologicalSort(numCourses);
	}

	public boolean topologicalSort(int n) {
		for (int i = 0; i < n; i++) {
			if (!sort(i)) {
				return false;
			}
		}
		return true;
	}

	public boolean sort(int source) {
		visited[source] = true;
		st.add(source);
		for (int node : adjMap.get(source)) {
			if (!visited[node]) {
				if (!sort(node)) {
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
		CourseSchedule s = new CourseSchedule();
		int pre[][] = { { 1, 0 }, { 2, 1 } };
		System.out.println(s.canFinish(3, pre));
	}

}
