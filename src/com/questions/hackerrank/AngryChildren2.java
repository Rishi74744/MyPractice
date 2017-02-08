package com.questions.hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AngryChildren2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger k = sc.nextBigInteger();
		BigInteger x = n;
		List<BigInteger> l = new ArrayList<>();
		while (!BigInteger.ZERO.equals(x)) {
			l.add(sc.nextBigInteger());
			x = x.subtract(BigInteger.ONE);
		}
		BigInteger unfairness = BigInteger.ZERO;
		Collections.sort(l);
		BigInteger i = k;

		for(BigInteger bigInt = BigInteger.ZERO; bigInt.compareTo(k) < 0; bigInt = bigInt.add(BigInteger.ONE)) {
			for(BigInteger bigInt1 = BigInteger.ZERO; bigInt1.compareTo(k) < 0; bigInt1 = bigInt1.add(BigInteger.ONE)) {
			      
			}
		}
		
		
		
		/*for (BigInteger b : l) {
			BigInteger j = k;
			for (BigInteger b1 : l.subList(i, k)) {
				if (!b.equals(b1) && b.compareTo(b1) < 0) {
					unfairness = unfairness.add(b.subtract(b1).abs());
				}
				j = j.subtract(BigInteger.ONE);
				if(BigInteger.ZERO.equals(j)){
					break;
				}
			}
			i = i.subtract(BigInteger.ONE);
			if(BigInteger.ZERO.equals(i)){
				break;
			}
		}*/
		System.out.println(unfairness);
	}
}
