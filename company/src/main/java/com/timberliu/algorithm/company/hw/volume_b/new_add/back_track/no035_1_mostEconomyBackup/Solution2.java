package com.timberliu.algorithm.company.hw.volume_b.new_add.back_track.no035_1_mostEconomyBackup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 35. 数据最节约的备份方法
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution2 {

	private static int max = 500;

	public static int mostEconomyBackup(int[] arr) {
		 Arrays.sort(arr);
		 int left = 1;
		 int right = arr.length;
		 int res = 0;
		 while (left <= right) {
			 int mid = (left + right) / 2;
			 if (check(arr, 0, new int[mid])) {
				 res = mid;
				 right = mid - 1;
			 } else {
				 left = mid + 1;
			 }
		 }
		 return res;
	}

	private static boolean check(int[] arr, int index, int[] buckets) {
		if (index == arr.length) {
			return true;
		}

		for (int i = 0; i < buckets.length; i++) {
			if (i > 1 && buckets[i] == buckets[i - 1]) {
				continue;
			}
			if (arr[index] + buckets[i] > max) {
				continue;
			}
			buckets[i] += arr[index];
			if (check(arr, index + 1, buckets)) {
				return true;
			}
			buckets[i] -= arr[index];
		}
		return false;
	}

	/*
	 * 100,500,300,200,400
	 */
	/**
	 * 100,100,200,300
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		int res = mostEconomyBackup(arr);
		System.out.println(res);
	}

}
