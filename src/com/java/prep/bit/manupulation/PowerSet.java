package com.java.prep.bit.manupulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public List<String> AllPossibleStrings(String s) {
		List<String> result = new ArrayList<>();
		findPowerSet(s, "", result);
		return result;
	}

	public void findPowerSet(String s, String currentAns, List<String> result) {
		for (int i = 0; i < s.length(); i++) {
			result.add(currentAns + s.charAt(i));
			findPowerSet(s.substring(i + 1), currentAns + s.charAt(i), result);
		}
	}

	public static void main(String[] args) {
		PowerSet p = new PowerSet();
		System.out.println(p.AllPossibleStrings("abc"));
	}

}
