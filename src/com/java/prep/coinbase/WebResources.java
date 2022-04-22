package com.java.prep.coinbase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question: There were logs provided with timestamp, user, resource id-
 * ["58523", "user_1", "resource_1"].
 * 
 * Write a function that takes the logs and returns the resource with the
 * highest number of accesses in any 5 minute window, together with how many
 * accesses it saw.
 */
public class WebResources {

	public List<String> webResource(String[][] logs) {

		List<String> result = new ArrayList<String>();

		Map<String, List<Integer>> hmap = new HashMap<String, List<Integer>>();

		for (String[] log : logs) {
			List<Integer> l = hmap.getOrDefault(log[1], new ArrayList<Integer>());
			l.add(Integer.parseInt(log[0]));
			Collections.sort(l);
			hmap.put(log[1], l);
		}

		for (String key : hmap.keySet()) {
			if (hmap.get(key).size() == 1) {
				result.add(key + "[" + hmap.get(key).get(0) + "," + hmap.get(key).get(0) + "]");
			} else {
				result.add(key + "[" + hmap.get(key).get(0) + "," + hmap.get(key).get(hmap.get(key).size() - 1) + "]");
			}

		}

		return result;

	}

	public static void main(String args[]) {

		WebResources w = new WebResources();
		String[][] logs1 = { { "58523", "user_1", "resource_1" }, { "62314", "user_2", "resource_2" },
				{ "54001", "user_1", "resource_3" }, { "200", "user_6", "resource_5" },
				{ "215", "user_6", "resource_4" }, { "54060", "user_2", "resource_3" },
				{ "53760", "user_3", "resource_3" }, { "58522", "user_22", "resource_1" },
				{ "53651", "user_5", "resource_3" }, { "2", "user_6", "resource_1" }, { "100", "user_6", "resource_6" },
				{ "400", "user_7", "resource_2" }, { "100", "user_8", "resource_6" },
				{ "54359", "user_1", "resource_3" }, };
		List<String> output = w.webResource(logs1);
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}

	}

}
