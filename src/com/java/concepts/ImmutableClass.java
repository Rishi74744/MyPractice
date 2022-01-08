package com.java.concepts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ImmutableClass {

	private final int id;
	private final Map<String, String> map;
	private final String name;

	public int getId() {
		return id;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public String getName() {
		return name;
	}

	public ImmutableClass(int id, Map<String, String> map, String name) {
		super();
		this.id = id;
		this.name = name;
		Map<String, String> tempMap = new HashMap<>();
		String key;
		Iterator<String> itr = map.keySet().iterator();
		while (itr.next() != null) {
			key = itr.next();
			tempMap.put(key, tempMap.get(key));
		}
		this.map = tempMap;
	}

}
