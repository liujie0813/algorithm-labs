package com.timberliu.algorithm.cracking.module16.no26_2_calculator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 16.26. 计算器
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution1 {

	public static int calculate(String s) {
		// 操作符
		Deque<Character> operator = new LinkedList<>();
		// 操作数
		Deque<Integer> operand = new LinkedList<>();
		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			if (c == ' ') {
				// 空格跳过
				i++;
			} else if (c >= '0' && c <= '9') {
				// 提取数字，可能有多位
				int val = 0;
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				operand.push(val);
			} else {
				// 运算符 优先级没有前者高，就计算前者
				while (!operator.isEmpty() && !prority(s.charAt(i), operator.peek())) {
					calc(operator, operand);
				}
				// 到这里，前面的运算符 优先级低于 当前
				operator.push(s.charAt(i));
				i++;
			}
		}
		while (!operator.isEmpty()) {
			calc(operator, operand);
		}
		return operand.pop();
	}

	private static boolean prority(char first, char second) {
		if (first == '+' || first == '-') {
			return false;
		} else if (first == '*' || first == '/') {
			return second == '+' || second == '-';
		}
		return false;
	}

	private static void calc(Deque<Character> operator, Deque<Integer> operand) {
		Integer second = operand.pop();
		Integer first = operand.pop();
		Character c = operator.pop();
		int res = 0;
		switch (c) {
			case '+':
				res = first + second;
				break;
			case '-':
				res = first - second;
				break;
			case '*':
				res = first * second;
				break;
			case '/':
				res = first / second;
				break;
		}
		operand.push(res);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/calculator-lcci/ -----");
		System.out.println("----- 1 -----");
		System.out.println(calculate("3+2*2"));

		System.out.println("----- 2 -----");
		System.out.println(calculate(" 3+5 / 2 "));

		System.out.println("----- 3 -----");
		System.out.println(calculate("3*4 + 5*9/2 + 3"));

		System.out.println("----- 4 -----");
		System.out.println(calculate("10*4 + 5*9/15 + 3"));

	}

}
