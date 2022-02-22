package com.java.prep.bst;

public class UniqueBST {

	public int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int bst = 0;
			for (int j = 1; j <= i; j++) {
				bst += (dp[j - 1] * dp[i - j]);
			}
			dp[i] = bst;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		UniqueBST u = new UniqueBST();
		System.out.println(u.numTrees(3));
	}

}
