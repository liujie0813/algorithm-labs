package com.timberliu.algorithm.company.hw.volume_a.greedy.no091_1_minBoxNum;

import java.util.Scanner;

/**
 * 91. 机房布局
 *
 *   判断每个机柜
 *     1. 优先放右边；如果可以放，跳到 i+3
 *     2. 右边放不了，放左边；如果可以放，跳到 i+1
 *     3. 左右都放不了，返回 -1
 *
 * @author liujie
 * @date 2023/4/18
 */

public class Solution1 {

	public static int minBoxNum(String str) {
		int res = 0;
		for (int i = 0; i < str.length();) {
			if (str.charAt(i) == 'M') {
				if (i + 1 < str.length() && str.charAt(i + 1) == 'I') {
					// MIMI ：电箱放到 i+1 位置，i+2 位置不需要看了，直接跳到 i+3
					res++;
					i += 3;
				} else if (i > 0 && str.charAt(i - 1) == 'I') {
					// IMI : 电箱放到 i-1 位置，跳到下一个位置
					res++;
					i++;
				} else {
					res = -1;
					break;
				}
			}
		}
		return res;
	}


	/**
	 * MIM
	 *
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

	}

}
