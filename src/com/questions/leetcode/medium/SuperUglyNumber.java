package com.questions.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SuperUglyNumber {

	List<Integer> uglyNumber = new ArrayList<>();
	int count = 1;

	public int nthSuperUglyNumber(int n, int[] primes) {
		uglyNumber.add(1);
		int num = 2;
		List<Integer> primeNums = Arrays.stream(primes).boxed().collect(Collectors.toList());
		while (count != n) {
			if (primeNums.contains(num)) {
				uglyNumber.add(num);
				count++;
			} else {
				checkIfUgly(num, primeNums);
			}
			num++;
		}
		return uglyNumber.get(uglyNumber.size() - 1);
	}

	public void checkIfUgly(int num, List<Integer> primeNums) {
		int c = 0;
		int n = num;
		while (c < primeNums.size()) {
			int prime = primeNums.get(c);
			if (num < prime) {
				return;
			}
			if (n % prime == 0) {
				n /= prime;
				if (uglyNumber.contains(n)) {
					uglyNumber.add(num);
					count++;
					return;
				}
			} else {
				c++;
			}
		}
		if (n < 0) {
			uglyNumber.add(num);
			count++;
		}
	}

	public static void main(String[] args) {
		int primes[] = { 2, 7, 13, 19 };
		SuperUglyNumber s = new SuperUglyNumber();
		System.out.println(s.nthSuperUglyNumber(12, primes));
	}
}
