package com.timberliu.algorithm.leetcode.greedy.no0135_3_candy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 *  n 个孩子分糖果，ratings 表示每个孩子的评分
 *   要求：1. 每个孩子至少分配到 1 个糖果
 *       2. 相邻两个孩子评分更高的孩子会获得更多的糖果
 *   返回需要准备的 最少糖果数目
 *
 *
 *  贪心思路
 *    确定一边后，再确定另外一边
 *   1. 先确定右边评分大于左边（ratings[i] > ratings[i-1]）
 *   	  从前往后遍历，每个孩子分的糖果，依赖于前边的
 *     局部最优：只要右边评分大于左边，右边的孩子就多一个糖果
 *        res[i] = res[i-1]+1
 *
 *   2. 再确定左边评分大于右边（ratings[i] > ratings[i+1]）
 *        从后往前遍历，每个孩子分的糖果，依赖于后边的
 *     局部最优：只要左边评分大于右边，左边的孩子就多一个糖果
 *        res[i] = Math.max(res[i+1]+1,       res[i])
 *                          右边孩子的糖果+1    当前孩子的糖果，即第一次遍历时的左边孩子的糖果+1
 *                保证第 i 个孩子的糖果数，既大于左边，也大于右边
 */

public class Solution1 {

	public static int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candy[i] = Math.max(candy[i], candy[i + 1] + 1);
			}
		}
		int res = 0;
		for (int a : candy) {
			res += a;
		}
		return res;
	}

    public static int candy2(int[] ratings) {
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else if (ratings[i] == ratings[i - 1]) {
				candy[i] = candy[i - 1];
			}

		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candy[i] = Math.max(candy[i], candy[i + 1] + 1);
			} else if (ratings[i] == ratings[i + 1]) {
				candy[i] = Math.max(candy[i], candy[i + 1]);
			}
		}
		int res = 0;
		for (int a : candy) {
			res += a;
		}
		return res;
    }

    public static void main(String[] args) {
		int res1 = candy(new int[]{1, 0, 2});
		System.out.println(res1);

		int res2 = candy(new int[]{1, 2, 2});
		System.out.println(res2);

		int res3 = candy(new int[]{2, 2, 1, 2, 2});
		System.out.println(res3);
	}

}