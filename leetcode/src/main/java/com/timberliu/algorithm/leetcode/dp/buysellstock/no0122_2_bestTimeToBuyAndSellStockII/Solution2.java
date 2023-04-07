package com.timberliu.algorithm.leetcode.dp.buysellstock.no0122_2_bestTimeToBuyAndSellStockII;

/**
 * 122. 买卖股票的最佳时机 II
 *
 *  可以买卖多次
 *
 *  关键是利润拆分，不要整体看，而是把整体利润拆分为每天的利润
 *  最终利润是可分解的，例如第 0 天买入，第 3 天卖出，利润为 prices[3] - prices[0]
 *     相当于 (prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
 *
 *  股票价格： 7, 1, 5, 3, 6, 4
 *     利润：    -6 4  -2  3 -2
 *   只需要收集每天的正利润就可以
 *
 *  贪心：
 *    局部最优：收集每天的正利润
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
