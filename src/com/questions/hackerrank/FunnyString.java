package com.questions.hackerrank;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t ; i++){
			String s = sc.nextLine();
			int len = s.length();
			char sr[] = new char[len];
			int k = 0;
			while(len != 0){
				sr[k] = s.charAt(len);
				len--;
				k++;
			}
			int count = 0;
			int j = 1;
			char sa[] = s.toCharArray();
			boolean isFunnyString = true;
			while(count != s.length()){
				if(!(Math.abs(sa[j] - sa[j-1]) == Math.abs(sr[j] - sr[j-1]))){
					isFunnyString = false;
					break;
				}
			}
			if(isFunnyString){
				System.out.println("Funny");
			}else{
				System.out.println("Not Funny");
			}
		}
	}
}
