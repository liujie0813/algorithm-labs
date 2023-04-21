package com.timberliu.algorithm.company.hw.double_pointer.no078_2_maxReceiveWater;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 78. 天然蓄水库
 *
 * @author Timber
 * @date 2023/4/20
 */
public class Solution1 {

	public static String maxReceiveWater(int[] arr) {
		// leftMax[i] 表示 i 左边的最高的山峰
		int[] leftMax = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
		}
		int[] rightMax = new int[arr.length];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i + 1]);
		}

		// 第 i 个山峰对应的水位线高度
		int[] waterLines = new int[arr.length];
		// 有哪些水位线
		Set<Integer> lineSet = new HashSet<>();
		for (int i = 1; i < arr.length - 1; i++) {
			// 第 i 个山峰可以存储多少水
			int water = Math.max(0, Math.min(leftMax[i], rightMax[i]) - arr[i]);
			if (water != 0) {
				waterLines[i] = water + arr[i];
				lineSet.add(waterLines[i]);
			}
		}

		// [left, right, water]
		int[] res = new int[3];
		for (Integer line : lineSet) {
			// 满足该水位线的最左侧山峰位置 left（第一个达到水位线的就是边界）
			int left = 0;
			while (waterLines[left] < line || arr[left] >= line) {
				left++;
			}
			// 满足该水位线的最右侧山峰位置 right
			int right = arr.length - 1;
			while (waterLines[right] < line || arr[right] >= line) {
				right--;
			}
			// 山峰 left-1, right+1 之间
			// 该水位线的总蓄水量
			int sum = 0;
			for (int i = left; i <= right; i++) {
				sum += Math.max(0, line - arr[i]);
			}
			// 最大蓄水量
			if (sum > res[2]) {
				res[0] = left - 1;
				res[1] = right + 1;
				res[2] = sum;
			// 蓄水量相同，选择边界山峰距离最短的
			} else if (sum == res[2]) {
				if (right - left + 1 < res[1] - res[0] - 1) {
					res[0] = left - 1;
					res[1] = right + 1;
				}
			}
		}
		if (res[2] == 0) {
			return "0";
		}
		return res[0] + " " + res[1] + ":" + res[2];
	}

	/**
	 * 1 9 6 2 5 4 9 3 7
	 *
	 * 10 9 10 6 2 5 4 9 3 7
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		String res = maxReceiveWater(arr);
		System.out.println(res);
	}

}
