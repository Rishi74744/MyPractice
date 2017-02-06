package com.questions.hackerrank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Gemstones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer,List<String>> m1 = new HashMap<Integer, List<String>>();
		for(int i = 1; i <= n; i++){
			String s = sc.next();
			String arr[] = s.split("");
			List<String> l = Arrays.asList(arr);
			m1.put(i, l);
		}
		Set<String> intersection = new HashSet<>(m1.get(1));
		for(Map.Entry<Integer, List<String>> e : m1.entrySet()){
			Set<String> newIntersection = new HashSet<>();
			for(String s: e.getValue()){
				if(intersection.contains(s)){
					newIntersection.add(s);
				}
			}
			intersection = newIntersection;
		}
		System.out.println(intersection.size());
	}

}
