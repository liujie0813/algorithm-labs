package com.timberliu.algorithm.company.hw.dp.no127_1_minTime;

import java.util.Scanner;

/**
 * 127. 机智的外卖员
 *
 *  dp[i]：到达第 i 层需要的最短时间
 *
 *  推导：
 *   1. cur > i，dp[i] = cur - i
 *
 *   1. 偶数层：dp[i] = min( dp[i-1]+1, dp[i/2]+1 )
 *   2. 奇数层：dp[i] = min( dp[i-1]+1, dp[(i+1)/2]+2 )
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int minTime(int cur, int target) {
		int[] dp = new int[target + 1];
		for (int i = 0; i <= cur; i++) {
			dp[i] = cur - i;
		}
		for (int i = cur + 1; i <= target; i++) {
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
			} else {
				dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cur = scanner.nextInt();
		int target = scanner.nextInt();
		if (cur >= target) {
			System.out.println(0);
			return;
		}
		int res = minTime(cur, target);
		System.out.println(res);
	}

}
