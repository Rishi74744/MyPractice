package com.questions.hackerrank;

import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day1 = sc.nextInt();
		int mon1 = sc.nextInt();
		int year1 = sc.nextInt();
		int day2 = sc.nextInt();
		int mon2 = sc.nextInt();
		int year2 = sc.nextInt();
		int fine = 0;
		if(year1 > year2){
			fine = 10000;
		}else if(year1 < year2){
			fine = 0;
		}else{
			if(mon1 < mon2){
				fine = 0;
			}else if(mon1 > mon2){
				fine = 500 * (mon1 - mon2);
			}else{
				if(day1 <= day2){
					fine = 0;
				}else{
					fine = 15 * (day1 - day2);
				}
			}
		}
		System.out.println(fine);
	}

}
