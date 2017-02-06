package com.questions.hackerrank;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t; i++){
			int n = sc.nextInt();
			int num = n;
			int count = 0;
			while(num!=0){
				int r = num%10;
				num = num/10;
				if(r != 0 && n % r == 0){
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
