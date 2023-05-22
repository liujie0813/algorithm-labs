package com.timberliu.algorithm.company.hw.volume_a.prefix_sum.no015_2_blockNum;

import java.util.Scanner;

/**
 * 15. 探索地块建立
 *
 * @author Timber
 * @date 2023/4/27
 */
public class Solution1 {

	public static int blockNum(int[][] arr, int n, int m, int c, int k) {
		int[][] prefixSum = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + arr[i - 1][j - 1];
			}
		}
		int res = 0;
		for (int i = c; i <= n; i++) {
			for (int j = c; j <= m; j++) {
				if (prefixSum[i][j] - prefixSum[i - c][j] - prefixSum[i][j - c] + prefixSum[i - c][j - c] >= k) {
					res++;
				}
			}
		}
		return res;
	}

	/**
	 * 2 5 2 6
	 * 1 3 4 5 8
	 * 2 3 6 7 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int c = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int res = blockNum(arr, n, m, c, k);
		System.out.println(res);
	}

}
