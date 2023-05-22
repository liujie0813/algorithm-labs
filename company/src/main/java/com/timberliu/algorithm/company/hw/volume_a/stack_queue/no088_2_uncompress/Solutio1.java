package com.timberliu.algorithm.company.hw.volume_a.stack_queue.no088_2_uncompress;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 88. 解压缩算法
 *
 *  看到 {} 就想到栈
 *
 * @author liujie
 * @date 2023/4/19
 */

public class Solutio1 {

	public static String uncompress(String str) {
		Deque<String> stack = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '{') {
				stack.push("{");
			} else if (ch == '}') {
				if (Character.isDigit(str.charAt(i + 1))) {
					// 次数
					int index = i + 1;
					while (index < str.length() && Character.isDigit(str.charAt(index))) {
						index++;
					}
					int cnt = Integer.parseInt(str.substring(i + 1, index));
					// 字符
					StringBuilder sb = new StringBuilder();
					while (!stack.isEmpty() && !"{".equals(stack.peek())) {
						sb.append(stack.pop());
					}
					stack.pop();
					// 重复 n 次
					stack.push(repeat(sb.toString(), cnt));
					i = index - 1;
				}
			} else if (Character.isAlphabetic(ch)) {
				if (Character.isDigit(str.charAt(i + 1))) {
					int index = i + 1;
					while (index < str.length() && Character.isDigit(str.charAt(index))) {
						index++;
					}
					int cnt = Integer.parseInt(str.substring(i + 1, index));
					// 重复 n 次
					stack.push(repeat(ch + "", cnt));
					i = index - 1;
				} else {
					stack.push(ch + "");
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		String str0 = sb.toString();
		StringBuilder res = new StringBuilder();
		for (int i = sb.length() - 1; i >= 0; i--) {
			res.append(str0.charAt(i));
		}
		return res.toString();
	}

	private static String repeat(String str, int cnt) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * {A3B1{C}3}3D3
	 *
	 * {{ABC}3}2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String re = uncompress(str);
		System.out.println(re);
	}

}
