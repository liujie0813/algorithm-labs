package com.timberliu.algorithm.leetcode.dp.path.no1575_3_countAllPossibleRoutes;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 *
 *  记忆化搜索
 *
 *   简化 base case：
 *      1. 无效情况：如果一步到达不了，则绕到其他位置也不行
 *
 *  最坏情况下，有 n*fuel 个状态需要计算（填满整个 cache），每个状态遍历一次 locations 数组，
 *         时间复杂度为 O(n^2 * fuel)
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution2 {

	int mod = 1000000007;

	int[][] cache;

	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		cache = new int[locations.length][fuel + 1];
		for (int i = 0; i < locations.length; i++) {
			// -1，未判断
			Arrays.fill(cache[i], -1);
		}
		return dfs(locations, start, finish, fuel);
	}

	private int dfs(int[] ls, int cur, int finish, int retainFuel) {
		if (cache[cur][retainFuel] != -1) {
			return cache[cur][retainFuel];
		}

		// 如果一步到达不了，走其他位置也不行
		int need = Math.abs(ls[cur] - ls[finish]);
		if (need > retainFuel) {
			cache[cur][retainFuel] = 0;
			return 0;
		}

		// 是否到目的地
		// 每个点可以经过多次，可以继续跑
		int sum = cur == finish ? 1 : 0;
		for (int i = 0; i < ls.length; i++) {
			if (i != cur) {
				need = Math.abs(ls[i] - ls[cur]);
				if (retainFuel >= need) {
					sum += dfs(ls, i, finish, retainFuel - need);
					sum %= mod;
				}
			}
		}
		cache[cur][retainFuel] = sum;
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/count-all-possible-routes/ -----");
		Solution2 solution2 = new Solution2();
		System.out.println("----- 1 -----");
		int i1 = solution2.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5);
		System.out.println(i1);

		System.out.println("----- 2 -----");
		int i2 = solution2.countRoutes(new int[]{4, 3, 1}, 1, 0, 6);
		System.out.println(i2);

		System.out.println("----- 3-----");
		int i3 = solution2.countRoutes(new int[]{5, 2, 1}, 0, 2, 3);
		System.out.println(i3);

		System.out.println("----- 4-----");
		int i4 = solution2.countRoutes(new int[]{1, 2, 3}, 0, 2, 40);
		System.out.println(i4);

	}

}
