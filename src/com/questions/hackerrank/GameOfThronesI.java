package com.questions.hackerrank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThronesI {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();
		String ans;
		Map<String, Integer> m1 = new HashMap<>();
		int i = 0;
		while (i != inputString.length()){
			int val = 1;
			String s = Character.toString(inputString.charAt(i));
			if(m1.containsKey(s)){
				val = m1.get(s);
				val++;
			}
			m1.put(s, val);
			i++;
		}
		int noOfOdds = 0;
		for(Map.Entry<String, Integer> e : m1.entrySet()){
			if(e.getValue() % 2 != 0){
				noOfOdds++;
			}
		}
		if(noOfOdds == 1 || noOfOdds == 0){
			ans = "YES";
		}else{
			ans = "NO";
		}
		System.out.println(ans);
		myScan.close();
	}

}
