package com.java.prep.coinbase;

class RangeIterator extends CustomIterator<Integer> {

	static class Range {
		int start;
		int end;
		int incrementBy;

		public Range(int start, int end, int incrementBy) {
			this.start = start;
			this.end = end;
			this.incrementBy = incrementBy;
		}

	}

	private Range range;
	private int currentIndex;

	public RangeIterator(Range range) {
		super(null);
		this.range = range;
	}

	@Override
	public int incrementIndex() {
		currentIndex += range.incrementBy;
		return currentIndex;
	}

	@Override
	public boolean checkIfCurrentIndexExists(Integer[] array) {
		return currentIndex < range.end;
	}

	@Override
	public Integer getElementAtIndex(Integer[] array) {
		return currentIndex;
	}

	@Override
	public int getSize() {
		return range.end;
	}

}
