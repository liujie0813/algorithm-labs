package com.timberliu.algorithm.company.hw.no116_1_arraylimitNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 116. 数组限制数
 *
 *  O(nlogn)
 *
 * @author liujie
 * @date 2023/4/12
 */

public class Solution1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int total = scanner.nextInt();
		int[] nums = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
			sum += nums[i];
		}
		if (total >= sum) {
			System.out.println(-1);
			return;
		}
		// 12
		// 1 2 3 4 5

		// 3
		// 2 2 2 2 2
		Arrays.sort(nums);

		int res = 0;
		// 二分遍历（限制数）
		int left = total / n; // 0
		int right = nums[n - 1]; // 2
		while (left < right) {
			int limit = left + (right - left) / 2;
			// 计算总和
			int tmpTotal = sum;
			for (int num : nums) {
				tmpTotal -= (num < limit ? 0 : num - limit);
			}
			// 缩小范围
			if (tmpTotal == total) {
				res = limit;
				left = limit;
			} else if (tmpTotal < total) {
				res = limit;
				left = limit + 1;
			} else {
				right = limit - 1;
			}
		}
		System.out.println(res);
	}

}
