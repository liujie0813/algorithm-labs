package com.timberliu.algorithm.leetcode.dp.path.no0120_2_Triangle;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author Timber
 * @date 2021/10/13
 */
public class Solution1 {

	public static int minimumTotal(List<List<Integer>> triangle) {
		int lastLen = triangle.get(triangle.size() - 1).size();
		int[] dp = new int[lastLen];
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> list = triangle.get(i);
			for (int j = list.size() - 1; j >= 0; --j) {
				Integer num = list.get(j);
				if (j == 0) {
					dp[j] += num;
				} else if (j == list.size() - 1) {
					dp[j] = dp[j - 1] + num;
				} else {
					dp[j] = Math.min(dp[j - 1], dp[j]) + num;
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i : dp) {
			res = Math.min(res, i);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/triangle/ -----");
		System.out.println("----- 1 -----");
		System.out.println(minimumTotal(Arrays.asList(
				Arrays.asList(2),
				Arrays.asList(3, 4),
				Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3)
		)));

		System.out.println("----- 2 -----");
		System.out.println(minimumTotal(Arrays.asList(
				Arrays.asList(-10)
		)));

	}

}
