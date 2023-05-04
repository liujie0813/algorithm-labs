package com.timberliu.algorithm.company.hw.logic.no122_1_respTime;

import java.util.Scanner;

/**
 * 122. 响应报文时间
 *
 * @author liujie
 * @date 2023/5/4
 */

public class Solution1 {

	public static int respTime(int[][] arr, int n) {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int maxRespTime = arr[i][1];
			if (maxRespTime >= 128) {
				int mant = maxRespTime & 0b1111;
				int exp = maxRespTime & 0b1110000 >> 4;
				maxRespTime = (mant | 0x10) << (exp + 3);
			}
			res = Math.min(res, arr[i][0] + maxRespTime);
		}
		return res;
	}

	/*
	 * 3
	 * 0 20
	 * 1 10
	 * 8 20
	 */
	/**
	 * 2
	 * 0 255
	 * 200 60
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] splits = scanner.nextLine().split(" ");
			arr[i][0] = Integer.parseInt(splits[0]);
			arr[i][1] = Integer.parseInt(splits[1]);
		}

		int res = respTime(arr, n);
		System.out.println(res);
	}

	public static void test() {
		int cur = 255;
		int mant = cur & 0b1111;
		int exp = (cur & 0b1110000) >> 4;
		System.out.println(mant);
		System.out.println(exp);
	}

}
