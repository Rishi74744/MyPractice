package com.questions.hackerrank;

import java.util.Scanner;

public class SaveThePrisoner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 0;
		for(int i = 0; i<t ; i++){
			long n = sc.nextInt();
			long m = sc.nextInt();
			long s = sc.nextInt();
			long prisonerNum = 1;
			if(m == n){
				if(s == 1){
					prisonerNum = n;
				}else{
					prisonerNum = s - 1;
				}
			}else if(m < n){
				long l = m + s;
				if(l > n){
					prisonerNum = n - l - 1;
				}else if(l < n){
					prisonerNum = l - 1;
				}else{
					prisonerNum = n - 1;
				}
			}else{
				long x = m % n;
				prisonerNum = x + s - 1;
			}
			System.out.println(prisonerNum);
		}
	}
}
