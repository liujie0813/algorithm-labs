package com.timberliu.algorithm.company.hw.volume_a.greedy.no068_2_soldierCrossRiver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 68. 士兵过河
 *
 *  贪心:
 *  两种策略：
 *     1. 让最慢的两个人一起过河，使得浪费的时间最小
 *        又需要有人划船回来，让最快的两个人来完成（需要把最快的一个人先运过去）
 *
 *        a. 让本岸最快的两个人，即第 0 个和第 1 个人一起划船过河（耗时 cost[1]）
 *        b. 再让对岸最快的人，即第 0 个人划船回来（耗时 cost[0]）
 *        c. 再让本岸最慢的两个人，即第 i-2 个和第 i-1 个人一起划船过河（耗时 cost[i-1]）
 *        d. 再让对岸最快的人，即第 1 个人划船回来（耗时 cost[1]）
 *       运最慢的两个人过河，时间：cost[1] + cost[0] + cost[i-1] + cost[1]
 *
 *     2. 需要有人划船回来，让最快的那个人来完成
 *
 *         a. 让本岸最快的和最慢的，第 0 个和第 i-1 个人一起划船过河（耗时 cost[i-1]）
 *         b. 再让对岸最快的，即第 0 个人划船回来（耗时 cost[0]）
 *         c. 再让本岸最快的和最慢的，第 0 个和第 i-2 个人一起划船过河（耗时 cost[i-2]）
 *         d. 再让对岸最快的，即第 0 个人划船回来（耗时 cost[0]）
 *       运最慢的两个人过河，时间：cost[i-1] + cost[0] + cost[i-2] + cost[0]
 *
 *   要求：在限制时间内，最多的过河士兵数
 *
 *   二分法：尝试 0~n 的过河人数，求出需要的最小过河时间，与 limit 限制时间比较
 *
 *    1. need > limit, 人数太多，减少过河人数
 *    2. need < limit，可以过，但可以尝试更多
 *    3. need == limit，刚好可以过，且为最多人数
 *
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int[] soldierCrossRiver(int[] cost, int n, int maxTime) {
		Arrays.sort(cost);
		int[] res = new int[2];
		int left = 0, right = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			int need = minCost(cost, mid);
			if (need > maxTime) {
				right = mid + 1;
			} else if (need < maxTime) {
				res = new int[]{mid, need};
				left = mid + 1;
			} else {
				res = new int[]{mid, need};
				break;
			}
		}
		return res;
	}

	private static int minCost(int[] cost, int num) {
		int res = 0;
		while (num > 0) {
			if (num == 1) {
				res += cost[0];
				break;
			} else if (num == 2) {
				res += minCost(cost[0], cost[1]);
				break;
			} else if (num == 3) {
				// 让第 0 个人划船回来
				res += minCost(cost[0], cost[1]) + cost[0] + minCost(cost[0], cost[2]);
				break;
			} else {
				// 分别让第 0 个和第 1 个人划船回来（但得先把第 1 个人送过去）
				int first = minCost(cost[0], cost[1]) + cost[0] + minCost(cost[num - 2], cost[num - 1]) + cost[1];
				// 每次都让第 0 个人划船回来
				int second = minCost(cost[0], cost[num - 1]) + cost[0] + minCost(cost[0], cost[num - 2]) + cost[0];
				res += Math.min(first, second);
				num -= 2;
			}
		}
		return res;
	}

	private static int minCost(int a, int b) {
		if (a * 10 < b) {
			return a * 10;
		}
		return Math.max(a, b);
	}

	/*
	 * 5
	 * 130
	 * 50 12 13 15 20
	 */
	/**
	 * 7
	 * 171
	 * 25 12 13 15 20 35 20
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int maxTime = scanner.nextInt();
		int[] cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = scanner.nextInt();
		}
		int[] res = soldierCrossRiver(cost, n, maxTime);
		System.out.println(res[0] + " " + res[1]);
	}

}
