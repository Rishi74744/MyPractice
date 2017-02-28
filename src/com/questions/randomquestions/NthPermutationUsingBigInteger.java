package com.questions.randomquestions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NthPermutationUsingBigInteger {
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

	private static int factorial(int i) {
		if (i <= 1) {
			return 1;
		}
		int p = 1;
		for (int j = 1; j <= i; j++) {
			p *= j;
		}
		return p;
	}

	public static String nThPermutation(List<String> in, int index) {
		if (in.size() == 1)
			return in.get(0);
		int N = in.size();
		int residue = index;
		int noOfPerm = factorial(N - 1);
		int outputIndex = 0;

		if (noOfPerm < residue) {
			outputIndex = residue / noOfPerm;
			if (residue % noOfPerm == 0) {
				outputIndex--;
			}
			residue = residue - (outputIndex * noOfPerm);
		}
		String indexDigit = in.get(outputIndex);
		in.remove(outputIndex);
		return indexDigit + nThPermutation(in, residue);
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
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t != 0) {
			String s1 = input.next();
			String s2 = input.next();
			BigInteger k = input.nextBigInteger();
			if("".equals(s1.trim()) && "".equals(s2.trim())){
				System.out.println("");
			}else{
				StringBuilder s = new StringBuilder();
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (s2.indexOf(ch) < 0) {
						s.append(ch);
					}
				}
				String[] in1 = s.toString().split("");
				List<String> inp = new ArrayList<String>(Arrays.asList(in1));
				BigInteger permFact = factorial(BigInteger.valueOf(s.length()));
				if(k.compareTo(permFact)<=0){
					String perm = nThPermutation(inp,k.intValue());
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
			}
			t--;
		}
	}
}
