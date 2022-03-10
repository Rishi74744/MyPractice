package com.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class JavaSample {

	static class Pair {
		String name;
		Integer value;

		Pair(String name, Integer value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public Integer getValue() {
			return value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			return prime * result + ((name == null) ? 0 : name.hashCode());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pair [name=" + name + ", value=" + value + "]";
		}

	}

	public static Map<String, Integer> valueSort(final Map<String, Integer> map) {
		Comparator<String> valueComparator = new Comparator<String>() {
			public int compare(String k1, String k2) {
				int comp = map.get(k1).compareTo(map.get(k2));
				if (comp == 0)
					return 1;
				else
					return comp;
			}
		};
		Map<String, Integer> sorted = new TreeMap<String, Integer>(valueComparator);
		sorted.putAll(map);
		return sorted;
	}

	Map<String, Integer> idToScore = new HashMap<>();

	public void addScore(String playerId, int score) {
		idToScore.put(playerId, score);
	}

	public void top(int K) {
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> {
			return p1.getValue().compareTo(p2.getValue());
		});

		for (Entry<String, Integer> e : idToScore.entrySet()) {
			minHeap.offer(new Pair(e.getKey(), e.getValue()));
			if (minHeap.size() > K)
				minHeap.poll();
		}

		System.out.println(minHeap);
	}

	public void reset(int playerId) {
		idToScore.remove(playerId);
	}

	public static void main(String[] args) {

		JavaSample j = new JavaSample();
		j.addScore("a", 40);
		j.addScore("d", 50);
		j.addScore("b", 30);
		j.addScore("d", 10);
		j.addScore("e", 6);

		j.top(3);
	}

}
