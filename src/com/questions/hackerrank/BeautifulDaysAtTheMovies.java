package com.questions.hackerrank;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		while((i-j)!=0){
			int rev = reverse(i);
			if(Math.abs(i - rev) % k == 0){
				count++;
			}
			i++;
		}
		System.out.println(count);
	}

	public static int reverse(int x){
		int reverseNum = 0;
		while(x!=0){
			reverseNum = (reverseNum * 10) + (x % 10);
			x = x / 10;
		}
		return reverseNum;
	}
	
}
