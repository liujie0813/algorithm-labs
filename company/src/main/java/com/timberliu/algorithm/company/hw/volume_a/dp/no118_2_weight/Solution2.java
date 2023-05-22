package com.timberliu.algorithm.company.hw.volume_a.dp.no118_2_weight;

import java.util.Scanner;

/**
 * 118. 称砝码
 *
 *  n
 *  weight:  4   2   3
 *  num:     2   3   2
 *
 *  砝码     - 物品
 *  砝码重量  - 物品重量
 *  砝码重量  - 物品价值
 *  砝码数量  - 物品数量
 *  重量和    - 背包容量
 *
 *  dp[0]：是否能装出该价值
 *
 * @author liujie
 * @date 2023/4/11
 */

public class Solution2 {

	public static int weight(int[] weights, int[] nums) {
		int maxVal = 0;
		int n = weights.length;
		for (int i = 0; i < n; i++) {
			maxVal += weights[i] * nums[i];
		}

		boolean[] dp = new boolean[maxVal + 1];
		dp[0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = maxVal; j >= weights[i]; j--) {
				for (int k = 1; k <= nums[i]; k++) {
					if (j >= k * weights[i] && dp[j - k * weights[i]]) {
						dp[j] = true;
					}
				}
			}
		}

		int res = 0;
		for (boolean flag : dp) {
			if (flag) {
				res++;
			}
		}
		return res;
	}

	/**
	 * 3
	 * 4 2 3
	 * 2 3 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 多组测试数据
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int[] weight = new int[n];
			for (int i = 0; i < n; i++) {
				weight[i] = scanner.nextInt();
			}
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = scanner.nextInt();
			}

			int res = weight(weight, num);
			System.out.println(res);
		}
	}

}
