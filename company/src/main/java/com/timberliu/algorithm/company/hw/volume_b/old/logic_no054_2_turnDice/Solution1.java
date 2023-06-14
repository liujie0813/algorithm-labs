package com.timberliu.algorithm.company.hw.volume_b.old.logic_no054_2_turnDice;

import java.util.Scanner;

/**
 * 54. 转骰子
 *
 * @author liujie
 * @date 2023/6/13
 */

public class Solution1 {

	private static class Dice {
		int left = 1;
		int right = 2;
		int front = 3;
		int backend = 4;
		int top = 5;
		int bottom = 6;
	}

	public static String turnDice(String opers) {
		// 左右 前后 上下
		Dice dice = new Dice();

		for (char ch : opers.toCharArray()) {
			if (ch == 'L') {
				int tmp = dice.left;
				dice.left = dice.top;
				dice.top = dice.right;
				dice.right = dice.bottom;
				dice.bottom = tmp;
			} else if (ch == 'R') {
				int tmp = dice.right;
				dice.right = dice.top;
				dice.top = dice.left;
				dice.left = dice.bottom;
				dice.bottom = tmp;
			} else if (ch == 'F') {
				int tmp = dice.front;
				dice.front = dice.top;
				dice.top = dice.backend;
				dice.backend = dice.bottom;
				dice.bottom = tmp;
			} else if (ch == 'B') {
				int tmp = dice.front;
				dice.front = dice.bottom;
				dice.bottom = dice.backend;
				dice.backend = dice.top;
				dice.top = tmp;
			} else if (ch == 'A') {
				int tmp = dice.front;
				dice.front = dice.left;
				dice.left = dice.backend;
				dice.backend = dice.right;
				dice.right = tmp;
			} else if (ch == 'C') {
				int tmp = dice.front;
				dice.front = dice.right;
				dice.right = dice.backend;
				dice.backend = dice.left;
				dice.left = tmp;
			}
		}
		return "" + dice.left + dice.right + dice.front + dice.backend + dice.top + dice.bottom;
	}

	/*
	 * LR
	 */
	/**
	 * FCR
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		String res = turnDice(str);
		System.out.println(res);
	}

}
