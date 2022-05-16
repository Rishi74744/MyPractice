package com.java.prep.coinbase;

import java.util.ArrayList;
import java.util.List;

import com.java.prep.coinbase.RangeIterator.Range;

public class CoinbaseIterators {

	public static void main(String[] args) {

		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
		Integer[] nums1 = new Integer[] { 5, 6, 7, 8, 0 };
		Integer[] nums2 = new Integer[] { 1, 2, 6, 7, 8, 0 };
		Integer[] nums3 = new Integer[] { 1, 2 };
		Integer[] nums4 = new Integer[] {};
		RangeIterator rangeIterator = new RangeIterator(new Range(0, 10, 2));
		CustomIterator<Integer> skippingIterator = new SkippingIterator<>(0, 1, nums);
		CustomIterator<Integer> skippingIterator1 = new SkippingIterator<>(0, 1, nums1);
		CustomIterator<Integer> skippingIterator2 = new SkippingIterator<>(0, 1, nums2);
		CustomIterator<Integer> skippingIterator3 = new SkippingIterator<>(0, 1, nums3);
		CustomIterator<Integer> skippingIterator4 = new SkippingIterator<>(0, 1, nums4);

		CyclicIterator<Integer> cyclicIterator = new CyclicIterator<>(skippingIterator);
		CustomIterable<Integer> customIterable = new CustomIterable<>(cyclicIterator);
		CustomIterable<Integer> customIterable1 = new CustomIterable<>(rangeIterator);

		List<CustomIterator<Integer>> iterators = new ArrayList<>();
		iterators.add(skippingIterator1);
		iterators.add(skippingIterator2);
		iterators.add(skippingIterator3);
		iterators.add(skippingIterator4);
		iterators.add(null);
		iterators.add(skippingIterator);
		
		
		CustomIterator<Integer> interleaving = new InterleavingIterator<Integer>(iterators);
		CustomIterable<Integer> interleaving1 = new CustomIterable<>(interleaving);

		
		
		while(interleaving.hasNext()) {
			System.out.print(interleaving.next() + " ");
		}
		
//		for (Integer n : interleaving1) {
//			System.out.print(n + " ");
//		}
//		for (Integer n : customIterable1) {
//			System.out.println(n);
//		}
	}

}
