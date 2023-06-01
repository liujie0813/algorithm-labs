package com.timberliu.algorithm.company.hw.volume_b.new_add.sliding_window.no029_1_recoverDataSequence;

import java.util.Scanner;

/**
 * 29. 恢复数字序列
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	public static int recoverDataSequence(String str, int n) {
		int[] need = new int[10];
		for (int i = 0; i < str.length(); i++) {
			need[str.charAt(i) - '0']++;
		}
		int[] cur = new int[10];
		for (int i = 1; i < n; i++) {
			String s = String.valueOf(i);
			for (int j = 0; j < s.length(); j++) {
				cur[s.charAt(j) - '0']++;
			}
		}

		int left = 1;
		int right = n;
		while (true) {
			String rightStr = String.valueOf(right);
			for (int j = 0; j < rightStr.length(); j++) {
				cur[rightStr.charAt(j) - '0']++;
			}
			right++;
			boolean flag = true;
			for (int i = 0; i < 10; i++) {
				if (need[i] != cur[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				break;
			}
			String leftStr = String.valueOf(left);
			for (int j = 0; j < leftStr.length(); j++) {
				cur[leftStr.charAt(j) - '0']--;
			}
			left++;
		}
		return left;
	}

	/**
	 * 19801211 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		String str = splits[0];
		int n = Integer.parseInt(splits[1]);

		int res = recoverDataSequence(str, n);
		System.out.println(res);
	}

}
