package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentSubtreeSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	Map<Integer, Integer> frequencyCount = new HashMap<>();
	int maxFreq = 0;
	int totalWithMaxFreq = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		calculateSum(root);
		int result[] = new int[totalWithMaxFreq];
		int idx = 0;
		for (Map.Entry<Integer, Integer> e : frequencyCount.entrySet()) {
			if (e.getValue() == maxFreq) {
				result[idx] = e.getKey();
				idx++;
			}
		}
		return result;
	}

	public int calculateSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = calculateSum(root.left) + calculateSum(root.right) + root.val;
		int currentFrequency = frequencyCount.getOrDefault(sum, 0) + 1;
		frequencyCount.put(sum, currentFrequency);
		if (currentFrequency == maxFreq) {
			totalWithMaxFreq++;
		} else if (currentFrequency > maxFreq) {
			maxFreq = currentFrequency;
			totalWithMaxFreq = 1;
		}
		return sum;
	}

}
