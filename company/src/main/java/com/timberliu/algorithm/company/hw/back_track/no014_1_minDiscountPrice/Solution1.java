package com.timberliu.algorithm.company.hw.back_track.no014_1_minDiscountPrice;

import java.util.Scanner;

/**
 * 14. 模拟商场优惠打折
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int[][] minDiscountPrice(int[] prices, int n, int[] nums) {
		int[][] res = new int[n][2];
		for (int i = 0; i < n; i++) {
			res[i][0] = res[i][1] = Integer.MAX_VALUE;
			backtrack(prices[i], nums, new boolean[3], 0, 0, res[i]);
		}
		return res;
	}

	private static void backtrack(int price, int[] nums, boolean[] used, int typeNum, int totalNum, int[] res) {
		if (typeNum == 2) {
			if (price < res[0]) {
				res[0] = price;
				res[1] = totalNum;
			} else if (price == res[0]) {
				res[1] = Math.min(res[1], totalNum);
			}
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			int nextPrice = price;
			int useNum = 0;
			if (i == 0) {
				while (useNum < nums[0] && nextPrice >= 100) {
					nextPrice -= nextPrice / 100 * 10;
					useNum++;
				}
			} else if (i == 1) {
				useNum = 1;
				nextPrice = (int) Math.floor(price * 0.92);
			} else if (i == 2) {
				useNum = Math.min(price / 5, nums[2]);
				nextPrice -= useNum * 5;
			}
			used[i] = true;
			backtrack(nextPrice, nums, used, typeNum + 1, totalNum + useNum, res);
			used[i] = false;
		}
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
		for (int i = 0; i < 3; i++) {
			nums[i] = scanner.nextInt();
		}
		int n = scanner.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scanner.nextInt();
		}

		int[][] res = minDiscountPrice(prices, n, nums);
		for (int[] val : res) {
			System.out.println(val[0] + " " + val[1]);
		}
	}

}
