package com.questions.leetcode.amazon.prep;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

	int capactiy = 0;
	Map<Integer, Integer> cache = new LinkedHashMap<>();

	public LFUCache(int capacity) {
		this.capactiy = capacity;

		cache = new LinkedHashMap<>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> val) {
				if (size() > capacity)
					return false;
				else
					return true;
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
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);
		lfu.put(2, 2);
		System.out.println(lfu.get(1));
		lfu.put(3, 3);
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		lfu.put(4, 4);
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(4));
	}

}
