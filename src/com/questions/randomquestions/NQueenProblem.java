package com.questions.randomquestions;

import java.util.Scanner;

public class NQueenProblem {

	void printSolution(int board[][], int N) {
		boolean isFirst = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++){
				if(board[i][j] == 1){
					if(isFirst){
						System.out.print(j+1);
						isFirst = false;
					}else{
						System.out.print(" "+(j+1));
					}
				}
			}
		}
	}

	boolean isSafe(int board[][], int row, int col, int N) {
		int i, j;
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
	boolean solveNSUtil(int board[][], int col, int N) {
		if (col >= N)
			return true;

		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col, N)) {
				board[i][col] = 1;
				
				if (solveNSUtil(board, col + 1, N) == true)
					return true;
				board[i][col] = 0;
			}
		}
		return false;
	}
	
	boolean solveNS(int N) {
		int board[][] = new int[N][N];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				board[i][j] = 0;
			}
		}

		if (solveNSUtil(board, 0, N) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board, N);
		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNS(N);
	}
}