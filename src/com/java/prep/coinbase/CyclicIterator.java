package com.java.prep.coinbase;

class CyclicIterator<T> extends CustomIterator<T> {

	private CustomIterator<T> customIterator;
	private int currentIndex;

	public CyclicIterator(CustomIterator<T> customIterator) {
		super(customIterator.getArray());
		this.customIterator = customIterator;
	}

	@Override
	public int incrementIndex() {
		return this.customIterator.incrementIndex();
	}

	@Override
	public boolean checkIfCurrentIndexExists(T[] array) {
		if (currentIndex > getSize()) {
			System.out.println("End of Data! Resetting the index");
			try {
				Thread.sleep(5000L);
			} catch (Exception e) {
				System.err.println("Error");
			}
			currentIndex = 0;
		}
		return true;
	}

	@Override
	public T getElementAtIndex(T[] array) {
		return this.customIterator.getElementAtIndex(array);
	}

	@Override
	public int getSize() {
		return this.customIterator.getSize();
	}

}