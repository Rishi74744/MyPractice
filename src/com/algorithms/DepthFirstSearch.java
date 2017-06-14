package com.algorithms;

import java.util.Scanner;

public class DepthFirstSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes in graph :");
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		System.out.println("Enter the graph matrix");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter the start node");
		int start = sc.nextInt() - 1;
		boolean isVisited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			isVisited[i] = false;
		}
		boolean isValid = false;
		//while(is)
		
		
	}
}
