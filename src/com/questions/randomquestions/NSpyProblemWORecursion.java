package com.questions.randomquestions;

import java.util.Scanner;


public class NSpyProblemWORecursion {
	int[] x;
	boolean isSol = false;
	public NSpyProblemWORecursion(int N) {
		x = new int[N];
	}

	public boolean canPlaceSpy(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (x[i] == c || (i - r) == (x[i] - c) || (i - r) == (c - x[i])) {
				return false;
			}
		}
		return true;
	}

	public void printSpyPos(int[] x) {
		int N = x.length;
		boolean isFirst = true;
		System.out.println(N);
		for (int i = 0; i < N; i++) {
			if(isFirst){
				System.out.print(x[i]+1);
				isFirst = false;
			}
			else{
				System.out.print(" "+(x[i]+1));
			}
		}
	}

	public void placeSpy(int r, int n) {
		for (int c = 0; c < n; c++) {
			if (canPlaceSpy(r, c) && !isSol) {
				x[r] = c;
				if (r == n - 1) {
					printSpyPos(x);
					isSol = true;
					return;
				} else {
					if(!isSol)
						placeSpy(r + 1, n);
					else
						return;
				}
			}
			if(isSol){
				break;
			}
		}
	}

	public void callplaceSpy() {
		placeSpy(0, x.length);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		NSpyProblemWORecursion Q = new NSpyProblemWORecursion(n);
		Q.callplaceSpy();

	}
}
