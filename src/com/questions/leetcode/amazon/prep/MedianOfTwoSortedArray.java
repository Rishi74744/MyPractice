package com.questions.leetcode.amazon.prep;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MedianOfTwoSortedArray {

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
		while (j < nums1.length) {
			merged[k] = nums2[j];
			j++;
			k++;
		}
		DecimalFormat decimalFormat = new DecimalFormat("#.00000");
		if (merged.length % 2 == 0) {
			int mid = (merged.length / 2) - 1;
			double value = (merged[mid] + merged[mid + 1]) / 2.0;
			return Double.parseDouble(decimalFormat.format(value));
		} else {
			int mid = merged.length / 2;
			return Double.parseDouble(decimalFormat.format(merged[mid]));
		}
	}

	public static void main(String[] args) {
		int nums1[] = { 1, 2 };
		int nums2[] = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
