package com.timberliu.algorithm.leetcode.dp.sequence.no0354_3_russianDollEnvelops;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 *
 *  最长上升子序列（LIS）
 *
 *  状态定义：f[i] 考虑前 i 个物品，并以第 i 个物品为结尾的最大值
 *
 *   对于每个 f[i]，最小值为 1，表示只选择自己一个信封
 *
 *   对于 f[i]，枚举 [0, i)，看哪一件可以作为第 i 件物品的上一件物品
 *
 *
 * @author Timber
 * @date 2021/10/26
 */
public class Solution1 {

	public int maxEnvelopes(int[][] es) {
		int n = es.length;
		if (n == 0) {
			return n;
		}
		// 在找第 i 件物品的前一件物品时，前面的 i-1 件物品都遍历过，因此第二维 排序不影响
		Arrays.sort(es, Comparator.comparingInt(a -> a[0]));
		int[] dp = new int[n];
		int res = 1;
		for (int i = 0; i < n; i++) {
			// 最小值为 1
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (check(es, j, i)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	private boolean check(int[][] es, int first, int second) {
		return es[first][0] < es[second][0] && es[first][1] < es[second][1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/russian-doll-envelopes/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxEnvelopes(new int[][]{
				{5, 4}, {6, 4}, {6, 7}, {2, 3}
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxEnvelopes(new int[][]{
				{1, 1}, {1, 1}, {1, 1}
		}));

	}

}
