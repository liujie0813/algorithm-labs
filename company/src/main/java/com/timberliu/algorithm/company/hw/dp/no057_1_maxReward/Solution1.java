package com.timberliu.algorithm.company.hw.dp.no057_1_maxReward;

import java.util.Scanner;

/**
 * 57. 最大报酬
 *
 *  01 背包问题
 *
 *   物品-工作
 *   背包容量-工作总时长
 *   物品体积-某个工作消耗时长
 *   物品价值-工作报酬
 *
 *   最大报酬
 *
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static int maxReward(int[][] job, int totalTime) {
		int[] dp = new int[totalTime + 1];
		for (int i = 0; i < job.length; i++) {
			int time = job[i][0];
			int reward = job[i][1];
			for (int j = totalTime; j >= job[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j - time] + reward);
			}
		}
		return dp[totalTime];
	}

	/**
	 * 40 3
	 * 20 10
	 * 20 20
	 * 20 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalTime = scanner.nextInt();
		int jobNum = scanner.nextInt();
		int[][] job = new int[jobNum][2];
		for (int i = 0; i < jobNum; i++) {
			job[i][0] = scanner.nextInt();
			job[i][1] = scanner.nextInt();
		}

		int res = maxReward(job, totalTime);
		System.out.println(res);
	}

}
