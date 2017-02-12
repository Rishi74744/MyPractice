package com.questions.randomquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthLexicographicPermutation {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		k = sc.nextInt();
		StringBuilder missingString = new StringBuilder();
		for(char ch = 'a'; ch <= 'z'; ch++){
			if(s2.indexOf(ch)<0){
				missingString.append(ch);
			}
		}
		
		permuteString("", missingString.toString());
		System.out.println("Output :"+l1.get(k-1));
	}
	static int k;
	static int j = 0;
	static String finalOutput;
	static List<String> l1 = new ArrayList<>();
	


		  public static void permuteString(String beginningString, String endingString) {
		    if (j>k){
		    	finalOutput = beginningString + endingString;
		    	l1.add(finalOutput);
		    	System.out.println(finalOutput);
		    }
		    else{
		      for (int i = 0; i < endingString.length(); i++) {
		        try {
		          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
		          j++;
	        	  permuteString(beginningString + endingString.charAt(i), newString);
		        } catch (StringIndexOutOfBoundsException exception) {
		          exception.printStackTrace();
		        }
		      }
		    }
		  }

	/*
	 * * A method exposed to client to calculate permutation of String in Java.
	 */ 
	/*public static String permutation(String input) {
		return permutation("", input);
	}*/

	/*
	 * * Recursive method which actually prints all permutations * of given
	 * String, but since we are passing an empty String * as current permutation
	 * to start with, * I have made this method private and didn't exposed it to
	 * client.
	 */
	/*private static String permutation(String perm, String word) {
		if (word.isEmpty() || j > k) {
			System.err.println(perm + word);
			return (perm + word);
		} else {
			j++;
			for (int i = 0; i < word.length(); i++) {
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
		return null;
	}*/

}
