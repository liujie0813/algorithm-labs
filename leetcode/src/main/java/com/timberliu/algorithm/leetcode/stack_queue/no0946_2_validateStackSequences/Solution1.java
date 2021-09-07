package com.timberliu.algorithm.leetcode.stack_queue.no0946_2_validateStackSequences;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 946. 验证栈序列
 *
 *  栈的模拟操作
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution1 {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Deque<Integer> stack = new LinkedList<>();
		int index = 0;
		for (int i : pushed) {
			stack.push(i);
			while (!stack.isEmpty() && index < popped.length && stack.peek() == popped[index++]) {
				stack.pop();
			}
		}
		return index == popped.length;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/validate-stack-sequences/ -----");
		System.out.println("----- 1 -----");
		System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));

		System.out.println("----- 2 -----");
		System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));

		System.out.println("----- 3 -----");
		System.out.println(validateStackSequences(new int[]{2,1,0}, new int[]{1,2,0}));

	}
}
