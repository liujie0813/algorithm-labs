package com.timberliu.algorithm.leetcode.stack_queue.no0224_3_calculate.related.no0227_2_baseCalculatorII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 *
 *  包括 +、-、*、/ 运算符
 *
 * @author liujie
 * @date 2024/9/19
 */

public class Solution1 {

	public int calculate(String s) {
		s = s.replaceAll(" ", "");
		Deque<Character> operator = new LinkedList<>();
		Deque<Integer> nums = new LinkedList<>();
		// 防止第一个 负数
		nums.push(0);
		int index = 0;
		while (index < s.length()) {
			char c = s.charAt(index);
			if (c >= '0' && c <= '9') {
				int num = 0;
				while (index < s.length() && (c = s.charAt(index)) >= '0' && c <= '9') {
					num = num * 10 + (c - '0');
					index++;
				}
				nums.push(num);
			} else {
				while (true) {
					Character op = operator.peek();
					if (op != null && !topPriority(c, op)) {
						calc(operator, nums);
					} else {
						operator.push(c);
						break;
					}
				}
				index++;
			}
		}
		while (!operator.isEmpty()) {
			calc(operator, nums);
		}
		return nums.pop();
	}

	private static boolean topPriority(char a, char b) {
		return (a == '*' || a == '/')
				&& (b == '+' || b == '-');
	}

	private static void calc(Deque<Character> operator, Deque<Integer> operand) {
		Character oper = operator.pop();
		Integer second = operand.pop();
		Integer first = operand.pop();
		int val = 0;
		switch (oper) {
			case '+':
				val = first + second;
				break;
			case '-':
				val = first - second;
				break;
			case '*':
				val = first * second;
				break;
			case '/':
				val = first / second;
				break;
		}
		operand.push(val);
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.calculate(" 3+5 / 2 "));

	}

}
