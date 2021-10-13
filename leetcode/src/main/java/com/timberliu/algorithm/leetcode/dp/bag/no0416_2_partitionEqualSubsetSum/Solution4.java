package com.timberliu.algorithm.leetcode.dp.bag.no0416_2_partitionEqualSubsetSum;

/**
 * 416. 分割等和子集
 *
 *  状态：f[i][j] 表示考虑前 i 个数组，其选择的数字总和是否恰好为 j
 *     此时 dp 数组中存储的 boolean 类型的动规值
 *
 *  状态转移方程：f[i][j] = f[i-1][j] | f[i-1][j-nums[i]]
 *
 *  增加一个 【不考虑任何物品】的情况
 *      原本的： f[0][x] 表示只考虑第一件物品，f[1][x] 表示考虑第一件和第二件物品
 *      调整后：f[0][x] 表示不考虑任何物品，f[1][x] 表示只考虑第一件物品
 *
 * @author Timber
 * @date 2021/10/13
 */
public class Solution4 {

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

		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			int t = nums[i - 1];
			for (int j = target; j >= 0; j--) {
				boolean no = dp[j];
				boolean yes = j >= t ? dp[j - t] : false;
				dp[j] = no | yes;
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/partition-equal-subset-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(canPartition(new int[]{1, 5, 11, 5}));

		System.out.println("----- 2 -----");
		System.out.println(canPartition(new int[]{1, 2, 3, 5}));

	}

}
