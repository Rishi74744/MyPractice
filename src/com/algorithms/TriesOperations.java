package com.algorithms;

class TrieNode {
	boolean isEndOfWord;
	char letter;
	String word;
	TrieNode children[];

	public TrieNode() {
		isEndOfWord = false;
		children = new TrieNode[26];
	}

	public TrieNode(char c, String word) {
		this.letter = c;
		this.word = word;
		this.isEndOfWord = false;
		this.children = new TrieNode[26];
	}

}

public class TriesOperations {

	static TrieNode root = new TrieNode();

	public static void insert(String word) {
		TrieNode node = root;
		StringBuilder letter = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				letter.append(c);
				node.children[c - 'a'] = new TrieNode(c, letter.toString());
			}
			node = node.children[c - 'a'];
		}
		node.isEndOfWord = true;
	}

	public static boolean search(String word) {
		return isMatch(word, root, 0, true);
	}

	public static boolean startsWith(String prefix) {
		return isMatch(prefix, root, 0, false);
	}

	public static boolean isMatch(String s, TrieNode node, int index, boolean isFullMatch) {
		if (node == null)
			return false;

		if (index == s.length())
			return !isFullMatch || node.isEndOfWord;
		
		return isMatch(s, node.children[s.charAt(index) - 'a'], index + 1, isFullMatch);
	}

	public static void main(String[] args) {
		insert("cat");
		insert("car");
		insert("dog");
		insert("pick");
		insert("pickle");
		boolean isPresent = search("cat");
		System.out.println(isPresent);
		isPresent = search("picky");
		System.out.println(isPresent);
		isPresent = startsWith("ca");
		System.out.println(isPresent);
		isPresent = startsWith("pen");
		System.out.println(isPresent);
	}

}
