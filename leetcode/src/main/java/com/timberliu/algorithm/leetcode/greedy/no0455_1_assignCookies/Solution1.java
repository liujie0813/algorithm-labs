package com.timberliu.algorithm.leetcode.greedy.no0455_1_assignCookies;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 455. 分发饼干
 *
 *  局部最优
 *
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	/**
	 * 局部最优：小饼干先喂饱小胃口
	 *
	 *   胃口： 1  3  5
	 *   饼干： 2  4  6
	 *         ->
	 */
	public int findContentChildren(int[] g, int[] s) {
		int child = 0, cookies = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		while (child < g.length && cookies < s.length) {
			if (g[child] <= s[cookies]) {
				child++;
			}
			cookies++;
		}
		return child;
	}

	/**
	 * 局部最优：大胃口先吃大饼干
	 *
	 *  饼干： 2   4   6
	 *  胃口： 3   5   7
	 *                <-
	 */
	public int findContentChildren1(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int child = g.length - 1, cookies = s.length - 1;
		int result = 0;
		while (child >= 0 && cookies >= 0) {
			if (g[child] <= s[cookies]) {
				result++;
				cookies--;
			}
			child--;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/assign-cookies/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findContentChildren1(new int[]{1, 2, 3}, new int[]{1, 1}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.findContentChildren1(new int[]{1, 2}, new int[]{1, 2, 3}));

	}

}
