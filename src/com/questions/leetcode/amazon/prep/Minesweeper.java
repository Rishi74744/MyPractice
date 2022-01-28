package com.questions.leetcode.amazon.prep;

public class Minesweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
		int n = board.length;
		int m = board[0].length;
		char[][] gameBoard = new char[n][m];
		int clickRow = click[0];
		int clickCol = click[1];
		int total = 0;
		while (total != (n * m)) {
			checkConditions(board, gameBoard, clickRow, clickCol);
			total++;
			if (clickRow == n - 1 && clickCol == 0) {
				while (clickCol < m) {
					clickCol++;
					checkConditions(board, gameBoard, clickRow, clickCol);
				}
				
			}

		}
		return gameBoard;
	}

	private void checkConditions(char[][] board, char[][] gameBoard, int clickRow, int clickCol) {
		if (checkUnrevealedMine(board, clickRow, clickCol)) {
			gameBoard[clickRow][clickCol] = 'X';
		}
		if (checkEmptySquare(board, clickRow, clickCol)) {
			gameBoard[clickRow][clickCol] = 'B';
		}
		if (checkBlankSquare(board, clickRow, clickCol)) {
			gameBoard[clickRow][clickCol] = 'B';
		}
		if (checkRevealedMine(board, clickRow, clickCol)) {
			gameBoard[clickRow][clickCol] = 'X';
		}
		if (checkDigits(board, clickRow, clickCol)) {
			gameBoard[clickRow][clickCol] = board[clickRow][clickCol];
		}
	}

	public static boolean checkUnrevealedMine(char[][] board, int row, int col) {
		return board[row][col] == 'M';
	}

	public static boolean checkEmptySquare(char[][] board, int row, int col) {
		return board[row][col] == 'E';
	}

	public static boolean checkBlankSquare(char[][] board, int row, int col) {
		return board[row][col] == 'B';
	}

	public static boolean checkRevealedMine(char[][] board, int row, int col) {
		return board[row][col] == 'X';
	}

	public static boolean checkDigits(char[][] board, int row, int col) {
		return board[row][col] >= '1' && board[row][col] <= '8';
	}

	public static void main(String[] args) {

	}

}
