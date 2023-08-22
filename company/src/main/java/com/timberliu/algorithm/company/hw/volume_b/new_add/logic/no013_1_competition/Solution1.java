package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no013_1_competition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 13. 比赛
 *
 * @author liujie
 * @date 2023/5/30
 */

public class Solution1 {

	public static int[] top3(int[][] arr, int m, int n) {
		// 每个选手
		// 编号、分数及次数、总分
		int[][] scores = new int[n][12];
		for (int i = 0; i < n; i++) {
			scores[i][0] = i + 1;
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
				scores[i][arr[i][j]]++;
			}
			scores[i][11] = sum;
		}
		Arrays.sort(scores, (a, b) -> {
			if (a[11] != b[11]) {
				return b[11] - a[11];
			}
			for (int i = 10; i >= 1; i--) {
				if (a[i] == b[i]) {
					continue;
				}
				return b[i] - a[i];
			}
			return 0;
		});
		return new int[]{scores[0][0], scores[1][0], scores[2][0]};
	}

	/**
	 * 4 5
	 * 10,6,9,7,6
	 * 9,10,6,7,5
	 * 8,10,6,5,10
	 * 9,10,8,4,9
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 评委
		int m = scanner.nextInt();
		// 选手
		int n = scanner.nextInt();
		if (m < 3 || n < 3) {
			System.out.println(-1);
			return;
		}
		scanner.nextLine();
		int[][] arr = new int[n][m];
		for (int i = 0; i < m; i++) {
			String[] line = scanner.nextLine().split(",");
			for (int j = 0; j < n; j++) {
				int score = Integer.parseInt(line[j]);
				if (score < 0 || score > 10) {
					System.out.println(-1);
					return;
				}
				arr[j][i] = score;
			}
		}

		int[] res = top3(arr, m, n);
		System.out.println(Arrays.toString(res));
	}

}
