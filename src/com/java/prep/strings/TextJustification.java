package com.java.prep.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such
 * that each line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line does not divide evenly between words, the
 * empty slots on the left will be assigned more spaces than the slots on the
 * right.
 * 
 * For the last line of text, it should be left-justified and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only. Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth. The input array words contains at least one word.
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["This", "is", "an", "example", "of", "text",
 * "justification."], maxWidth = 16 Output: [ "This is an", "example of text",
 * "justification. " ]
 * 
 * Example 2:
 * 
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth =
 * 16 Output: [ "What must be", "acknowledgment ", "shall be " ]
 * 
 * Explanation: Note that the last line is "shall be " instead of "shall be",
 * because the last line must be left-justified instead of fully-justified. Note
 * that the second line is also left-justified because it contains only one
 * word.
 * 
 * Example 3:
 * 
 * Input: words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"],
 * maxWidth = 20 Output: [ "Science is what we", "understand well", "enough to
 * explain to", "a computer. Art is", "everything else we", "do " ]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 300
 * 
 * 1 <= words[i].length <= 20
 * 
 * words[i] consists of only English letters and symbols.
 * 
 * 1 <= maxWidth <= 100
 * 
 * words[i].length <= maxWidth
 *
 */
public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int currentIndex = 0;
		int currentWidth = 0;
		for (int i = 0; i < words.length; i++) {
			StringBuilder currentLine = new StringBuilder();
			if (!result.isEmpty() && result.size() == currentIndex + 1) {
				currentLine = new StringBuilder(result.get(currentIndex));
				result.remove(currentIndex);
			}
			if (currentWidth + words[i].length() > maxWidth) {
				currentLine = rebalance(currentLine, maxWidth, false);
				currentIndex++;
				currentWidth = 0;
				i--;
			} else {
				currentLine.append(words[i]).append(" ");
				currentWidth = currentLine.length();
			}
			result.add(currentLine.toString());
		}
		StringBuilder rebalancedString = rebalance(new StringBuilder(result.get(currentIndex)), maxWidth, true);
		System.out.println(rebalancedString.length());
		result.remove(currentIndex);
		result.add(rebalancedString.toString());
		return result;
	}

	public StringBuilder rebalance(StringBuilder line, int maxWidth, boolean isLastLine) {
		int spacesLeft = maxWidth - line.length() + 1;
		String[] lineWords = line.toString().split(" ");
		if (isLastLine) {
			for (int i = 0; i < lineWords.length - 1; i++) {
				lineWords[i] = lineWords[i] + " ";
			}
			StringBuilder rebalancedString = new StringBuilder();
			for (String word : lineWords) {
				rebalancedString.append(word);
			}
			int spaces = spacesLeft;
			while (spaces > 0) {
				rebalancedString.append(" ");
				spaces--;
			}
			return rebalancedString;
		}
		if (lineWords.length == 1) {
			StringBuilder rebalancedString = new StringBuilder(lineWords[0]);
			for (int i = 1; i <= spacesLeft; i++) {
				rebalancedString.append(" ");
			}
			return rebalancedString;
		}

		for (int i = 0; i < lineWords.length - 1; i++) {
			lineWords[i] = lineWords[i] + " ";
		}
		int idx = 0;
		while (spacesLeft != 0) {
			if (idx == lineWords.length - 1) {
				idx = 0;
				continue;
			}
			lineWords[idx] = lineWords[idx] + " ";
			idx++;
			spacesLeft--;
		}
		StringBuilder rebalancedString = new StringBuilder();
		for (String word : lineWords) {
			rebalancedString.append(word);
		}
		return rebalancedString;
	}

	public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String words[] = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
				"computer.", "Art", "is", "everything", "else", "we", "do" };
		String words1[] = { "What", "must", "be", "acknowledgment", "shall", "be" };
		String words2[] = { "ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you",
				"can", "do", "for", "your", "country" };
//		System.out.println(t.fullJustify(words, 20));
//		System.out.println(t.fullJustify(words1, 16));
		System.out.println(t.fullJustify(words2, 16));

		// ["ask not what","your country can","do for you ask","what you can do","for
		// your country"]
		// ["ask not what","your country can","do for you ask","what you can do","for
		// your country "]
	}

}
