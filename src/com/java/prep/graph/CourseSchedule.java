package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

	List<List<Integer>> adjMap = new ArrayList<>();
	boolean visited[];
	Set<Integer> st = new HashSet<>();

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
