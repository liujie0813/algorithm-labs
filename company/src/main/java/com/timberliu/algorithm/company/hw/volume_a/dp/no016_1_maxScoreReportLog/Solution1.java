package com.timberliu.algorithm.company.hw.volume_a.dp.no016_1_maxScoreReportLog;

import java.util.Scanner;

/**
 * 16. 日志上报首次最多积分
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	public static int maxScore(int[] arr) {
		int max = arr[0];
		int total = arr[0], delay = 0;
		for (int i = 1; i < arr.length; i++) {
			delay += total;
			total = Math.min(100, total + arr[i]);
			max = Math.max(max, total - delay);
			if (total == 100) {
				break;
			}
		}
		return max;
	}

	/*
	 * 1 98 1
	 */
	/**
	 * 3 7 40 10 60
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int res = maxScore(arr);
		System.out.println(res);
	}

}
