package com.timberliu.algorithm.leetcode.dp.linear.no0045_2_jumpGameII;

/**
 * 45. 跳跃游戏 II
 *
 *  状态：f[i] 到达第 i 个位置所需要的最少步数是多少
 *
 *  状态转移方程：
 *      f[n-1] = min(f[n-k], ..., f[n-3], f[n-2]) + 1
 *              特性：f[n-k] <= ... <= f[n-3] <= f[n-2]
 *
 *      这里贪心的选取离 i 点最远的点 j 来更新 i，而找 j 的过程可以使用双指针来找
 *      f[i] = f[j] + 1
 *
 * @author Timber
 * @date 2021/10/18
 */
public class Solution1 {

	public int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		for (int i = 1, j = 0; i < n; i++) {
			// 找出最早的能一步跳到 i 的位置 j
			while (j + nums[j] < i) {
				j++;
			}
			dp[i] = dp[j] + 1;
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/jump-game-ii/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.jump(new int[]{2, 3, 1, 1, 4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.jump(new int[]{2, 3, 0, 1, 4}));

	}

}
