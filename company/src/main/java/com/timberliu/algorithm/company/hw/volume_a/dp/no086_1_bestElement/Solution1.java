package com.timberliu.algorithm.company.hw.volume_a.dp.no086_1_bestElement;

import java.util.Scanner;

/**
 * 86. 查找充电设备组合
 *
 *  01 背包问题：
 *   物品：充电设备
 *   体积：功率
 *   价值：功率
 *   背包容量：最大功率
 *
 *   最大价值 - 最大功率
 *
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int bestPower(int n, int[] power, int maxPower) {
		int[] dp = new int[maxPower + 1];
		for (int i = 0; i < n; i++) {
			// 01 背包 容量维度，遍历需要倒序
			for (int j = maxPower; j >= power[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - power[i]] + power[i]);
			}
		}
		return dp[maxPower];
	}

	/**
	 * 4
	 * 50 20 20 60
	 * 90
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] power = new int[n];
		for (int i = 0; i < n; i++) {
			power[i] = scanner.nextInt();
		}
		int maxPower = scanner.nextInt();

		int res = bestPower(n, power, maxPower);
		System.out.println(res);
	}

}
