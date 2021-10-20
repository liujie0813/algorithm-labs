package com.timberliu.algorithm.leetcode.dp.sequence.no0740_2_deleteAndEarn;

/**
 * 740. 删除并获得点数
 *
 *   当选择删除某个数时，比该数 大/小 一个单位的数都不能被选择
 *
 *   如果将数组排好序，从前往后处理，只需要考虑当前数与前一个数的【大小&选择】关系即可
 *
 *   转换为【序列DP】问题（选择某个数，需要考虑前一个数的【大小&选择】状态）
 *
 *   定义：f[i][0] 表示数值为 i 的数【不选择】的最大价值；f[i][1] 表示数值为 i 的数【选择】的最大价值
 *
 *   f[i][0]：数值 i 不被选择，那么前一个数可选/可不选，两者取 max 即可
 *            f[i][0] = max(f[i - 1][0], f[i - 1][1])
 *   f[i][1]：数组 i 被选择，那么前一个数只能不选，同时为了最大点数数值 i 必须全选
 *            f[i][1] = f[i - 1][0] + i * cnt[i]
 *
 *   数组空间优化
 *
 * @author Timber
 * @date 2021/10/20
 */
public class Solution2 {

	public int deleteAndEarn(int[] nums) {
		int[] cnts = new int[10001];
		int max = 0;
		for (int num : nums) {
			cnts[num]++;
			max = Math.max(max, num);
		}

		// 删除元素 i 所获得的的最大点数
		int[] dp = new int[max + 1];
		dp[1] = cnts[1];
		for (int i = 2; i <= max; i++) {
			//               不删 i     删除 i
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * cnts[i]);
		}
		return dp[max];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/delete-and-earn/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.deleteAndEarn(new int[]{3, 4, 2}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.deleteAndEarn(new int[]{2,2,3,3,3,4}));

	}

}
