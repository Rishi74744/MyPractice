package com.java.prep.coinbase;

public interface CustomBaseIterator<T> {

	int incrementIndex();

	boolean checkIfCurrentIndexExists(T[] array);

	T getElementAtIndex(T[] array);

	int getSize();

}
