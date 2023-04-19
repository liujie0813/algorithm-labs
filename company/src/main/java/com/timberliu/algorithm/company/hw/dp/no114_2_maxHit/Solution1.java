package com.timberliu.algorithm.company.hw.dp.no114_2_maxHit;

import java.util.Scanner;

/**
 * 114. 大炮攻城
 *
 *  大炮看做物品，消耗的火药看做物品的体积
 *  攻城时间 / 填充火药的时间，看做物品的个数
 *  大炮的威力看做物品价值
 *  给予城池最大的打击看做最大价值
 *
 *  不同种类大炮可以同时开火 >>> 每个物品看做多个(totalTime/time[i])，只需要考虑背包容量，不需要考虑总时间
 *  如果大炮不能同时开火，则容量考虑两个维度
 *
 *  完全背包问题
 *
 *  dp[i][j]：考虑前 i 个大炮，在给定火药数量 j 限制下，给予城池最大的打击
 *
 *  dp[i][j] = max(dp[i - 1][j][k], dp[i - 1][j - k * consume[i]] + k * power[i])
 *             0 <= k <= totalTime/time[i]
 *
 *  初始化：
 *   dp[0][i][j] = 0
 *
 * @author liujie
 * @date 2023/4/12
 */

public class Solution1 {

	public static int maxHit(int[] consume, int[] time, int totalConsume, int totalTime, int[] power) {
		int n = consume.length;
		int[][] dp = new int[n + 1][totalConsume + 1];
		// 遍历物品
		for (int i = 1; i <= n; i++) {
			// 物品体积、物品价值
			int c = consume[i - 1], p = power[i - 1];
			// 物品数量
			int limit = totalTime / time[i - 1];
			// 遍历容量
			for (int j = 0; j <= totalConsume; j++) {
				// 遍历物品数量
				for (int k = 0; k <= limit && k * c <= j; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * c] + k * p);
				}
			}
		}
		return dp[n][totalConsume];
	}

	/**
	 * 如果不能同时开火
	 */
	public static int maxHit2(int[] consume, int[] time, int totalConsume, int totalTime, int[] power) {
		int n = consume.length;
		int[][][] dp = new int[n + 1][totalConsume + 1][totalTime + 1];
		// 遍历物品
		for (int i = 1; i <= n; i++) {
			// 物品体积、物品价值
			int c = consume[i - 1], t = time[i - 1], p = power[i - 1];
			// 遍历容量1：火药
			for (int j = 0; j <= totalConsume; j++) {
				// 遍历容量2：时间
				for (int k = 0; k <= totalTime; k++) {
					// 物品数量
					int limit = k / t;
					// 遍历物品数量
					for (int l = 0; l <= limit && l * c <= j; l++) {
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - l * c][k - l * t] + l * p);
					}
				}
			}
		}
		return dp[n][totalConsume][totalTime];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int totalConsume = scanner.nextInt();
		int totalTime = scanner.nextInt();
		int[] power = new int[n];
		int[] consume = new int[n];
		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			power[i] = scanner.nextInt();
			consume[i] = scanner.nextInt();
			time[i] = scanner.nextInt();
		}

		int res = maxHit2(consume, time, totalConsume, totalTime, power);
		System.out.println(res);
	}

}
