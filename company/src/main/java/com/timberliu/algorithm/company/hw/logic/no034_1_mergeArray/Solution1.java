package com.timberliu.algorithm.company.hw.logic.no034_1_mergeArray;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 34. 数组合并
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static List<Integer> mergeArray(int[][] arr, int len) {
		List<Integer> res = new ArrayList<>();
		int index = 0;
		int num = 0;
		while (num < arr.length) {
			for (int[] subArr : arr) {
				for (int i = 0; i < len; i++) {
					if (i + index >= subArr.length) {
						num++;
						break;
					}
					res.add(subArr[i + index]);
				}
				if (num == arr.length) {
					break;
				}
			}
			index += len;
		}
		return res;
	}

	/**
	 * 3
	 * 2
	 * 2,5,6,7,9,5,7
	 * 1,7,4,3,4
	 */
	/**
	 * 4
	 * 3
	 * 1,2,3,4,5,6
	 * 1,2,3
	 * 1,2,3,4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		int[][] arr = new int[n][];
		for (int i = 0; i < n; i++) {
			String[] strs = scanner.nextLine().split(",");
			int[] sub = new int[strs.length];
			for (int j = 0; j < strs.length; j++) {
				sub[j] = Integer.parseInt(strs[j]);
			}
			arr[i] = sub;
		}

		List<Integer> res = mergeArray(arr, len);
		PrintUtils.printListIntegerV3(res);
	}

}
