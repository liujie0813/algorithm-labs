package com.timberliu.algorithm.company.hw.volume_a.dp.no030_1_mostMsgNum;

import java.util.Scanner;

/**
 * 31. 最多获得的短信条数
 *
 *  物品- 充值
 *  体积- 售价
 *  价值- 短信条数
 *
 *  限定容量- 预算
 *
 *  最大价值
 *
 * @author Timber
 * @date 2023/4/25
 */
public class Solution1 {

	public static int maxMsgSum(int[] arr, int m) {
		int[] dp = new int[m + 1];
		for (int i = 1; i <= arr.length; i++) {
			for (int j = i; j <= m; j++) {
				dp[j] = Math.max(dp[j], dp[j - i] + arr[i - 1]);
			}
		}
		return dp[m];
	}

	/*
	 * 6
	 * 10 20 30 40 60
	 */
	/**
	 * 15
	 * 10 20 30 40 60 60 70 80 90 150
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = Integer.parseInt(scanner.nextLine());
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		int res = maxMsgSum(arr, m);
		System.out.println(res);
	}

}
