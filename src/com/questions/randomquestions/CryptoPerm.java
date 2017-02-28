package com.questions.randomquestions;

import java.util.Scanner;

public class CryptoPerm {

	static void swap(String x, String y)
	{
	    String temp;
	    temp = x;
	    x = y;
	    y = temp;
	}
	 
	static void permute(String a, int l, int r)
	{
	   int i;
	       for (i = l; i <= r; i++)
	       {
	          swap((a+l), (a+i));
	          permute(a, l+1, r);
	          swap((a+l), (a+i)); //backtrack
	   }
	}
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			String s1 = sc.next();
			String s2 = sc.next();
			int k = sc.nextInt();
			char mainArr[] = new char[26];
			for(int j = 0; j < mainArr.length; j++){
				mainArr[i] = (char) (j+97);
			}
			StringBuilder m = new StringBuilder();
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (s1.indexOf(ch) < 0 ) {
					m.append(ch);
				}
			}
			permute(m.toString(), 0, m.length()-1);
	        System.out.println(m);	        
	        
		}
	}

}
