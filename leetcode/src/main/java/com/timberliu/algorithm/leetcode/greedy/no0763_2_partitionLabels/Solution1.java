package com.timberliu.algorithm.leetcode.greedy.no0763_2_partitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public List<Integer> partitionLabels(String s) {
		int[] last = new int[26];
		for (int i = 0; i < s.length(); i++) {
			last[s.charAt(i) - 'a'] = i;
		}
		List<Integer> res = new ArrayList<>();
		// end：已经出现过的字符 的最远边界
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			end = Math.max(end, last[s.charAt(i) - 'a']);
			if (i == end) {
				res.add(end - start + 1);
				start = i + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/partition-labels/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<Integer> res1 = solution1.partitionLabels("ababcbacadefegdehijhklij");
		for (Integer res : res1) {
			System.out.print(res + ", ");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<Integer> res2 = solution1.partitionLabels("ababacadefegdehijh");
		for (Integer res : res2) {
			System.out.print(res + ", ");
		}
		System.out.println();

	}

}
