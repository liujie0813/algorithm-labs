package com.timberliu.algorithm.leetcode.greedy.no0455_1_assignCookies;

import java.util.Arrays;

/**
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

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

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/assign-cookies/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));

	}

}
