package com.java6;

import java.util.Hashtable;

public class HashTableExample {

	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put("a", 1);
		ht.put("b", 2);
		ht.put("c", 3);

		System.out.println(ht.get("b"));
	}

}
