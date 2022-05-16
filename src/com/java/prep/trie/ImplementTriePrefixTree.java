package com.java.prep.trie;

/**
 * 
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object.
 * 
 * void insert(String word) Inserts the string word into the trie.
 * 
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * 
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input
 * 
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * 
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 
 * Output
 * 
 * [null, null, true, false, true, null, true]
 * 
 * Explanation
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * 
 * trie.search("apple"); // return True
 * 
 * trie.search("app"); // return False
 * 
 * trie.startsWith("app"); // return True
 * 
 * trie.insert("app");
 * 
 * trie.search("app"); // return True
 * 
 * Constraints:
 * 
 * 1 <= word.length, prefix.length <= 2000
 * 
 * word and prefix consist only of lowercase English letters.
 * 
 * At most 3 * 104 calls in total will be made to insert, search, and
 * startsWith.
 *
 */
public class ImplementTriePrefixTree {

	static class PrefixTree {
		private PrefixTree nodes[];
		private boolean isWordEnd;

		public PrefixTree() {
			this.nodes = new PrefixTree[26];
		}

		public PrefixTree[] getNodes() {
			return nodes;
		}

		public void setNodes(PrefixTree[] nodes) {
			this.nodes = nodes;
		}

		public boolean isWordEnd() {
			return isWordEnd;
		}

		public void setWordEnd(boolean isWordEnd) {
			this.isWordEnd = isWordEnd;
		}

	}

	PrefixTree root;

	public ImplementTriePrefixTree() {
		root = new PrefixTree();
	}

	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			return;
		}
		int wordLength = word.length();
		PrefixTree prevNode = root;
		for (int i = 0; i < wordLength; i++) {
			int index = word.charAt(i) - 'a';
			PrefixTree currentNode = prevNode.getNodes()[index];
			if (currentNode == null) {
				currentNode = new PrefixTree();
				prevNode.getNodes()[index] = currentNode;
			}
			prevNode = currentNode;
		}
		prevNode.setWordEnd(true);

	}

	public boolean search(String word) {
		if (word == null || word.isEmpty()) {
			return false;
		}
		int wordLength = word.length();
		PrefixTree prevNode = root;
		boolean isValid = true;
		for (int i = 0; i < wordLength; i++) {
			int index = word.charAt(i) - 'a';
			if (prevNode.getNodes()[index] != null) {
				prevNode = prevNode.getNodes()[index];
			} else {
				isValid = false;
				break;
			}
		}
		return isValid && prevNode.isWordEnd;
	}

	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.isEmpty()) {
			return false;
		}
		int wordLength = prefix.length();
		PrefixTree prevNode = root;
		boolean isValid = true;
		for (int i = 0; i < wordLength; i++) {
			int index = prefix.charAt(i) - 'a';
			if (prevNode.getNodes()[index] != null) {
				prevNode = prevNode.getNodes()[index];
			} else {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	public static void main(String[] args) {
		ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
		trie.insert("hello");
		System.out.println(trie.search("hello")); // return True
		System.out.println(trie.search("hell")); // return False
		System.out.println(trie.search("helloa")); // return False
		System.out.println(trie.startsWith("hell")); // return True
		System.out.println(trie.startsWith("helloa")); // return False
		System.out.println(trie.startsWith("hello")); // return True
//		trie.insert("app");
//		System.out.println(trie.search("app")); // return True
	}

}
