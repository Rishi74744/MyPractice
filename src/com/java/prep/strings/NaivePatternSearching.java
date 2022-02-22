package com.java.prep.strings;

public class NaivePatternSearching {

	public int findPatternIndexInText(String text, String pattern) {
		int index = -1;
		for (int i = 0; i < text.length(); i++) {
			int j = 0;
			for (; j < pattern.length() && (i + j) < text.length(); j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == pattern.length()) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		NaivePatternSearching n = new NaivePatternSearching();
		int index = n.findPatternIndexInText("aaaaa", "ab");
		System.out.println("Pattern Found At Index : " + index);
	}

}
