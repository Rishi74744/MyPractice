package com.questions.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FlippingTheMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            int n = sc.nextInt();
            int length = 2 * n;
            int a[][] = new int[length][length];
            for(int j = 0; j < length; j++){
            	for(int k = 0; k < length; k++){
            		a[j][k] = sc.nextInt();
            	}
            }
            List<Integer> array = new ArrayList<Integer>();
            for(int j = 0; j < length; j++){
            	for(int k = 0; k < length; k++){
            		array.add(a[j][k]);
            	}
            }
            System.out.println("Before"+array);
            Collections.sort(array);
            System.out.println("After"+array);
        }
	}

}
