package com.timberliu.algorithm.company.hw.volume_a.math.no048_1_plusMinusGame;

import java.util.Scanner;

/**
 * 48. 加减游戏
 * 
 *  a * x + b * y = t - s
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static int minPlusMinusCnt(int s, int t, int a, int b) {
		int cnt = 0;
		int diff = t - s;
		while (true) {
			if ((diff - a * cnt) % b == 0 || (diff + a * cnt) % b == 0) {
				return Math.abs(cnt);
			}
			cnt++;
		}
	}

	/*
	 * 1 10 5 2
	 */
	/**
	 * 11 33 4 10
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		int t = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int res = minPlusMinusCnt(s, t, a, b);
		System.out.println(res);
	}

}
