package com.timberliu.algorithm.company.hw.exercise.no01.no124_1_stringRemove;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/6/14
 */

public class Solution1 {

	public static String stringRemove(String str) {
		int cur = 0;
		int next = 1;
		boolean[] remove = new boolean[100];
		while (next < str.length()) {
			if (cur < 0) {
				cur = next;
				next++;
			} else if (str.charAt(cur) == str.charAt(next)) {
				remove[cur] = true;
				remove[next] = true;
				cur--;
				next++;
			} else {
				cur++;
				next++;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (!remove[i]) {
				res.append(str.charAt(i));
			}
		}
		return res.toString();
	}

	public static String stringRemove1(String str) {
		Deque<Character> deque = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (deque.isEmpty() || deque.peek() != ch) {
				deque.push(ch);
			} else {
				deque.pop();
			}
		}
		StringBuilder res = new StringBuilder();
		while (!deque.isEmpty()) {
			res.append(deque.pollLast());
		}
		return res.toString();
	}

	/*
	 * mMbccbc
	 */
	/**
	 * gg
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String res = stringRemove1(str);
		System.out.println(res);
	}

}
