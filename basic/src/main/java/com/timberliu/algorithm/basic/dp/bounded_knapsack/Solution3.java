package com.timberliu.algorithm.basic.dp.bounded_knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * 多重背包
 *
 *   扁平化：遍历所有物品，枚举每件物品的数量，将其添加到一个新的物品列表里
 *
 *   时间复杂度：扁平化可展开成 O(sum(limit[i])) 个物品
 *           共有 O(sum(limit[i]) * capacity) 个状态需要被转移
 *   空间复杂度：O(sum(limit[i]) + capacity)
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution3 {

	public static int maxValue(int num, int capacity, int[] limit, int[] weight, int[] value) {
		List<int[]> arr = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			int val = limit[i];
			while (val-- > 0) {
				arr.add(new int[]{weight[i], value[i]});
			}
		}

		int[] dp = new int[capacity + 1];
		for (int i = 0; i < arr.size(); i++) {
			int weightI = arr.get(i)[0], valueI = arr.get(i)[1];
			for (int j = capacity; j >= weightI; j--) {
				dp[j] = Math.max(dp[j], dp[j - weightI] + valueI);
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		System.out.println("----- 1 -----");
		System.out.println(maxValue(2, 5, new int[]{1, 2}, new int[]{1, 2}, new int[]{2, 1}));

	}

}
