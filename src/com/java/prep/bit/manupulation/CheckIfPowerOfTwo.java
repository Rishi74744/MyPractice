package com.java.prep.bit.manupulation;

public class CheckIfPowerOfTwo {

	public boolean isPowerOfTwo(int x) {
		return x > 0 && (x & (x - 1)) == 0;
	}

}
