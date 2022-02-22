package com.java.prep.strings;

public class KMPPatternSearching {

	public void kmpSearch(String t, String p) {
		int n = t.length();
		int m = p.length();
		int i = 0;
		int j = 0;
		int lps[] = new int[m];
		preprocessPattern(p, m, lps);
		while (i < n) {
			if (t.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Found At : " + (i - j));
				j = lps[j - 1];
			} else if (i < n && t.charAt(i) != p.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	private void preprocessPattern(String p, int m, int lps[]) {
		int l = 0;
		int i = 1;
		lps[0] = 0;
		while (i < m) {
			if (p.charAt(l) == p.charAt(i)) {
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
		KMPPatternSearching k = new KMPPatternSearching();
		k.kmpSearch("aabcabaaabcaabc", "aabc");
	}

}
