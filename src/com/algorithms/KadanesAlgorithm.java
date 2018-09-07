package com.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KadanesAlgorithm {

	public static int maxSubArray(final List<Integer> A) {
		int max = 0;
		int maxNow = 0;
		int minNeg = A.get(0);
		boolean isPositive = false;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > 0) {
				isPositive = true;
			}
			maxNow = maxNow + A.get(i);
			if (maxNow < 0) {
				maxNow = 0;
			}
			if (max < maxNow) {
				max = maxNow;
			}
			if (!isPositive && minNeg < A.get(i)) {
				minNeg = A.get(i);
			}
		}
		if (isPositive) {
			return max;
		} else {
			return minNeg;
		}
	}

	public static void main(String[] args) {
		List<Integer> sample = new ArrayList<>();
		sample.add(-500);
		sample.add(-3000);
		sample.add(-122);
		System.out.println(maxSubArray(sample));
		Map<Integer, Integer> m = new LinkedHashMap<>();
	}

}
