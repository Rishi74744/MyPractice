package com.questions.leetcode.amazon.prep;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean canBreak[] = new boolean[s.length() + 1];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if ((j == 0 || canBreak[j]) && wordDict.contains(s.substring(j, i))) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[s.length()];
	}

	public static void main(String[] args) {
		List<String> wordDict = Arrays.asList("leet", "code", "s");
		System.out.println(wordBreak("leetcodess", wordDict));
	}

}
