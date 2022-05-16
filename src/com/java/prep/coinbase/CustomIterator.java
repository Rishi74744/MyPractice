package com.java.prep.coinbase;

import java.util.Iterator;

abstract class CustomIterator<T> implements Iterator<T>, CustomBaseIterator<T> {

	private T[] array;

	public CustomIterator(T[] array) {
		this.array = array;
	}

	protected T[] getArray() {
		return this.array;
	}

	protected void setArray(T[] array) {
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		return checkIfCurrentIndexExists(array);
	}

	@Override
	public T next() {
		T element = getElementAtIndex(array);
		incrementIndex();
		return element;
	}

}
