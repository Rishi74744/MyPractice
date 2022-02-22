package com.java.prep.strings;

public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		int idx = -1;
		if (needle.isEmpty()) {
			return 0;
		}
		int n = haystack.length();
		int m = needle.length();
		int i = 0;
		int j = 0;
		int lps[] = new int[m];
		preprocessPattern(needle, m, lps);
		while (i < n) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				idx = (i - j);
				break;
			} else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return idx;
	}

	private void preprocessPattern(String needle, int m, int lps[]) {
		int l = 0;
		int i = 1;
		lps[0] = 0;
		while (i < m) {
			if (needle.charAt(i) == needle.charAt(l)) {
				l++;
				lps[i] = l;
				i++;
			} else {
				if (l != 0) {
					l = lps[l - 1];
				} else {
					lps[i] = l;
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		ImplementStrStr i = new ImplementStrStr();
		System.out.println(i.strStr("aabcabaaabcaabc", "aabc"));
	}

}
