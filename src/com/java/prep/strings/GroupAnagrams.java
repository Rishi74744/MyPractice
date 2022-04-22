package com.java.prep.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * 
 * Input: strs = [""] Output: [[""]]
 * 
 * Example 3:
 * 
 * Input: strs = ["a"] Output: [["a"]]
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 10^4
 * 
 * 0 <= strs[i].length <= 100
 * 
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

	/**
	 * Complexity - O(n^2 * logn) : n - [List of anagrams] * (nlogn) - [Sorting],
	 * Space - O(n)
	 */
	public static List<List<String>> groupAnagrams(String[] sArr) {
		Map<String, List<String>> anagramMap = new HashMap<>();
		for (String s : sArr) {
			char c[] = s.replaceAll(" ", "").toCharArray();
			Arrays.sort(c);
			String sortedKey = new String(c);
			List<String> anagramList = null;
			anagramList = anagramMap.getOrDefault(sortedKey, new ArrayList<>());
			anagramList.add(s);
			anagramMap.put(sortedKey, anagramList);
		}
		return anagramMap.values().stream().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		String arr[] = { "inch", "cat", "chin", "kit", "act" };
		System.out.println(groupAnagrams(arr));
	}
}
