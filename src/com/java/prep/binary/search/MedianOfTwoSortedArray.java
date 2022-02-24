package com.java.prep.binary.search;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000
 * 
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000
 * 
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * Constraints:
 * 
 * nums1.length == m
 * 
 * nums2.length == n
 * 
 * 0 <= m <= 1000
 * 
 * 0 <= n <= 1000
 * 
 * 1 <= m + n <= 2000
 * 
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 */
public class MedianOfTwoSortedArray {

	/**
	 * Complexity - O(m+n), Space - O(m+n)
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int merged[] = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				merged[k] = nums1[i];
				i++;
			} else {
				merged[k] = nums2[j];
				j++;
			}
			k++;
		}
		while (i < nums1.length) {
			merged[k] = nums1[i];
			i++;
			k++;
		}
		while (j < nums2.length) {
			merged[k] = nums2[j];
			j++;
			k++;
		}
		return merged.length % 2 == 0 ? (merged[(merged.length / 2) - 1] + merged[(merged.length / 2) - 1 + 1]) / 2.0
				: merged[(merged.length / 2)] / 1.0;
	}

	public static void main(String[] args) {
		int nums1[] = { 1, 2 };
		int nums2[] = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
