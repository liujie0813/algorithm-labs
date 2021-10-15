package com.timberliu.algorithm.basic.dp.bounded_knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * 多重背包
 *
 *   扁平化：将原本 n 个物品用 ceil(log(n)) 个数来代替，从而降低算法复杂度
 *
 *   二进制优化：对【物品】做分类，使得总数量为 m 的物品能够用更小的 logm 个数 所组合表示出来
 *
 *   时间复杂度：扁平化可展开成 O(sum(log limit[i])) 个物品
 *           共有 O(sum(log limit[i]) * capacity) 个状态需要被转移
 *   空间复杂度：O(sum(log limit[i]) + capacity)
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution4 {

	public static int maxValue(int num, int capacity, int[] limit, int[] weight, int[] value) {
		List<Integer> newWeight = new ArrayList<>();
		List<Integer> newValue = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			int val = limit[i];
			for (int k = 1; k <= val; k *= 2) {
				val -= k;
				newWeight.add(k * weight[i]);
				newValue.add(k * value[i]);
			}
			if (val > 0) {
				newWeight.add(val * weight[i]);
				newValue.add(val * value[i]);
			}
		}

		int[] dp = new int[capacity + 1];
		for (int i = 0; i < newWeight.size(); i++) {
			for (int j = capacity; j >= newValue.get(i); j--) {
				dp[j] = Math.max(dp[j], dp[j - newWeight.get(i)] + newValue.get(i));
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		System.out.println("----- 1 -----");
		System.out.println(maxValue(2, 5, new int[]{1, 2}, new int[]{1, 2}, new int[]{2, 1}));

	}

}
