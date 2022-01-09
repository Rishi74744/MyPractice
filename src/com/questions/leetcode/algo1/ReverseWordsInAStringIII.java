package com.questions.leetcode.algo1;

public class ReverseWordsInAStringIII {

	public static void reverse(char arr[], int k, int l) {
		if (k < 0 || l < 0) {
			return;
		}
		while (k <= l) {
			char currentCharacter = arr[k];
			arr[k] = arr[l];
			arr[l] = currentCharacter;
			k++;
			l--;
		}
	}

	public static String reverseWords(String s) {
		char arr[] = s.toCharArray();
		int wordAt = -1;
		int spaceAt = -1;
		boolean isLastSpace = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				if (isLastSpace) {
					int k = wordAt;
					int l = spaceAt - 1;
					reverse(arr, k, l);
					wordAt = i;
				}
				spaceAt = i;
				isLastSpace = true;
			} else {
				if (isLastSpace) {
					int k = wordAt;
					int l = spaceAt - 1;
					reverse(arr, k, l);
					wordAt = i;
				}
				isLastSpace = false;
				if (i == arr.length - 1) {
					spaceAt = arr.length;
				}
			}
		}
		int k = wordAt;
		int l = spaceAt - 1;
		reverse(arr, k, l);

		return new String(arr);
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

}
