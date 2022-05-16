package com.java.prep.coinbase;

import java.util.List;

class InterleavingIterator<T> extends CustomIterator<T> {

	private List<CustomIterator<T>> iterators;
	private int currentIndex = 0;

	public InterleavingIterator(List<CustomIterator<T>> array) {
		super(null);
		this.iterators = array;
	}

	@Override
	public int incrementIndex() {
		return ++currentIndex;
	}

	@Override
	public boolean checkIfCurrentIndexExists(T[] array) {
		boolean hasNext = false;
		if (!(hasNext = checkForNext())) {
			incrementIndex();
			resetIndexIfRequired();
			int iteratorCount = 0;
			while (iteratorCount < getSize()) {
				iteratorCount++;
				if(!checkForNext()) {
					currentIndex++;
				} else {
					hasNext = true;
					break;
				}
				resetIndexIfRequired();
			}
			if(iteratorCount >= getSize()) {
				hasNext = false;
			}
		}
		return hasNext;
	}

	private boolean checkForNext() {
		return currentIndex < getSize() && iterators.get(currentIndex) != null && iterators.get(currentIndex).hasNext();
	}

	private boolean resetIndexIfRequired() {
		if (currentIndex >= getSize()) {
//			System.out.println("End of Data! Resetting the index");
			currentIndex = 0;
			return true;
		}
		return false;
	}

	@Override
	public T getElementAtIndex(T[] array) {
		return this.iterators.get(currentIndex).next();
	}

	@Override
	public int getSize() {
		return iterators.size();
	}

}
