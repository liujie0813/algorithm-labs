package com.timberliu.algorithm.company.hw.volume_a.sliding_window.no084_1_maxContinousSum;

import java.util.Scanner;

/**
 * 84. 区块链文件存储系统
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int maxContinuousSum(int[] capacityArr, int maxCapacity) {
		int curSum = 0;
		int res = 0;
		int left = 0;
		for (int right = 0; right < capacityArr.length; right++) {
			curSum += capacityArr[right];
			while (curSum > maxCapacity) {
				curSum -= capacityArr[left];
				left++;
			}
			res = Math.max(res, curSum);
			if (res == maxCapacity) {
				break;
			}
		}
		return res;
	}

	/*
	 * 1000
	 * 100 500 400 150 500 100
	 */
	/**
	 * 1000
	 * 100 300 500 400 400 150 100
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxCapacity = Integer.parseInt(scanner.nextLine());
		String[] strs = scanner.nextLine().split(" ");
		int[] capacityArr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			capacityArr[i] = Integer.parseInt(strs[i]);
		}
		int res = maxContinuousSum(capacityArr, maxCapacity);
		System.out.println(res);
	}

}
