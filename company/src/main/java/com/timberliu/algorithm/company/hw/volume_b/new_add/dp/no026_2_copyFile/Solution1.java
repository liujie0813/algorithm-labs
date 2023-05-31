package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no026_2_copyFile;

import java.util.Scanner;

/**
 * 26. 通过软盘拷贝文件
 *
 *  dp[i][j]：考虑前 i 个文件，在块数量为 j 的情况下，最大拷贝的文件总大小
 *
 *  第 i 个文件是否拷贝：
 *   blockNum = files[i] / 512
 *
 *   1. 拷贝：dp[i][j] = dp[i - 1][j - blockNum] + files[i]
 *   2. 不拷贝：dp[i][j] = dp[i - 1][j]
 *   max()
 *
 *  初始化：
 *  dp[i][0] =
 *
 * @author liujie
 * @date 2023/5/31
 */

public class Solution1 {

	private static int totalCapacity = 1474560;
	private static int blockSize = 512;
	private static int totalBlockNum = totalCapacity / blockSize;

	public static int maxCopyFileSize(int[] files, int n) {
		int[][] dp = new int[n + 1][totalBlockNum + 1];
		for (int i = 1; i <= n; i++) {
			int cur = (int) Math.ceil((double) files[i - 1] / blockSize);
			for (int j = 0; j <= totalBlockNum; j++) {
				if (j < cur) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur] + files[i - 1]);
				}
			}
		}
		return dp[n][totalBlockNum];
	}

	/**
	 * 3
	 * 737270
	 * 737272
	 * 737288
	 */
	/**
	 * 6
	 * 400000
	 * 200000
	 * 200000
	 * 200000
	 * 400000
	 * 400000
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] files = new int[n];
		for (int i = 0; i < n; i++) {
			files[i] = scanner.nextInt();
		}
		int res = maxCopyFileSize(files, n);
		System.out.println(res);
	}

}
