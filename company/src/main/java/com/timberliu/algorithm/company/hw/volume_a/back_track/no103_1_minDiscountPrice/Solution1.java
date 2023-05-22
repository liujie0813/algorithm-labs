package com.timberliu.algorithm.company.hw.volume_a.back_track.no103_1_minDiscountPrice;

import java.util.Scanner;

/**
 * 103. 模拟商场打折优惠 II
 *
 *  回溯，遍历打折次序的所有可能性
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	public static int[][] minDiscountPrice(int[] prices, int[] nums) {
		int n = prices.length;
		int[][] res = new int[n][2];
		for (int i = 0; i < prices.length; i++) {
			boolean[] used = new boolean[nums.length];
			res[i] = minDiscountPrice(prices[i], nums, 0, 0, used);
		}
		return res;
	}

	private static int[] minDiscountPrice(int price, int[] nums, int typeNum, int usedNum, boolean[] used) {
		int[] res = new int[]{price, usedNum};
		if (typeNum == 2) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			int curNum = 0;
			int discount = 0;
			if (i == 0) {
				curNum = Math.min(price / 100, nums[i]);
				discount = curNum * 10;
			} else if (i == 1) {
				curNum = 1;
				discount = (int) (price * 0.08);
			} else if (i == 2) {
				curNum = nums[i];
				discount = curNum * 5;
			}
			used[i] = true;
			int[] next = minDiscountPrice(price - discount, nums, typeNum + 1, usedNum + curNum, used);
			if (next[0] < res[0]) {
				res[0] = next[0];
				res[1] = next[1];
			}
			if (next[0] == res[0]) {
				res[1] = Math.min(res[1], next[1]);
			}
			used[i] = false;
		}
		return res;
	}

	/**
	 * 3 2 5
	 * 3
	 * 100
	 * 200
	 * 400
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[3];
		nums[0] = scanner.nextInt();
		nums[1] = scanner.nextInt();
		nums[2] = scanner.nextInt();
		int n = scanner.nextInt();
		int[] price = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = scanner.nextInt();
		}

		int[][] res = minDiscountPrice(price, nums);
		for (int[] arr : res) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}

}
