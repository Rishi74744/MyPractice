package com.questions.hackerrank;

import java.util.Scanner;

public class TheTimeInWords {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int hours = s.nextInt();
		int mins = s.nextInt();
		StringBuilder time = new StringBuilder();
		String nums[] = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
				"twenty six", "twenty seven", "twenty eight", "twenty nine" };
		if(mins == 0){
			time.append(nums[hours-1]+" o' clock");
		}else if (mins == 15) {
			time.append("quarter past "+nums[hours-1]);
		}else if (mins == 30) {
			time.append("half past "+nums[hours-1]);
		}else if(mins == 45){
			time.append("quarter to "+nums[hours]);
		}else{
			if(mins > 30){
				int x = 60 - mins;
				time.append(nums[x-1]+" minutes to "+nums[hours]);
			}else{
				time.append(nums[mins-1]);
				if(mins > 1){
					time.append(" minutes");
				}else{
					time.append(" minute"); 
				}
				time.append(" past "+nums[hours-1]);
			}
		}
		System.out.println(time);
	}

}
