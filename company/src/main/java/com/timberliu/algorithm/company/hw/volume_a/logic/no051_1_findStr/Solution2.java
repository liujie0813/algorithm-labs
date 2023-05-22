package com.timberliu.algorithm.company.hw.volume_a.logic.no051_1_findStr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 51. 密室逃生游戏
 *
 *  1 <= n <= 10000
 *  1 <= k.length <= 26
 *  0 <= s.length <= 50
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution2 {

	public static int findStr(String[] boxes, String key) {
		// key 本身为升序
		for (int i = 0; i < boxes.length; i++) {
			String box = boxes[i];
			// 去掉非大小写字母，并转换为小写
			char[] chars = box.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
			// 排序后比较
			Arrays.sort(chars);
			if (key.equals(new String(chars))) {
				return i + 1;
			}
		}
		return -1;
	}

	/*
	 * abc
	 * sdf134 A2c4b
	 */
	/**
	 * abc
	 * sddf134 A2c4bd 523[]
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String key = scanner.nextLine();
		String[] boxes = scanner.nextLine().split(" ");
		int res = findStr(boxes, key);
		System.out.println(res);

	}

}
