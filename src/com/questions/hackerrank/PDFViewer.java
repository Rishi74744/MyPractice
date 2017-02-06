package com.questions.hackerrank;

import java.util.Scanner;

public class PDFViewer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        char[] wordArr = word.toCharArray();
        int maxValue = 0;
        for(int i=0 ; i<wordArr.length; i++){
        	int asciValue = wordArr[i] - 97;
        	if(maxValue < h[asciValue])
        		maxValue = h[asciValue];
        }
        int area = wordArr.length * 1 * maxValue;
        System.out.println(area);
	}

}
