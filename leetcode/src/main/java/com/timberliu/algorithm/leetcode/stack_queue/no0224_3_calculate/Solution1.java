package com.timberliu.algorithm.leetcode.stack_queue.no0224_3_calculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 *
 *  包括 +、-、(、) 运算符
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
				if (c == '(') {
					operator.push(c);
				} else if (c == ')') {
					// 如果括号内有运算，则进行计算
					// 只有 +/- 运算时，不需要循环计算，括号内必然只有一对
					if (!operator.isEmpty() && operator.peek() != '(') {
						cal(operator, nums);
					}
					// 最后弹出 ( 左括号
					operator.pop();
				} else {
					// 应对这种 (+、(- 情况
					if (index > 0 && s.charAt(index - 1) == '(') {
						nums.push(0);
					}
					// 把前面能计算的 先算了
					if (!operator.isEmpty() && operator.peek() != '(') {
						cal(operator, nums);
					}
					operator.push(c);
				}
				index++;
			}
		}
		if (!operator.isEmpty()) {
			cal(operator, nums);
		}
		return nums.pop();
	}

	private void cal(Deque<Character> operator, Deque<Integer> nums) {
		if (operator.isEmpty() || nums.size() < 2) {
			return;
		}
		int first = nums.pop();
		int second = nums.pop();
		Character ch = operator.pop();
		if (ch == '+') {
			nums.push(first + second);
		} else {
			nums.push(second - first);
		}
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.calculate("(1+(-4+5+2)-3)+(6+8)"));

		System.out.println(solution1.calculate(""));
	}

}
