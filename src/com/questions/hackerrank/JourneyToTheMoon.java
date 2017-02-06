package com.questions.hackerrank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JourneyToTheMoon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		int count = 0;
		List<List<Integer>> l = new ArrayList<>();
		for(int j = 0; j < i; j++){
			List<Integer> r = new ArrayList<>();
			int a = sc.nextInt();
			r.add(a);
			int b = sc.nextInt();
			r.add(b);
			l.add(r);
		}
		int listSize = l.size();
		for(int j = 0; j < listSize; j++){
			List<Integer> in = l.get(j);
			for(int k = j+1; k <  listSize; k++){
				List<Integer> out = l.get(k);
				count = count + (in.size() * out.size()); 
			}
		}
		System.out.println(count);
	}

}
