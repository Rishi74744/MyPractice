package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

	static class RandomizedSet {

		Map<Integer, Integer> set = null;
		List<Integer> list = null;

		public RandomizedSet() {
			set = new HashMap<>();
			list = new ArrayList<>();
		}

		public boolean insert(int val) {
			if (!set.containsKey(val)) {
				list.add(val);
				set.put(val, list.indexOf(val));
				return true;
			}
			return false;
		}

		public boolean remove(int val) {
			if (set.containsKey(val)) {
				int idx = set.get(val);
				Collections.swap(list, idx, list.size() - 1);
				set.put(list.get(idx), idx);

				set.remove(val);
				list.remove(list.size() - 1);
				return true;
			}
			return false;
		}

		public int getRandom() {
			int index = new Random().nextInt(set.size());
			return list.get(index);
		}

	}

	public static void main(String[] args) {
		RandomizedSet s = new RandomizedSet();
		System.out.println(s.insert(0));
		System.out.println(s.insert(1));
		System.out.println(s.remove(0));
		System.out.println(s.insert(2));
		System.out.println(s.remove(1));
		System.out.println(s.getRandom());
	}

}
