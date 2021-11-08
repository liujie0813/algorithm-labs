package com.timberliu.algorithm.leetcode.greedy.no0121_1_bestTimeToBuyAndSellStock.related.no0122_2_bestTimeToBuyAndSellStockII;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution2 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			res += Math.max(0, prices[i] - prices[i - 1]);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProfit(new int[]{7,1,5,3,6,4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProfit(new int[]{1,2,3,4,5}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.maxProfit(new int[]{7,6,4,3,1}));

	}

}
