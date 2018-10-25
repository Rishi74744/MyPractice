package com.java8.collections.customarraylist;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

public class MinimalArrayList<E> extends AbstractList<E> {

	transient Object[] elementData;

	private int size;

	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	private static final int DEFAULT_CAPACITY = 8;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	public MinimalArrayList() {
		this.elementData = EMPTY_ELEMENTDATA;
	}

	public MinimalArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity : " + initialCapacity);
		}
	}

	public MinimalArrayList(Collection<? extends E> c) {
		elementData = c.toArray();
		if ((size = elementData.length) != 0) {
			if (elementData.getClass() != Object[].class) {
				elementData = Arrays.copyOf(elementData, size, Object[].class);
			}
		} else {
			this.elementData = EMPTY_ELEMENTDATA;
		}
	}

	public boolean add(E e) {
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
		return true;
	}

	public void ensureCapacityInternal(int minCapacity) {
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;
		if (minCapacity - elementData.length > 0) {
			grow(minCapacity);
		}
	}

	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - oldCapacity < 0) {
			newCapacity = minCapacity;
		}
		if (newCapacity - MAX_ARRAY_SIZE > 0) {
			newCapacity = hugeCapacity(minCapacity);
		}
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) {
			throw new OutOfMemoryError();
		}
		return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index : " + index + " Size : " + size);
		}
		return (E) elementData[index];
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index : " + index + " Size : " + size);
		}
		modCount++;
		E oldValue = (E) elementData[index];
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;
		return oldValue;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null) {
					modCount++;
					int numMoved = size - i - 1;
					if (numMoved > 0) {
						System.arraycopy(elementData, i + 1, elementData, i, numMoved);
					}
					elementData[--size] = null;
					return false;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elementData[i])) {
					modCount++;
					int numMoved = size - i - 1;
					if (numMoved > 0) {
						System.arraycopy(elementData, i + 1, elementData, i, numMoved);
					}
					elementData[--size] = null;
					return false;
				}
			}
		}
		return false;
	}

}
