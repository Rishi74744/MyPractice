package com.java.prep.coinbase;

class SkippingIterator<T> extends CustomIterator<T> {

	private int size;
	private int incrementBy;
	private int currentIndex;
	private int startIndex;

	public SkippingIterator(int startIndex, int incrementBy, T[] array) {
		super(array);
		this.size = array.length;
		this.incrementBy = incrementBy;
		this.currentIndex = startIndex;
		this.startIndex = startIndex;
	}

	@Override
	public int incrementIndex() {
		this.currentIndex += incrementBy;
		return this.currentIndex;
	}

	@Override
	public boolean checkIfCurrentIndexExists(T[] array) {
		return currentIndex < array.length && array[currentIndex] != null;
	}

	@Override
	public T getElementAtIndex(T[] array) {
		return array[currentIndex];
	}

	@Override
	public int getSize() {
		return size;
	}
	
	protected int getStartIndex() {
		return startIndex;
	}

	protected void resetCurrentIndex() {
		this.currentIndex = this.startIndex;
	}

}