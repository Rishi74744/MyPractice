package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are some spherical balloons taped onto a flat wall that represents the
 * XY-plane. The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter
 * stretches between xstart and xend. You do not know the exact y-coordinates of
 * the balloons.
 * 
 * Arrows can be shot up directly vertically (in the positive y-direction) from
 * different points along the x-axis. A balloon with xstart and xend is burst by
 * an arrow shot at x if xstart <= x <= xend. There is no limit to the number of
 * arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting
 * any balloons in its path.
 * 
 * Given the array points, return the minimum number of arrows that must be shot
 * to burst all balloons.
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[10,16],[2,8],[1,6],[7,12]] Output: 2
 * 
 * Explanation: The balloons can be burst by 2 arrows: - Shoot an arrow at x =
 * 6, bursting the balloons [2,8] and [1,6]. - Shoot an arrow at x = 11,
 * bursting the balloons [10,16] and [7,12].
 * 
 * Example 2:
 * 
 * Input: points = [[1,2],[3,4],[5,6],[7,8]] Output: 4
 * 
 * Explanation: One arrow needs to be shot for each balloon for a total of 4
 * arrows.
 * 
 * Example 3:
 * 
 * Input: points = [[1,2],[2,3],[3,4],[4,5]] Output: 2 Explanation: The balloons
 * can be burst by 2 arrows: - Shoot an arrow at x = 2, bursting the balloons
 * [1,2] and [2,3]. - Shoot an arrow at x = 4, bursting the balloons [3,4] and
 * [4,5].
 * 
 * 
 * Constraints:
 * 
 * 1 <= points.length <= 10^5
 * 
 * points[i].length == 2
 * 
 * -2^31 <= xstart < xend <= 2^31 - 1
 */
public class MinimumNumberOfArrowsToBurstBalloons {

	/**
	 * Complexity - O(nlogn) + O(n) => O(nlogn). Space - O(n).
	 */
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (int[] o1, int[] o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		int start = points[0][0];
		int end = points[0][1];
		List<int[]> res = new ArrayList<>();
		for (int i = 1; i < points.length; i++) {
			if ((start >= points[i][0] && start <= points[i][1]) || (end >= points[i][0] && end <= points[i][1])
					|| (points[i][0] >= start && points[i][0] <= end)
					|| (points[i][1] >= start && points[i][1] <= end)) {
				start = Math.min(start, points[i][0]);
				end = Math.min(end, points[i][1]);
			} else {
				int pair[] = { start, end };
				res.add(pair);
				start = points[i][0];
				end = points[i][1];
			}
		}
		int pair[] = { start, end };
		res.add(pair);
		return res.size();
	}

	public static void main(String[] args) {
//		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		int[][] points = { { 10, 16 }, { 2, 7 }, { 1, 8 }, { 9, 12 } };
//		int[][] points = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
//		int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
//		int[][] points = { { 1, 2 }, { 4, 5 }, { 1, 5 } }; 
//		int[][] points = { { -1, 1 }, { 0, 1 }, { 2, 3 }, { 1, 2 } };
		MinimumNumberOfArrowsToBurstBalloons m = new MinimumNumberOfArrowsToBurstBalloons();
		System.out.println(m.findMinArrowShots(points));
	}

}
