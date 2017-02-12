package com.questions.randomquestions;

public class RightPyramid {

	public static void main(String[] args) {
		int n = 4;
		int p = 3;
		int k = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < p; j++){
				System.out.print(" ");
			}
			p--;
			for(int j = 0; j < k; j++){
				System.out.print("*");
			}
			k++;
			System.out.println();
		}

	}

}
