package com.java.prep.arrays;

/**
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example 1:
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED" Output: true
 * 
 * Example 2:
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE" Output: true
 * 
 * Example 3:
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB" Output: false
 * 
 * 
 * Constraints:
 * 
 * m == board.length
 * 
 * n = board[i].length
 * 
 * 1 <= m, n <= 6
 * 
 * 1 <= word.length <= 15
 * 
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * Follow up: Could you use search pruning to make your solution faster with a
 * larger board?
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		char words[] = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && search(board, i, j, 0, words)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean search(char[][] board, int row, int col, int wordIndex, char words[]) {
		if (wordIndex == words.length) {
			return true;
		}
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != words[wordIndex]) {
			return false;
		}
		board[row][col] ^= 256;
		boolean result = search(board, row + 1, col, wordIndex + 1, words)
				|| search(board, row - 1, col, wordIndex + 1, words)
				|| search(board, row, col + 1, wordIndex + 1, words)
				|| search(board, row, col - 1, wordIndex + 1, words);
		board[row][col] ^= 256;
		return result;
	}

	public static void main(String[] args) {
		WordSearch w = new WordSearch();
//		char board[][] = {};
//		String word = null;
//		System.out.println(w.exist(board, word));
		char a = 'A';
		System.out.println(a);
		System.out.println(a ^ 256);
	}

}
