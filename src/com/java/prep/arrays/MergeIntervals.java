package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 
 * Output: [[1,6],[8,10],[15,18]]
 * 
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]]
 * 
 * Output: [[1,5]]
 * 
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 10^4
 * 
 * intervals[i].length == 2
 * 
 * 0 <= starti <= endi <= 104
 *
 */
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (int[] o1, int[] o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(end, intervals[i][1]);
			} else {
				int pair[] = { start, end };
				res.add(pair);
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		int pair[] = { start, end };
		res.add(pair);
		int result[][] = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		int intervals[][] = { { 1, 4 }, { 2, 3 } };
		int result[][] = m.merge(intervals);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
	}

}
