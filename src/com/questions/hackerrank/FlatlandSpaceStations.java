package com.questions.hackerrank;

import java.util.Scanner;

public class FlatlandSpaceStations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < m; i++){
			int a = sc.nextInt();
			arr[a] = 1;
		}
	}

}
