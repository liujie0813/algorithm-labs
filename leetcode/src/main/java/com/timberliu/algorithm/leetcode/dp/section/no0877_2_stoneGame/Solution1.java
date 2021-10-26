package com.timberliu.algorithm.leetcode.dp.section.no0877_2_stoneGame;

/**
 * 877. 石子游戏
 *
 *   状态定义：f[l][r] 考虑区间 [l, r]，双方最好选择，先手与后手的最大得分差值
 *
 *   f[1][n] 考虑所有石子，先手与后手的最大得分差值
 *
 *   f[l][r] 如何转移：
 *     1. 左 取石子，价值为 piles[l - 1]
 *          piles[l - 1] - f[l + 1][r]
 *     2. 右 取石子，价值为 piles[r - 1]
 *          piles[r - 1] - f[l][r - 1]
 *
 * @author Timber
 * @date 2021/10/27
 */
public class Solution1 {

	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		int[][] dp = new int[n + 2][n + 2];
		for (int len = 1; len <= n; len++) {
			for (int l = 1; l + len - 1 <= n; l++) {
				int r = l + len - 1;
				int a = piles[l - 1] - dp[l + 1][r];
				int b = piles[r - 1] - dp[l][r - 1];
				dp[l][r] = Math.max(a, b);
			}
		}
		return dp[1][n] > 0;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/stone-game/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.stoneGame(new int[]{5, 3, 4, 5}));

	}

}
