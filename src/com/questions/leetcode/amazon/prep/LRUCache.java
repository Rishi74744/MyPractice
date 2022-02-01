package com.questions.leetcode.amazon.prep;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	int capactiy = 0;
	Map<Integer, Integer> cache = new LinkedHashMap<>();

	public LRUCache(int capacity) {
		this.capactiy = capacity;

		cache = new LinkedHashMap<>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> val) {
				if (size() > capacity)
					return true;
				else
					return false;
			}
		};
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		cache.put(key, value);
	}

	public static void main(String[] args) {
//		LRUCache cache = new LRUCache(2);
//		System.out.println(cache.get(2));
//		cache.put(2, 6);
//		System.out.println(cache.get(1));
//		cache.put(1, 5);
//		cache.put(1, 2);
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(2));

	}

}
