package com.timberliu.algorithm.leetcode.stack_queue.no0224_3_calculate.related.no0772_3_basicCalculatorIII;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 772. 基本计算器 III
 *
 *  包括 +、-、*、/、(、) 运算符
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution1 {

	private static Map<Character, Integer> priorityMap = new HashMap<Character, Integer>() {{
		put('(', 0);
		put('+', 1);
		put('-', 1);
		put('*', 2);
		put('/', 2);
		put(')', 3);
	}};

	public static int calculate(String s) {
		Deque<Character> operator = new LinkedList<>();
		Deque<Integer> operand = new LinkedList<>();
		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				// 提取多位的数字
				int val = 0;
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				operand.push(val);
			} else {
				if (c == '(') {
					operator.push(c);
				} else if (c == ')') {
					// if 应对 (1) 这种情况
					if (!operator.isEmpty() && operator.peek() != '(') {
						// 右括号：直接计算
						while (!operator.isEmpty() && operator.peek() != '(') {
							calc(operator, operand);
						}
					}
					operator.pop();
				} else {
					while (true) {
						Character topOperator = operator.peek();
						if (topOperator == null || priority(c, topOperator)) {
							operator.push(c);
							break;
						} else {
							calc(operator, operand);
						}
					}
				}
				i++;
			}
		}
		while (!operator.isEmpty()) {
			calc(operator, operand);
		}
		return operand.pop();
	}

	private static boolean priority(char a, char b) {
		if ((a == '*' || a == '/')
			&& (b == '+' || b == '-')) {
			return true;
		}
		if (b == '(') {
			return true;
		}
		return false;
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
		System.out.println("----- https://leetcode-cn.com/problems/basic-calculator-iii/ -----");
		System.out.println("----- 1 -----");
		System.out.println(calculate("1+1"));

		System.out.println("----- 2 -----");
		System.out.println(calculate("6-4/2"));

		System.out.println("----- 3 -----");
		System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));

		System.out.println("----- 4 -----");
		System.out.println(calculate("(2+6*3+5-(3*14/7+2)*5)+3"));

		System.out.println("----- 5 -----");
		System.out.println(calculate("0"));

		System.out.println("----- 6 -----");
		System.out.println(calculate("(1)"));

	}
}
