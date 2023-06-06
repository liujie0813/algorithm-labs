package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no028_2_lessInterviewer;

import java.util.List;
import java.util.Scanner;

/**
 * 28. 最少面试官
 *
 * @author Timber
 * @date 2023/6/4
 */
public class Solution1 {

	public static int lessInterviewer(int[][] arr, int m) {

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}

		int res = lessInterviewer(arr, m);
		System.out.println(res);
	}

}
