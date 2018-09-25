package com.java.hackerrank.trie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Contacts {

	private static Map<Character, Trie> contactsList = new HashMap<>();

	private static final Scanner scanner = new Scanner(System.in);

	private static int[] contacts(String[][] queries) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			String ops = queries[i][0];
			String data = queries[i][1];
			if (contactsList.containsKey(data.charAt(0))) {
				Trie node = contactsList.get(data.charAt(0));
			} else {
				if ("find".equals(ops)) {
					result.add(0);
				} else if ("add".equals(ops)) {
					Trie node = addContact(data, 0);
					contactsList.put(data.charAt(0), node);
				}
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int findContact(Trie trie, String partial, int index) {
		int length = 0;
		if (trie == null || partial == null) {
			return 0;
		}
		if (trie.getTries().isEmpty() && !trie.isLastLetter()) {
			return 0;
		}
		if (trie.getData() != partial.charAt(index)) {
			return 0;
		}
		for (Trie node : trie.getTries()) {
			length = 1 + findContact(node, partial.substring(index + 1, partial.length()), index + 1);
		}
		return length;
	}

	private static Trie addContact(String contact, int index) {
		if (contact == null || contact.isEmpty()) {
			return null;
		}
		Trie node = new Trie(contact.charAt(index));
		Trie nextNode = addContact(contact.substring(index + 1, contact.length()), index + 1);
		if (nextNode == null) {
			List<Trie> tries = new ArrayList<>();
			tries.add(nextNode);
			node.setTries(tries);
		}
		node.setLastLetter(true);
		return node;
	}

	public static void main(String[] args) throws IOException {
		int queriesRows = Integer.parseInt(scanner.nextLine().trim());
		String[][] queries = new String[queriesRows][2];
		for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
				String queriesItem = queriesRowItems[queriesColumnItr];
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}
		int[] result = contacts(queries);
		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			System.out.println(result[resultItr]);
		}
	}

}

class Trie {
	private Character data;
	private boolean isLastLetter;
	private List<Trie> tries;

	public Trie(Character data) {
		this.data = data;
	}

	public Character getData() {
		return data;
	}

	public List<Trie> getTries() {
		return tries;
	}

	public boolean isLastLetter() {
		return isLastLetter;
	}

	public void setLastLetter(boolean isLastLetter) {
		this.isLastLetter = isLastLetter;
	}

	public void setTries(List<Trie> tries) {
		this.tries = tries;
	}
}