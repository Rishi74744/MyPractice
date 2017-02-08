package com.questions.hackerrank;

import java.util.Scanner;

public class JumpingOnTheClouds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int clouds[] = new int[n];
		for (int i = 0; i < n; i++) {
			clouds[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 1; i < n; i++) {
			if(i == (n-1)){
				if(clouds[i] == 0){
					count++;
				}
				break;
			}
			if(clouds[i] == 0){
				if(clouds[i+1] == 0){
					i++;
				}
			}else{
				i++;
			}
			count++;
		}
		System.out.println(count);
	}
}
