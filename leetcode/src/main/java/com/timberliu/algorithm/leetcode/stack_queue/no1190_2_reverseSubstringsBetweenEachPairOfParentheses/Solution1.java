package com.timberliu.algorithm.leetcode.stack_queue.no1190_2_reverseSubstringsBetweenEachPairOfParentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 *
 */

public class Solution1 {

    public static String reverseParentheses(String str) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != ')') {
				stack.push(ch);
			} else {
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				for (int j = 0; j < sb.length(); j++) {
					stack.push(sb.charAt(j));
				}
			}
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pollLast());
		}
		return res.toString();
    }

    public static void main(String[] args) {
		String res1 = reverseParentheses("(abcd)");
		System.out.println(res1);

		String res2 = reverseParentheses("(u(love)i)");
		System.out.println(res2);

		String res3 = reverseParentheses("(ed(et(oc))el)");
		System.out.println(res3);

	}

}