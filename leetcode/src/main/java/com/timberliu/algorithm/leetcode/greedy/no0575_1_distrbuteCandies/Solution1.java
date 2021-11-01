package com.timberliu.algorithm.leetcode.greedy.no0575_1_distrbuteCandies;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 *
 *
 *
 * @author Timber
 * @date 2021/11/1
 */
public class Solution1 {

	public int distributeCandies(int[] candyType) {
		Set<Integer> set = new HashSet<>();
		for (int i : candyType) {
			set.add(i);
		}
		return Math.min(candyType.length / 2, set.size());
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/distribute-candies/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.distributeCandies(new int[]{1, 1, 2, 3}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.distributeCandies(new int[]{6, 6, 6, 6}));

	}

}
