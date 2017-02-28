package com.questions.randomquestions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NthPermutation {
	public static boolean nextPermutation(int[] p) {
		int a = p.length - 2;
		while (a >= 0 && p[a] >= p[a + 1]) {
			a--;
		}
		if (a == -1) {
			return false;
		}
		int b = p.length - 1;
		while (p[b] <= p[a]) {
			b--;
		}
		int t = p[a];
		p[a] = p[b];
		p[b] = t;
		for (int i = a + 1, j = p.length - 1; i < j; i++, j--) {
			t = p[i];
			p[i] = p[j];
			p[j] = t;
		}
		return true;
	}

	private static BigInteger factorial(BigInteger i) {
		if (i.compareTo(BigInteger.ONE) <= 0) {
			return BigInteger.ONE;
		}
		BigInteger p = BigInteger.ONE;
		for (BigInteger j = BigInteger.ONE; j.compareTo(i)<=0; j=j.add(BigInteger.ONE)) {
			p = p.multiply(j);
		}
		return p;
	}

	public static String nThPermutation(List<String> in, BigInteger index) {
		if (in.size() == 1)
			return in.get(0);
		BigInteger N = BigInteger.valueOf(in.size());
		BigInteger residue = index;
		BigInteger noOfPerm = factorial(N.subtract(BigInteger.ONE));
		BigInteger outputIndex = BigInteger.ZERO;

		if (noOfPerm.compareTo(residue)<0) {
			outputIndex = residue.divide(noOfPerm);
			if (residue.mod(noOfPerm).compareTo(BigInteger.ZERO) == 0) {
				outputIndex = outputIndex.subtract(BigInteger.ONE);
			}
			BigInteger ins = outputIndex.multiply(noOfPerm);
			residue = residue.subtract((ins));
		}
		int counter = 0;
		BigInteger c = outputIndex;
		
		String indexDigit = in.get(outputIndex.intValue());
		in.remove(outputIndex);
		return indexDigit + nThPermutation(in, residue);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t != 0) {
			String s1 = input.next();
			String s2 = input.next();
			BigInteger k = input.nextBigInteger();
			StringBuilder s = new StringBuilder();
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (s2.indexOf(ch) < 0) {
					s.append(ch);
				}
			}
			String[] in1 = s.toString().split("");
			List<String> inp = new ArrayList<String>(Arrays.asList(in1));
			BigInteger permFact = factorial(k);
			if(k.compareTo(permFact)<=0){
				String perm = nThPermutation(inp, k);
				String permArr[] = perm.split("");
				int c = 0;
				int d = 0;
				s = new StringBuilder();
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (s1.indexOf(ch) < 0) {
						s.append(permArr[c]);
						c++;
					} else {
						s.append(s2.charAt(d));
						d++;
					}
				}
				System.out.println(s);
			}else{
				System.out.println("Not Possible");
			}
			t--;
		}
	}
}
