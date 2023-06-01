package com.timberliu.algorithm.company.hw.volume_b.new_add.back_track.no035_1_mostEconomyBackup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 35. 数据最节约的备份方法
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	private static int max = 500;

	public static int mostEconomyBackup(int[] arr) {
		 int[] res = {arr.length};
		 backtrack(arr, 0, new ArrayList<>(), res);
		 return res[0];
	}

	private static void backtrack(int[] arr, int cur, List<Integer> buckets, int[] res) {
		if (cur == arr.length) {
			res[0] = Math.min(res[0], buckets.size());
			return;
		}
		int val = arr[cur];
		for (int i = 0; i < buckets.size(); i++) {
			if (buckets.get(i) + val > max) {
				continue;
			}
			buckets.set(i, buckets.get(i) + val);
			backtrack(arr, cur + 1, buckets, res);
			buckets.set(i, buckets.get(i) - val);
		}
		buckets.add(val);
		backtrack(arr, cur + 1, buckets, res);
		buckets.remove(buckets.size() - 1);
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
