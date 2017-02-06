package com.questions.hackerrank;
import java.util.Scanner;

public class BeautifulBinaryString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int count = 0;
		String subString = "010";
		int index = s.indexOf(subString);
		while (s.indexOf(subString) != -1) {
		    count++;
		    index = s.indexOf(subString) + 3;
		    if(index < s.length()){
		    	s = s.substring(index);
		    	System.out.println(s);
		    }else{
		    	break;
		    }
		}
		System.out.println(count);
	}

}
