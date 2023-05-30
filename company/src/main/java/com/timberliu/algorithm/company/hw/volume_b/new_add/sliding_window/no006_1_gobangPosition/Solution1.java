package com.timberliu.algorithm.company.hw.volume_b.new_add.sliding_window.no006_1_gobangPosition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6. 五子棋迷
 *
 *   滑动窗口（双指针）
 *    1. 如何更新左边界
 *    2. 如何更新右边界
 *    3. 如何更新结果
 *
 * @author liujie
 * @date 2023/5/24
 */

public class Solution1 {

	public static int gobangPosition(int[] arr, int val) {
		int[] count = new int[3];
		int mid = (arr.length - 1) / 2;
		int res = 0;
		int maxLen = 0;

		int lastPos = 0;
		int left = 0, right = 0;
		while (right < arr.length) {
			count[arr[right] + 1]++;
			// 对手的子、窗口大于5、0 的个数大于1
			while (arr[left] == -val || right - left + 1 > 5 || count[arr[1]] > 1) {
				count[arr[left] + 1]--;
				left++;
			}
			if (arr[right] == -val) {
				left = ++right;
				count = new int[3];
				continue;
			}
			if (arr[right] == 0) {
				lastPos = right;
			}
			// 更新 res、maxLen
			if (right - left + 1 > maxLen) {
				res = lastPos;
				maxLen = right - left + 1;
			} else if (right - left + 1 == maxLen) {
				if (Math.abs(lastPos - mid) < Math.abs(res - mid)) {
					res = lastPos;
				}
			}
			right++;
		}
		return res;
	}

	/*
	 * 1
	 * -1 0 1 1 1 0 1 0 1 -1 1
	 */
	/*
	 * -1
	 * -1 0 1 1 1 0 1 0 1 -1 1
	 */
	/**
	 * 1
	 * 0 0 0 0 1 0 0 0 0 1 0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int val = Integer.parseInt(scanner.nextLine());
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();

		int res = gobangPosition(arr, val);
		System.out.println(res);
	}

}
