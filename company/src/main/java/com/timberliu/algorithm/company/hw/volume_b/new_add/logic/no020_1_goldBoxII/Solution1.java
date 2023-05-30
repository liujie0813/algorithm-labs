package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no020_1_goldBoxII;

import java.util.*;

/**
 * 20. 阿里巴巴找黄金宝箱 II
 *
 * @author liujie
 * @date 2023/5/30
 */

public class Solution1 {

	public static int minSetSize(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> b.getValue() - a.getValue());
		int cnt = (arr.length + 1) / 2;
		int cur = 0;
		int res = 0;
		for (Map.Entry<Integer, Integer> entry : list) {
			cur += entry.getValue();
			res++;
			if (cur >= cnt) {
				break;
			}
		}
		return res;
	}

	/**
	 * 1,1,1,1,3,3,3,6,6,8
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int res = minSetSize(arr);
		System.out.println(res);
	}

}
