package com.timberliu.algorithm.leetcode.greedy.no0763_2_partitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 *
 *  找每一个字母的最远边界，如果找到之前遍历过的所有字母的最远边界，说明这个点就是边界了
 *
 *  1. 遍历得到每个字符最后一次出现的下标位置
 *  2. 遍历，更新字符出现的最远位置，如果最远位置和当前位置相等了，则找到了分割点
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public List<Integer> partitionLabels(String s) {
		// 只有小写字母
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
				// 返回每个字符串片段的长度
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
