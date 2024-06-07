package com.timberliu.algorithm.basic.heap;

import java.util.Comparator;

/**
 * @author liujie
 * @date 2024/6/7
 */

public class Heap<T> {

	private T[] data;
	private Comparator<T> comparator;
	private int size;
	private int capacity;

	public Heap(Comparator<T> comparator) {
		this.comparator = comparator;
		this.capacity = 16;
		this.data = (T[]) new Object[capacity + 1];
		this.size = 0;
	}

	public void offer(T t) {
		if (size == capacity) {
			resize(2 * capacity + 1);
		}
		data[++size] = t;
		swim(size);
	}

	public T poll() {
		T res = data[1];
		data[1] = data[size];
		data[size] = null;
		size--;
		sink(1);
		if (capacity / 2 >= 16 && capacity / 4 == size) {
			resize(capacity / 2 + 1);
		}
		return res;
	}

	private void sink(int k) {
		while (k * 2 <= size) {
			int j = k * 2 + 1;
			if (j + 1 <= size && less(j, j + 1)) {
				j++;
			}
			if (less(k, j)) {
				break;
			}
			swap(k, j);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			swap(k / 2, k);
			k /= 2;
		}
	}

	private boolean less(int i, int j) {
		return comparator.compare(data[i], data[j]) < 0;
	}

	private void swap(int i, int j) {
		T tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	private void resize(int newCapacity) {
		T[] newPq = (T[]) new Object[newCapacity];
		for (int i = 1; i <= capacity; i++) {
			newPq[i] = data[i];
		}
		data = newPq;
	}



}
