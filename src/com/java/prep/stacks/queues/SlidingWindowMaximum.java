package com.java.prep.stacks.queues;

import java.util.ArrayDeque;

/**
 * 
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 
 * Output: [3,3,5,5,6,7]
 * 
 * Explanation:
 * 
 * Window position Max
 * 
 * ------------------- -----
 * 
 * [1 3 -1] -3 5 3 6 7 3
 * 
 * 1 [3 -1 -3] 5 3 6 7 3
 * 
 * 1 3 [-1 -3 5] 3 6 7 5
 * 
 * 1 3 -1 [-3 5 3] 6 7 5
 * 
 * 1 3 -1 -3 [5 3 6] 7 6
 * 
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^5
 * 
 * -10^4 <= nums[i] <= 10^4
 * 
 * 1 <= k <= nums.length
 *
 */
public class SlidingWindowMaximum {

	public class MonotonicDeque {
		private ArrayDeque<Integer> deque;

		public MonotonicDeque() {
			deque = new ArrayDeque<>();
		}

		public void push(int n) {
			while (!deque.isEmpty() && deque.peekLast() < n) {
				deque.pollLast();
			}
			deque.offerLast(n);
		}

		public int max() {
			return deque.peekFirst();
		}

		public void pollLeft(int num) {
			if (max() == num) {
				deque.pollFirst();
			}
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (k == 1)
			return nums;
		MonotonicDeque q = new MonotonicDeque();
		int[] result = new int[n - k + 1];
		for (int i = 0; i < n; i++) {
			if (i < k) {
				q.push(nums[i]);
				if (i == k - 1) {
					result[0] = q.max();
				}
			} else {
				q.pollLeft(nums[i - k]);
				q.push(nums[i]);
				result[i - k + 1] = q.max();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7, 1, 1, 1 };
		int result[] = s.maxSlidingWindow(nums, 3);
		for (int r : result) {
			System.out.println(r);
		}
	}

}
