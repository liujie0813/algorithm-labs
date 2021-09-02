package com.timberliu.algorithm.cracking.module03.no05_2_sortOfStacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Timber
 * @date 2021/9/2
 */
public class SortedStack1 {

	private Deque<Integer> stack;
	private Deque<Integer> tmpStack;

	public SortedStack1() {
		stack = new LinkedList<>();
		tmpStack = new LinkedList<>();
	}

	public void push(int val) {
		stack.push(val);
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		Integer minVal = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			Integer val = stack.pop();
			if (val < minVal) {
				minVal = val;
			}
			tmpStack.push(val);
		}
		while (!tmpStack.isEmpty()) {
			Integer val = tmpStack.pop();
			if (!minVal.equals(val)) {
				stack.push(val);
			}
		}
	}

	public int peek() {
		if (stack.isEmpty()) {
			return -1;
		}
		Integer minVal = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			Integer val = stack.pop();
			if (val < minVal) {
				minVal = val;
			}
			tmpStack.push(val);
		}
		while (!tmpStack.isEmpty()) {
			stack.push(tmpStack.pop());
		}
		return minVal;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/sort-of-stacks-lcci/ -----");
	}
}
