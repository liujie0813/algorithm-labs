package com.timberliu.algorithm.basic.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 基于数组实现，支持动态扩容
 *
 * @author liujie
 * @date 2021/9/7
 */

public class ArrayStack<E> implements Stack<E> {

	private E[] data;
	private int capacity;
	private int size;

	public ArrayStack() {
		this(16);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void push(E e) {
		if (size == capacity) {
			// 扩容为 2 倍
			resize(2 * capacity);
		}
		data[size] = e;
		size++;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E top = data[--size];
		data[size] = null;

		// 容量 1/4 时，缩容为原来的 1/2，防止频繁扩容缩容
		if(size / 2 != 0 && size == capacity / 4) {
			resize(capacity / 2);
		}
		return top;
	}

	@Override
	public E peek() {
		return data[size - 1];
	}

	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		// 无泛型数组，申请 Object 数组转为泛型
		E[] newData = (E[]) new Object[newCapacity];
		if (size >= 0) {
			System.arraycopy(data, 0, newData, 0, size);
		}
		data = newData;
		capacity = newCapacity;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		};
		System.out.println(stack.pop());
		System.out.println(stack.peek());

		int[] ints = nextGreaterElement(new int[]{1, 5, 2, 8, 3, 6, 4});
		System.out.println(Arrays.toString(ints));
	}

	public static int[] nextGreaterElement(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
				int top = stack.pop();
				res[top] = nums[i];
			}
			stack.push(i);
		}
		return res;
	}
}
