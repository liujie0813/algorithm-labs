package com.timberliu.algorithm.company.hw.volume_a.binary_search.no107_1_minLimit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 107. 统一最小限载数
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution2 {

	public static int minLimit(int[] goods, int[] types, int k) {
		List<Integer> dryGoods = new ArrayList<>();
		List<Integer> wetGoods = new ArrayList<>();
		for (int i = 0; i < goods.length; i++) {
			if (types[i] == 0) {
				dryGoods.add(goods[i]);
			} else {
				wetGoods.add(goods[i]);
			}
		}
		int dryLimit = minLimit(dryGoods, k);
		int wetLimit = minLimit(wetGoods, k);
		return Math.max(dryLimit, wetLimit);
	}

	private static int minLimit(List<Integer> goods, int k) {
		int minLimit = 0;
		int maxLimit = 0;
		for (Integer good : goods) {
			minLimit = Math.max(minLimit, good);
			maxLimit += good;
		}

		while (minLimit < maxLimit) {
			int mid = (minLimit + maxLimit) / 2;
			int[] capacity = new int[k];
			if (can(goods, 0, k, mid, capacity)) {
				maxLimit = mid;
			} else {
				minLimit = mid + 1;
			}
		}
		return minLimit;
	}

	/**
	 * 判断当前 limit 是否可以装载
	 *
	 *  是否考虑卸货/装货顺序
	 *  如果按顺序装货，本题逻辑
	 *  如果可以不按顺序装货，则要使用回溯，使用 cap[] 存储每辆车目前的装载，第 i 个 good 尝试装到每辆车上，再去装第 i+1 个 good
	 */
	private static boolean can(List<Integer> goods, int index, int k, int limit, int[] capacity) {
		if (index == goods.size()) {
			return true;
		}
		// 有多辆车，可以装到任意一辆车上
		for (int i = 0; i < k; i++) {
			if (capacity[i] + goods.get(index) <= limit) {
				capacity[i] += goods.get(index);
				if (can(goods, index + 1, k, limit, capacity)) {
					return true;
				}
				capacity[i] -= goods.get(index);
			}
		}
		return false;
	}

	/*
	 * 5
	 * 3 2 8 4 2
	 * 0 1 1 1 1
	 * 2
	 */
	/**
	 * 4
	 * 3 2 6 3
	 * 0 1 1 0
	 * 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] goods = new int[n];
		for (int i = 0; i < n; i++) {
			goods[i] = scanner.nextInt();
		}
		int[] types = new int[n];
		for (int i = 0; i < n; i++) {
			types[i] = scanner.nextInt();
		}
		int k = scanner.nextInt();

		int res = minLimit(goods, types, k);
		System.out.println(res);
	}

}
