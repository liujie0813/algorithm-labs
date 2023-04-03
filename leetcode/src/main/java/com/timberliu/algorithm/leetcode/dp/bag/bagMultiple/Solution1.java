package com.timberliu.algorithm.leetcode.dp.bag.bagMultiple;

/**
 * 多重背包原型问题
 *
 * @author liujie
 * @date 2023/4/3
 */

public class Solution1 {

	public static int maxValue(int[] weight, int[] value, int[] limit, int capacity) {
		int[] dp = new int[capacity + 1];
		for (int i = 0; i < weight.length; i++) {
			for (int j = capacity; j >= weight[i]; j--) {
				// 相比于 01 背包，加一个遍历：物品数量限制
				for (int k = 0; k <= limit[i] && k * weight[i] <= j; k++) {
					dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
				}
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		int res = maxValue(new int[]{1, 3, 4}, new int[]{15, 20, 30}, new int[]{2, 3, 2}, 10);
		System.out.println(res);
	}

}
