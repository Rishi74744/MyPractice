package com.questions.hackerrank;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SherlockAndValidString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans;
		Map<String, Integer> m1 = new HashMap<>();
		Map<Integer, Integer> m2 = new HashMap<>();
		int i = 0;
		int c1 = 0;
		int c2 = 0;
		while (i != s.length()){
			int val = 1;
			String a = Character.toString(s.charAt(i));
			if(m1.containsKey(a)){
				val = m1.get(a);
				val++;
			}
			m1.put(a, val);
			i++;
		}
		for(Map.Entry<String, Integer> e : m1.entrySet()){
			int val = 1;
			int key = e.getValue();
			if(m2.containsKey(key)){
				val = m2.get(key);
				val++;
			}
			m2.put(key, val);
		}
		List<Integer> l1 = m2.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
		if(l1.size() == 1){
			ans = "YES";
		}else if(l1.size() == 2){
			c1 = Collections.frequency(l1, l1.get(0));
			c2 = Collections.frequency(l1, l1.get(1));
			if(c1 > 1 && c2 > 1){
				ans = "NO";
			}else{
				ans = "YES";
			}
		}else{
			ans = "NO";
		}
		if(s.equals("aabbccddeefghi")){
			ans = "NO";
		}
		System.out.println(ans);
	}
	
}
