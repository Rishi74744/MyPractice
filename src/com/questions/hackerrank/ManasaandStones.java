package com.questions.hackerrank;

import java.util.Scanner;

public class ManasaandStones {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
		}
	}
	
	public static int calculateFinalValue(int a, int b, int n){
		int lastStone = 0;
		boolean turn = false;
		for(int i = 0; i < n-1; i++){
			if(!turn){
				lastStone += a;
			}else{
				lastStone += b;
			}
			turn = !turn;
		}
		return lastStone;
	}

}
