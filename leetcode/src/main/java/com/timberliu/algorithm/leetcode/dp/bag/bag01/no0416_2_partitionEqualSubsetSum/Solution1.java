package com.timberliu.algorithm.leetcode.dp.bag.bag01.no0416_2_partitionEqualSubsetSum;

/**
 * 416. 分割等和子集
 *
 *  等价于 能否从数组中挑选若干个元素，使得元素总和等于所有元素总和的一半
 *
 *  抽象为 背包问题：给定背包容量为 target=sum/2，每个数组元素的价值与成本都是其数值大小，求是否能填满背包
 *   抽象为背包问题？
 *    1. 背包的体积为 target=sum/2
 *    2. 背包中要放入的物品的重量为 元素的数值，价值也为 元素的数值
 *    3. 背包如果刚好填满，说明找到了和为 sum/2 的子集
 *    4. 背包中每个元素不可以重复放入
 *
 *  状态：f[i][j] 表示考虑前 i 个数，其选择的数字总和不超过 j 的最大价值
 *
 *  状态转移方程：f[i][j] = max(f[i-1][j], f[i-1][j-nums[i]] + nums[i])
 *
 * @author Timber
 * @date 2021/10/13
 */
public class Solution1 {

	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int target = sum / 2;
		// 和为奇数，false
		if (target * 2 != sum) {
			return false;
		}

		int[][] dp = new int[n][target + 1];
		// 第一个值
		for (int j = nums[0]; j <= target; j++) {
			dp[0][j] = nums[0];
		}
		// 其余值
		for (int i = 1; i < nums.length; i++) {
			int t = nums[i];
			for (int j = 0; j <= target; j++) {
				if (j < t) {
					// 不选第 i 个值
					dp[i][j] = dp[i - 1][j];
				} else {
					// 选第 i 个值
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t] + t);
				}
			}
		}
		// 如果最大价值等于 target，说明可行
		return dp[n - 1][target] == target;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/partition-equal-subset-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(canPartition(new int[]{1, 5, 11, 5}));

		System.out.println("----- 2 -----");
		System.out.println(canPartition(new int[]{1, 2, 3, 5}));

	}

}
