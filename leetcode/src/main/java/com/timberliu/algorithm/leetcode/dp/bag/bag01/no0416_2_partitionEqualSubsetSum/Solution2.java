package com.timberliu.algorithm.leetcode.dp.bag.bag01.no0416_2_partitionEqualSubsetSum;

/**
 * 416. 分割等和子集
 *
 *  等价于 能否从数组中挑选若干个元素，使得元素总和等于所有元素总和的一半
 *
 *  抽象为 背包问题：给定背包容量为 target=sum/2，每个数组元素的价值与成本都是其数值大小，求是否能填满背包
 *
 *  状态：f[i][j] 表示考虑前 i 个数组，其选择的数字总和不超过 j 的最大价值
 *
 *  状态转移方程：f[i][j] = max(f[i-1][j], f[i-1][j-nums[i]] + nums[i])
 *
 * @author Timber
 * @date 2021/10/13
 */
public class Solution2 {

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int target = sum / 2;
		// 和为奇数，false
		if (target * 2 != sum) {
			return false;
		}

		int[] dp = new int[target + 1];
		for (int i = 0; i < nums.length; i++) {
			int t = nums[i];
			for (int j = target; j >= t; j--) {
				dp[j] = Math.max(dp[j], dp[j - t] + t);
			}
		}
		return dp[target] == target;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/partition-equal-subset-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(canPartition(new int[]{1, 5, 11, 5}));

		System.out.println("----- 2 -----");
		System.out.println(canPartition(new int[]{1, 2, 3, 5}));

	}

}
