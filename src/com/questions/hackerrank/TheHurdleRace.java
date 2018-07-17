package com.questions.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheHurdleRace {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int max = 0;
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			l.add(scanner.nextInt());
		}
		Collections.sort(l);
		max = l.get(l.size() - 1);
		int diff = max - k;
		if (diff > 0) {
			System.out.println(diff);
		} else {
			System.out.println(0);
		}
	}

}
