package com.timberliu.algorithm.company.hw.priority_queue.no031_1_shortestBoardLen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 31. 最短木板长度
 *
 *  dp[i]：将所有木板补足到 arr[i] 长度，所需的木料长度
 *
 *  推导：
 *   dp[i] = dp[i - 1]  + (arr[i] - arr[i - 1]) * i
 *
 *  初始化：
 *   dp[0] = 0
 *
 * @author Timber
 * @date 2023/4/25
 */
public class Solution2 {

	public static int shortestBoardLen(int[] arr, int m) {
		int n = arr.length;
		Arrays.sort(arr);

		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			int need = (arr[i] - arr[i - 1]) * i;
			// 前 i 个木板不够补到 arr[i] 了
			// 剩余部分 m - dp[i-1] 均分给 i 个木板
			if (dp[n - 1] + need > m) {
				return (m - dp[i - 1]) / i + arr[i - 1];
			}
			dp[i] = dp[i - 1] + need;
		}
		int max = dp[n - 1];
		// 补到最大长度，还有剩余
		return (m - max) / n + arr[n - 1];
	}

	/*
	 * 5 3
	 * 4 5 3 5 5
	 */
	/**
	 * 5 2
	 * 4 5 3 5 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = shortestBoardLen(arr, m);
		System.out.println(res);
	}

}
