package com.timberliu.algorithm.leetcode.stack_queue.monotone_stack.no0402_2_removeKDigits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 *
 * 单调栈，栈顶元素大于当前元素时，弹出栈顶元素
 *
 *  注意：1、k>0时弹出；2、遍历完k仍>0，从后向前遍历弹出；3、输出元素时从栈底弹出拼接，去除前导0；
 *
 * @author liujie
 * @date 2024/9/20
 */

public class Solution1 {

	public String removeKdigits(String num, int k) {
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < num.length(); i++) {
			int c = num.charAt(i) - '0';
			while (!stack.isEmpty() && stack.peekLast() > c && k > 0) {
				stack.pollLast();
				k--;
			}
			stack.offerLast(c);
		}
		while (k-- > 0) {
			stack.pollLast();
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty() && stack.peekFirst() == 0) {
			stack.pollFirst();
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pollFirst());
		}
		return sb.toString().isEmpty() ? "0": sb.toString();
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.removeKdigits("1432219", 3));

		System.out.println(solution1.removeKdigits("12345678", 3));

		System.out.println(solution1.removeKdigits("10200", 1));

		System.out.println(solution1.removeKdigits("10", 2));

	}

}
