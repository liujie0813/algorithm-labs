package com.timberliu.algorithm.leetcode.stack_queue.no0020_1_validParentheses.related.no0678_2_validParenthesisString;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 678. 有效的括号字符串
 *
 *  使用两个栈，一个存储 (，一个存储 *，栈中存储索引 i
 *
 * @author Timber
 * @date 2021/9/12
 */
public class Solution1 {

	public static boolean checkValidString(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		Deque<Integer> stack = new LinkedList<>();
		Deque<Integer> stack2 = new LinkedList<>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else if (c == '*') {
				stack2.push(i);
			} else {
				if (stack.isEmpty() && stack2.isEmpty()) {
					return false;
				} else if (!stack.isEmpty()) {
					stack.pop();
				} else {
					stack2.pop();
				}
			}
		}
		while (!stack2.isEmpty() && !stack.isEmpty()) {
			if (stack.peek() > stack2.peek()) {
				return false;
			}
			stack2.pop();
			stack.pop();
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/valid-parenthesis-string/ -----");
		System.out.println("----- 1 -----");
		System.out.println(checkValidString("()"));

		System.out.println("----- 2 -----");
		System.out.println(checkValidString("(*)"));

		System.out.println("----- 3 -----");
		System.out.println(checkValidString("(*))"));

		System.out.println("----- 4 -----");
		System.out.println(checkValidString("(((**)"));

		System.out.println("----- 5 -----");
		System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));


	}
}
