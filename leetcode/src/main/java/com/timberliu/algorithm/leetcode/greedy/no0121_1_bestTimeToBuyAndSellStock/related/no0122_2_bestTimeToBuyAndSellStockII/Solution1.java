package com.timberliu.algorithm.leetcode.greedy.no0121_1_bestTimeToBuyAndSellStock.related.no0122_2_bestTimeToBuyAndSellStockII;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int n = prices.length;
		int maxProfit = 0;
		int max = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (prices[i] > prices[i + 1]) {
				max = prices[i];
			} else if (prices[i] <= prices[i + 1]) {
				if (i == 0 || prices[i - 1] > prices[i]) {
					maxProfit += max - prices[i];
				}
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProfit(new int[]{7,1,5,3,6,4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProfit(new int[]{1,2,3,4,5}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.maxProfit(new int[]{7,6,4,3,1}));

	}

}
