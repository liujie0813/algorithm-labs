package com.timberliu.algorithm.company.hw.greedy.no068_2_soldierCrossRiver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 68. 士兵过河
 *
 *
 *  dp[i]：考虑前 i 个人过河所需的最短时间
 *
 *  推导：
 *   1. 前 i-1 个过河用时为 dp[i-1]
 *      a. 本岸新增了第 i 个人，此时应该让对岸第 0 个人划船回来（耗时 cost[0]）
 *      b. 再让本岸第 0 个人和第 i 个人一起划船过河（耗时 cost[i]）
 *   2. 前 i-2 个过河用时为 dp[i-2]
 *	    a. 本岸新增了第 i-1 和第 i 个人，此时应该让对岸第 0 个人划船回来（耗时 cost[0]）
 *	    b. 再让本岸第 i-1 个和第 i 个人一起划船过河（耗时 cost[i]）
 *	    c. 再让对岸最快的第 1 个人划船回来（耗时 cost[1]）
 *	    d. 再让本岸第 0 个人和第 1 个人一起划船过河（耗时 cost[1]）
 *
 *	初始化：
 *   dp[0]：第 0 个人过河，cost[0]
 *   dp[1]：第 0 个和第 1 个人过河，cost[1]
 *
 *  时间复杂度：O(n)
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution2 {

	public static int[] soldierCrossRiver(int[] cost, int n, int maxTime) {
		Arrays.sort(cost);

		int[] dp = new int[n];
		dp[0] = cost[0];
		if (dp[0] > maxTime) {
			return new int[]{0, 0};
		}
		dp[1] = minCost(cost[0], cost[1]);
		if (dp[1] > maxTime) {
			return new int[]{1, dp[0]};
		}

		for (int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[0] + minCost(cost[0], cost[i]),
					dp[i - 2] + cost[0] + minCost(cost[i - 1], cost[i]) + cost[1] + minCost(cost[0], cost[1]));
			if (dp[i] > maxTime) {
				return new int[]{i, dp[i - 1]};
			}
		}
		return new int[]{n, dp[n - 1]};
	}

	private static int minCost(int a, int b) {
		if (a * 10 < b) {
			return a * 10;
		}
		return Math.max(a, b);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int maxTime = scanner.nextInt();
		int[] cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = scanner.nextInt();
		}
		int[] res = soldierCrossRiver(cost, n, maxTime);
		System.out.println(res[0] + " " + res[1]);
	}

}
