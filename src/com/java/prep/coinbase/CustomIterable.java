package com.java.prep.coinbase;

class CustomIterable<T> implements Iterable<T> {

	private CustomIterator<T> iterator;

	public CustomIterable(CustomIterator<T> iterator) {
		this.iterator = iterator;
	}

	@Override
	public CustomIterator<T> iterator() {
		return iterator;
	}

}
