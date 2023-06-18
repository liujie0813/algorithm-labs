package com.timberliu.algorithm.company.hw.exercise.no04.no087_1_mostPerformanceNum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Timber
 * @date 2023/6/18
 */
public class Solution1 {

	public static int mostPerformanceNum(int[][] arr) {
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = dfs(arr, i, 1);
			res = Math.max(res, val);
		}
		return res;
	}

	private static int dfs(int[][] arr, int curIndex, int curNum) {
		int res = curNum;
		int end = arr[curIndex][1];
		for (int i = curIndex + 1; i < arr.length; i++) {
			if (end + 15 > arr[i][0]) {
				continue;
			}
			int val = dfs(arr, i, curNum + 1);
			res = Math.max(res, val);
		}
		return res;
	}

	/*
	 * 2
	 * 720 120
	 * 840 120
	 */
	/**
	 * 2
	 * 0 60
	 * 90 60
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = arr[i][0] + scanner.nextInt();
		}

		int res = mostPerformanceNum(arr);
		System.out.println(res);
	}

}
