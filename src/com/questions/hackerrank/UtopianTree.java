package com.questions.hackerrank;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
			int h = 1;
			int n = sc.nextInt();
			for(int j=0; j<n; j++){
				if(j % 2 == 0){
					h = h * 2;
				}else{
					h = h + 1;
				}
			}
			System.out.println(h);
		}
	}

}
