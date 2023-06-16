package com.timberliu.algorithm.company.hw.exercise.no03.no100_1_bestTimeArea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 100. 查找接口成功率最优时间段
 *
 *   1. 滑动窗口
 *   2. 前缀和 + 遍历所有子区间
 *
 * @author liujie
 * @date 2023/6/16
 */

public class Solution1 {

	public static List<String> bestTimeArea(int[] arr, int minAvgLost) {
		int left = 0, right = 0;
		int sum = 0;
		int max = 0;
		List<String> res = new ArrayList<>();
		while (right < arr.length) {
			sum += arr[right];
			int len = right - left + 1;
			if (sum <= len * minAvgLost) {
				if (len > max) {
					max = len;
					res.clear();
					res.add(left + "-" + right);
				} else if (len == max) {
					res.add(left + "-" + right);
				}
			}
			while (sum > (right - left + 1) * minAvgLost) {
				sum -= arr[left];
				left++;
			}
			right++;
		}
		return res;
	}

	/**
	 * 1
	 * 0 1 2 3 4
	 */
	/**
	 * 2
	 * 0 0 100 2 2 99 0 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int minAvgLost = Integer.parseInt(scanner.nextLine());
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		List<String> res = bestTimeArea(arr, minAvgLost);
		if (res.isEmpty()) {
			System.out.println("NULL");
			return;
		}
		for (String val : res) {
			System.out.print(val + " ");
		}
	}

}
