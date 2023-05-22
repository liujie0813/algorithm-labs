package com.timberliu.algorithm.company.hw.volume_a.dp.no007_1_numOfNotInclude101;

import java.util.Scanner;

/**
 * 7. 不含 101 的数
 *  [left, right] 区间内，二进制的表示不含 101 的数的个数
 *
 *  记忆化存储 + 搜索
 *
 * @author liujie
 * @date 2023/4/11
 */

public class Solution1 {

	public static int numOfNotInclude101(int num) {
		// 10 -> 1010
		String bs = Integer.toBinaryString(num);
		int[] arr = new int[bs.length()];
		for (int i = 0; i < bs.length(); i++) {
			arr[i] = Integer.parseInt(bs.charAt(i) + "");
		}
		int[][][] dp = new int[arr.length][2][2];
		return dfs(arr, 0, true, 0, 0, dp);
	}

	/**
	 *  limit：是否有约束
	 *    如果高位取的是最大值，对低位会有约束；否则，低位可以任意取值
	 *
	 *  dp[i][pre][prepre]：最高位是 i 时，前一位是 pre，前前一位是 prepre 的个数
	 *
	 */
	private static int dfs(int[] arr, int index, boolean limit, int pre, int prepre, int[][][] dp) {
		if (index == arr.length) {
			return 1;
		}
		if (!limit && dp[index][pre][prepre] != 0) {
			return dp[index][pre][prepre];
		}
		int max = limit ? arr[index] : 1;
		int count = 0;
		for (int val = 0; val <= max; val++) {
			if (val == 1 && pre == 0 && prepre == 1) {
				continue;
			}
			count += dfs(arr, index + 1, limit && val == max, val, pre, dp);
		}
		if (!limit) {
			dp[index][pre][prepre] = count;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int left = scanner.nextInt();
		int right = scanner.nextInt();
		int res = numOfNotInclude101(right) - numOfNotInclude101(left);
		System.out.println(res);
	}

}
