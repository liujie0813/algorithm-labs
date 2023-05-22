package com.timberliu.algorithm.company.hw.volume_a.dp.no131_2_maxSatisfaction;

import java.util.Scanner;

/**
 * 130. 购物单
 *
 *  dp[i][j]：考虑前 i 个物品，预算不超过 j 的情况下的 最大满意度
 *
 *  五种情况:
 *  - 不买
 *  - 买主件
 *  - 买主件 + 附件1
 *  - 买主件 + 附件2
 *  - 买主件 + 附件1 + 附件2
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int maxSatisfaction(int money, int[][] arr, int n) {
		int[][] prices = new int[n + 1][3];
		int[][] values = new int[n + 1][3];
		for (int i = 0; i < n; i++) {
			int price = arr[i][0];
			int value = arr[i][1];
			if (arr[i][2] == 0) {
				prices[i + 1][0] = price;
				values[i + 1][0] = price * value;
			} else {
				int main = arr[i][2];
				if (prices[main][1] == 0) {
					prices[main][1] = price;
					values[main][1] = price * value;
				} else {
					prices[main][2] = price;
					values[main][2] = price * value;
				}
			}
		}

		int[][] dp = new int[n + 1][money + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= money; j++) {
				// 不买
				dp[i][j] = dp[i - 1][j];
				// 买主件
				if (prices[i][0] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices[i][0]] + values[i][0]);
				}
				// 买主件 + 附件1
				if (prices[i][0] + prices[i][1] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices[i][0] - prices[i][1]] + values[i][0] + values[i][1]);
				}
				// 买主件 + 附件2
				if (prices[i][0] + prices[i][2] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices[i][0] - prices[i][2]] + values[i][0] + values[i][2]);
				}
				// 买主件 + 附件1 + 附件2
				if (prices[i][0] + prices[i][1] + prices[i][2] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices[i][0] - prices[i][1] - prices[i][2]] + values[i][0] + values[i][1] + values[i][2]);
				}
			}
		}
		return dp[n][money];
	}

	/**
	 * 50 5
	 * 20 3 5
	 * 20 3 5
	 * 10 3 0
	 * 10 2 0
	 * 10 1 0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
			arr[i][2] = scanner.nextInt();
		}

		int res = maxSatisfaction(money, arr, 5);
		System.out.println(res);
	}

}
