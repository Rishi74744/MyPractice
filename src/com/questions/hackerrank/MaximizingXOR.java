package com.questions.hackerrank;

import java.util.Scanner;

public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		int max = 0;
		for(int i = l; i <= r; i++){
			for(int j = l; j <= r; j++){
				int k = i ^ j;
				if(max < k){
					max = k;
				}
			}
		}
		System.out.println(max);
	}

}
