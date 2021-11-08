package com.timberliu.algorithm.leetcode.greedy.no0121_1_bestTimeToBuyAndSellStock;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int maxProfit = 0;
		int low = prices[0];
		for (int i = 1; i < prices.length; i++) {
			low = Math.min(prices[i], low);
			maxProfit = Math.max(prices[i] - low, maxProfit);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProfit(new int[]{7,1,5,3,6,4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProfit(new int[]{7,6,4,3,1}));

	}

}
