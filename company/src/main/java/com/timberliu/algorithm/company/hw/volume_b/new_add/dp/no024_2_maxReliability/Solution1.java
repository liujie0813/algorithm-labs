package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no024_2_maxReliability;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 组装最大可靠性设备
 *
 *  dp[i][j]：考虑前 i 种类型的元器件，在预算为 s 的情况下，最大的可靠性
 *
 *   dp[i][j] = min (max(dp[i-1][j - price], reliability), 某种类型的 n 个元器件)
 *
 *
 * @author liujie
 * @date 2023/5/25
 */

public class Solution1 {

	public static int maxReliability(int[][] arr, int s, int n) {
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		for (int[] component : arr) {
			List<int[]> list = map.computeIfAbsent(component[0], (val) -> new ArrayList<>());
			list.add(component);
		}

		int[][] dp = new int[n][s + 1];
		// 第 i 种类型
		for (int i = 0; i < n; i++) {
			List<int[]> components = map.get(i);
			// 每种类型有多个元器件
			for (int[] component : components) {
				int reliability = component[1];
				int price = component[2];
				// 预算
				for (int j = price; j <= s; j++) {
					if (i == 0) {
						dp[i][j] = Math.max(dp[i][j], reliability);
					} else if (dp[i - 1][j - price] > 0) {
						// 每种类型必选择一个，而 dp[i - 1][j - price] > 0 表示之前选过某个元器件
						// 设备可靠性由最低的元器件决定
						// 最终要求可靠性最大
						dp[i][j] = Math.max(dp[i][j], Math.min(dp[i - 1][j - price], reliability));
					}
				}
			}
		}
		return dp[n - 1][s] == 0 ? -1 : dp[n - 1][s];
	}

	/**
	 * 500 3
	 * 6
	 * 0 80 100
	 * 0 90 200
	 * 1 50 50
	 * 1 70 210
	 * 2 50 100
	 * 2 60 150
	 */
	/**
	 * 100 1
	 * 1
	 * 0 90 200
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		int n = scanner.nextInt();
		int total = scanner.nextInt();
		int[][] arr = new int[total][3];
		for (int i = 0; i < total; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
			arr[i][2] = scanner.nextInt();
		}

		int res = maxReliability(arr, s, n);
		System.out.println(res);
	}

}
