package com.timberliu.algorithm.company.hw.back_track.no070_1_componentCombination;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 70. 硬件产品销售方案
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static List<List<Integer>> componentCombination(int[] prices, int amount) {
		Arrays.sort(prices);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(prices, 0, amount, new ArrayList<>(), res);
		return res;
	}

	private static void backtrack(int[] prices, int index, int target, List<Integer> curList, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(curList));
			return;
		}
		for (int i = index; i < prices.length; i++) {
			if (prices[i] > target) {
				break;
			}
			curList.add(prices[i]);
			backtrack(prices, i, target - prices[i], curList, res);
			curList.remove(curList.size() - 1);
		}
	}

	/**
	 * 500
	 * 100,200,300,500
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int amount = Integer.parseInt(scanner.nextLine());
		String[] strs = scanner.nextLine().split(",");
		int[] prices = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			prices[i] = Integer.parseInt(strs[i]);
		}

		List<List<Integer>> res = componentCombination(prices, amount);
		PrintUtils.printListListIntegerV3(res);
	}

}
