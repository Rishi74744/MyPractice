package com.java7;

import java.util.Iterator;

class NextElement<T> {
	private int nextIndex;
	private T element;

	public NextElement(int nextIndex, T element) {
		super();
		this.nextIndex = nextIndex;
		this.element = element;
	}

	public int getNextIndex() {
		return nextIndex;
	}

	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}

interface IteratorNext<T> {

	public NextElement<T> next(T[] array, int currentIndex);

}

interface IteratorHasNext<T> {

	public boolean hasNext(T[] array, int currentIndex);

}

class CustomIterator<T> implements Iterable<T> {

	private T[] array;
	private int size;
	private IteratorNext<T> iteratorNext;
	private IteratorHasNext<T> iteratorHasNext;

	public CustomIterator(T[] array, IteratorNext<T> iteratorNext, IteratorHasNext<T> iteratorHasNext) {
		this.array = array;
		this.size = array.length;
		this.iteratorNext = iteratorNext;
		this.iteratorHasNext = iteratorHasNext;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return iteratorHasNext.hasNext(array, currentIndex);
			}

			@Override
			public T next() {
				NextElement<T> nextElement = iteratorNext.next(array, currentIndex);
				currentIndex = nextElement.getNextIndex();
				return nextElement.getElement();
			}
		};
		return iterator;
	}
}

public class Iterators {

	class AlternateIterator<T> implements Iterable<T> {

		private T[] array;
		private int size;

		public AlternateIterator(T[] array) {
			this.array = array;
			this.size = array.length;
		}

		@Override
		public Iterator<T> iterator() {
			Iterator<T> iterator = new Iterator<T>() {

				private int currentIndex = 0;

				@Override
				public boolean hasNext() {
					return currentIndex < size && array[currentIndex] != null;
				}

				@Override
				public T next() {
					T element = array[currentIndex];
					currentIndex += 2;
					return element;
				}
			};
			return iterator;
		}

	}

	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
		CustomIterator<Integer> customIterator = new CustomIterator<>(nums, (array, index) -> {
			return new NextElement<>(index + 2, array[index]);
		}, (array, index) -> {
			return index < array.length && array[index] != null;
		});
		System.out.println("<---------------Custom Iterator--------------->");
		for (Integer n : customIterator) {
			System.out.println(n);
		}
//		AlternateIterator<Integer> al = new Iterators().new AlternateIterator<Integer>(nums);
//		for (Integer n : al) {
//			System.out.println(n);
//		}
	}

}
