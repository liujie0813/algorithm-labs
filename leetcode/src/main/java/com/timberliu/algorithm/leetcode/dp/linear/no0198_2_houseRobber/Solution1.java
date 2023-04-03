package com.timberliu.algorithm.leetcode.dp.linear.no0198_2_houseRobber;

/**
 * 198. 打家劫舍
 *
 *  dp[i]：考虑前 i 个房间，最多可以偷窃的金额
 *
 *  推导：
 *   - 如果偷第 i 个房间，则第 i-1 个房间是不考虑的，考虑前 i-2 个房间的最多偷窃金额；dp[i] = nums[i] + dp[i - 2]
 *   - 如果不偷第 i 个房间，则考虑前 i-1 个房间的最多偷窃金额，dp[i] = dp[i - 1]
 *  dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
 *
 *  初始化
 *   - dp[0] = nums[0]
 *   - dp[1] = max(nums[0], nums[1])
 *
 */

public class Solution1 {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int res = rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(res);
    }

}