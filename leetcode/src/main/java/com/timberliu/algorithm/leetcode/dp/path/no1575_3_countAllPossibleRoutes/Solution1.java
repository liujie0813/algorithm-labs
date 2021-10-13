package com.timberliu.algorithm.leetcode.dp.path.no1575_3_countAllPossibleRoutes;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 *
 *  记忆化搜索
 *
 *    base case：
 *      1. 有效情况：如果当前位置 i 就是目的地，就算是一条有效路径
 *      2. 无效情况：
 *           a. 当油量消耗完，又不在位置 finish
 *           b. 油量不为 0，但无法再移动到其他任何位置
 *
 *    记忆化搜索（缓存）
 *      1. 二维数组：cache[][]：用 cache[i][fuel] 表示从位置 i 出发，剩余油量为 fuel 时，到达目标位置的 [路径数量]
 *
 *      最坏情况下，有 n*fuel 个状态需要计算（填满整个 cache），每个状态遍历一次 locations 数组，
 *         时间复杂度为 O(n^2 * fuel)
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution1 {

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

		// 没有油，未到目标位置
		if (retainFuel == 0 && cur != finish) {
			cache[cur][retainFuel] = 0;
			return 0;
		}

		boolean canMove = false;
		for (int i = 0; i < ls.length; i++) {
			if (i != cur) {
				int need = Math.abs(ls[i] - ls[cur]);
				if (retainFuel >= need) {
					canMove = true;
					break;
				}
			}
		}
		// 有油，但不够
		if (!canMove && retainFuel != 0) {
			// 是否到目的地
			cache[cur][retainFuel] = cur == finish ? 1 : 0;
			return cache[cur][retainFuel];
		}

		// 是否到目的地
		// 每个点可以经过多次，可以继续跑
		int sum = cur == finish ? 1 : 0;
		for (int i = 0; i < ls.length; i++) {
			if (i != cur) {
				int need = Math.abs(ls[i] - ls[cur]);
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
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		int i1 = solution1.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5);
		System.out.println(i1);

		System.out.println("----- 2 -----");
		int i2 = solution1.countRoutes(new int[]{4, 3, 1}, 1, 0, 6);
		System.out.println(i2);

		System.out.println("----- 3-----");
		int i3 = solution1.countRoutes(new int[]{5, 2, 1}, 0, 2, 3);
		System.out.println(i3);

		System.out.println("----- 4-----");
		int i4 = solution1.countRoutes(new int[]{1, 2, 3}, 0, 2, 40);
		System.out.println(i4);

	}

}
