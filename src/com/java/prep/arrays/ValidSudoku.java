package com.java.prep.arrays;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * 
 * Each column must contain the digits 1-9 without repetition.
 * 
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * 
 * Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * 
 * [["5","3",".",".","7",".",".",".","."]
 * 
 * ,["6",".",".","1","9","5",".",".","."]
 * 
 * ,[".","9","8",".",".",".",".","6","."]
 * 
 * ,["8",".",".",".","6",".",".",".","3"]
 * 
 * ,["4",".",".","8",".","3",".",".","1"]
 * 
 * ,["7",".",".",".","2",".",".",".","6"]
 * 
 * ,[".","6",".",".",".",".","2","8","."]
 * 
 * ,[".",".",".","4","1","9",".",".","5"]
 * 
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: board =
 * 
 * [["8","3",".",".","7",".",".",".","."]
 * 
 * ,["6",".",".","1","9","5",".",".","."]
 * 
 * ,[".","9","8",".",".",".",".","6","."]
 * 
 * ,["8",".",".",".","6",".",".",".","3"]
 * 
 * ,["4",".",".","8",".","3",".",".","1"]
 * 
 * ,["7",".",".",".","2",".",".",".","6"]
 * 
 * ,[".","6",".",".",".",".","2","8","."]
 * 
 * ,[".",".",".","4","1","9",".",".","5"]
 * 
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 
 * Output: false
 * 
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Constraints:
 * 
 * board.length == 9
 * 
 * board[i].length == 9
 * 
 * board[i][j] is a digit 1-9 or '.'.
 *
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		// first, verify the horizontal rows
		for (char[] row : board) {
			if (searchRow(row) == false)
				return false;
		}
		// next, verify the columns (or vertical rows)
		for (int i = 0; i < 9; i++) {
			if (searchRow(getVerticalRow(i, board)) == false)
				return false;
		}
		// finally, verify the 3x3 boxes
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (searchRow(getCube(i, j, board)) == false)
					return false;
			}
		}
		return true;
	}

	public boolean searchRow(char[] row) {
		HashSet<Character> visited = new HashSet<>();
		for (char c : row) {
			if (visited.contains(c))
				return false;
			if (c != '.')
				visited.add(c);
		}
		return true;
	}

	public char[] getVerticalRow(int colIdx, char[][] board) {
		char[] col = new char[board.length];
		for (int i = 0; i < board.length; i++) {
			col[i] = board[i][colIdx];
		}
		return col;
	}

	/*
	 * convert each 3x3 box into a single flat array, starting at the provided x and
	 * y coordinates
	 */
	public char[] getCube(int x, int y, char[][] board) {
		char[] cube = new char[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i * 3 + j] = board[x + i][y + j];
			}
		}
		return cube;
	}
	
	public static void main(String[] args) {
		
	}

}
