package com.timberliu.algorithm.leetcode.greedy.no0376_2_wiggleSubsequence;

/**
 * 376. 摆动序列
 *
 *  连续数字之间的差严格地在正数和负数之间交替，摆动序列
 *    第一个差可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列
 *
 *  动态规划
 *    状态定义：对于当前考虑的这个数，要么作为山峰（nums[i] > nums[i-1]），要么作为山谷（nums[i] < nums[i-1]）
 *      dp[i][0]：表示考虑前 i 个数，第 i 个数作为山峰的摆动子序列的最长长度
 *      dp[i][1]：表示考虑前 i 个数，第 i 个数作为山谷的摆动子序列的最长长度
 *
 *    转移方程：
 *      dp[i][0] = max(dp[i][0], dp[j][1] + 1)，其中 0 < j < i 且 nums[j] < nums[i]，表示
 *      	将 nums[i] 接到前面某个山谷后面，作为山峰
 *      dp[i][1] = max(dp[i][1], dp[j][0] + 1)，其中 0 < j < i 且 nums[j] > nums[i]，表示
 *          将 nums[i] 接到前面某个山峰后面，作为山谷
 *
 *    初始状态：一个数也是摆动序列，dp[0][0] = dp[0][1] = 1
 *
 */

public class Solution2 {

    public static int wiggleMaxLength(int[] nums) {
		int[][] dp = new int[nums.length][2];
		dp[0][0] = dp[0][1] = 1;
		for (int i = 1; i < nums.length; i++) {
			// i 自己成为波峰或波谷
			dp[i][0] = dp[i][1] = 1;

			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[i]) {
					// i 是波谷
					dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
				}
			}
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					// i 是波峰
					dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
				}
			}
		}
		return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
		int res1 = wiggleMaxLength(new int[]{1,7,4,9,2,5});
		System.out.println(res1);

		int res2 = wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
		System.out.println(res2);

		int res3 = wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9});
		System.out.println(res3);

	}

}