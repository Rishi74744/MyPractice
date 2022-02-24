package com.java.prep.arrays;

/**
 * You are given a list of songs where the ith song has a duration of time[i]
 * seconds.
 * 
 * Return the number of pairs of songs for which their total duration in seconds
 * is divisible by 60. Formally, we want the number of indices i, j such that i
 * < j with (time[i] + time[j]) % 60 == 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: time = [30,20,150,100,40] Output: 3
 * 
 * Explanation: Three pairs have a total duration divisible by 60: (time[0] =
 * 30, time[2] = 150): total duration 180 (time[1] = 20, time[3] = 100): total
 * duration 120 (time[1] = 20, time[4] = 40): total duration 60
 * 
 * Example 2:
 * 
 * Input: time = [60,60,60] Output: 3
 * 
 * Explanation: All three pairs have a total duration of 120, which is divisible
 * by 60.
 * 
 * 
 * Constraints:
 * 
 * 1 <= time.length <= 6 * 104 1 <= time[i] <= 500
 *
 */

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	/**
	 * Complexity - O(n^2), Space - O(1)
	 */
	public int numPairsDivisibleBy60Slow(int[] time) {
		int totalPairs = 0;
		for (int i = 0; i < time.length - 1; i++) {
			for (int j = i + 1; j < time.length; j++) {
				int timeSum = time[i] + time[j];
				if (timeSum % 60 == 0) {
					totalPairs++;
				}
			}
		}
		return totalPairs;
	}

	/**
	 * Complexity - O(n) where n is total number of songs.
	 * 
	 * Space - O(60) ~ O(1) - For storing time modulo.
	 */
	public int numPairsDivisibleBy60(int[] time) {
		int songs[] = new int[60];
		int totalPairs = 0;
		for (int i = 0; i < time.length; i++) {
			int rem = time[i] % 60;
			if (rem == 0) {
				totalPairs += songs[rem];
			} else {
				totalPairs += songs[60 - rem];
			}
			songs[rem]++;
		}
		return totalPairs;
	}

	public static void main(String[] args) {
		PairsOfSongsWithTotalDurationsDivisibleBy60 p = new PairsOfSongsWithTotalDurationsDivisibleBy60();
		int time[] = { 30, 20, 150, 100, 40 };
		System.out.println(p.numPairsDivisibleBy60(time));
	}

}
