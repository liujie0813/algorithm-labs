package com.timberliu.algorithm.cracking.module03.no05_2_sortOfStacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Timber
 * @date 2021/9/2
 */
public class SortedStack {

	private Deque<Integer> stack;
	private Deque<Integer> tmpStack;

	public SortedStack() {
		stack = new LinkedList<>();
		tmpStack = new LinkedList<>();
	}

	public void push(int val) {
		while (!stack.isEmpty() && stack.peek() < val) {
			tmpStack.push(stack.pop());
		}
		stack.push(val);
		while (!tmpStack.isEmpty()) {
			stack.push(tmpStack.pop());
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}

	public int peek() {
		if (stack.isEmpty()) {
			return -1;
		} else {
			return stack.peek();
		}
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/sort-of-stacks-lcci/ -----");
	}
}
