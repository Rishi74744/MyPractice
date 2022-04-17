package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i
 * <= k is in wordList. Note that beginWord does not need to be in wordList. sk
 * == endWord Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from
 * beginWord to endWord, or 0 if no such sequence exists.
 * 
 * Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot"
 * -> "dog" -> cog", which is 5 words long.
 * 
 * Example 2:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore there is no
 * valid transformation sequence.
 * 
 * Constraints:
 * 
 * 1 <= beginWord.length <= 10
 * 
 * endWord.length == beginWord.length
 * 
 * 1 <= wordList.length <= 5000
 * 
 * wordList[i].length == beginWord.length beginWord, endWord, and wordList[i]
 * consist of lowercase English letters.
 * 
 * beginWord != endWord
 * 
 * All the words in wordList are unique.
 */
public class WordLadder {

	/**
	 * Time Complexity :- BigO(M^2 * N), where M is size of dequeued word & N is
	 * size of our word list
	 * 
	 * Space Complexity :- BigO(M * N) where M is no. of character that we had in
	 * our string & N is the size of our wordList.
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Set<String> words = new HashSet<>(wordList);
		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		q.offer(beginWord);
		visited.add(beginWord);
		int result = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curr = q.poll();
				if (curr.equals(endWord)) {
					return result;
				}
				for (int j = 0; j < curr.length(); j++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char[] currentWord = curr.toCharArray();
						currentWord[j] = c;
						String modifiedWord = new String(currentWord);
						if (words.contains(modifiedWord) && !visited.contains(modifiedWord)) {
							q.add(modifiedWord);
							visited.add(modifiedWord);
						}
					}
				}
			}
			result++;
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(w.ladderLength("hit", "cog", wordList));
	}

}
