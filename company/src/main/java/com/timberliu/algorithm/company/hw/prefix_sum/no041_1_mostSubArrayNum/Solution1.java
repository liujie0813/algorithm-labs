package com.timberliu.algorithm.company.hw.prefix_sum.no041_1_mostSubArrayNum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 41. 最多等和不相交连续子序列
 *
 * @author Timber
 * @date 2023/4/25
 */
public class Solution1 {

	public static int mostSubArrayNum(int[] arr) {
		int[] prefixSum = new int[arr.length + 1];
		int res = 1;
		Map<Integer, Integer> sumCntMap = new HashMap<>();
		Map<Integer, Integer> lastPosMap = new HashMap<>();
		// 外层控制右边界
		for (int i = 0; i < arr.length; i++) {
			prefixSum[i + 1] = prefixSum[i] + arr[i];
			// 内层控制左边界
			for (int j = 0; j <= i; j++) {
				int val = prefixSum[i + 1] - prefixSum[j];
				// 上一个等和子序列的 lastPos 小于 j（当前子序列的第一个下标），即不相交
				if (!lastPosMap.containsKey(val) || lastPosMap.getOrDefault(val, 0) < j) {
					// 设置新的 lastPos 为 i（当前子序列的最后一个下标）
					lastPosMap.put(val, i);
					int newCnt = sumCntMap.getOrDefault(val, 0) + 1;
					sumCntMap.put(val, newCnt);
					res = Math.max(res, newCnt);
				}
			}
		}
		return res;
	}

	/*
	 * 10
	 * 8 8 9 1 9 6 3 9 1 0
	 */
	/**
	 * 10
	 * -1 0 4 -3 6 5 -6 5 -7 -3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int res = mostSubArrayNum(arr);
		System.out.println(res);
	}

}
