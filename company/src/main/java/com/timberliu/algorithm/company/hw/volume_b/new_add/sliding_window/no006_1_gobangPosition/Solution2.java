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
 *   连续长度不能超过 5，方法有误
 *
 * @author liujie
 * @date 2023/5/24
 */

public class Solution2 {

	public static int gobangPosition(int[] arr, int val) {
		int maxLen = 0;
		int minDist = arr.length / 2;
		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				int leftIndex = i - 1;
				int leftCnt = 0;
				while (leftIndex >= 0 && arr[leftIndex] == val && leftCnt < 5) {
					leftCnt++;
					leftIndex--;
				}
				maxLen = Math.max(maxLen, leftCnt);

				int rightIndex = i + 1;
				int rightCnt = 0;
				while (rightIndex < arr.length && arr[rightIndex] == val && rightCnt < 5) {
					rightCnt++;
					rightIndex++;
				}
				maxLen = Math.max(maxLen, rightCnt);

				int totalCnt = leftCnt + rightCnt;
				if (totalCnt > 4) {
					continue;
				}

				int distToMid = Math.abs(i - arr.length / 2);
				if (totalCnt > maxLen || (totalCnt == maxLen && distToMid < minDist)) {
					maxLen = totalCnt;
					res = i;
					minDist = distToMid;
				}
			}
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
	/*
	 * 1
	 * 0 0 0 0 1 0 0 0 0 1 0
	 */
	/**
	 * 1
	 * 1 1 1 1 1 0 0 0 0 1 0
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
