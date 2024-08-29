package com.timberliu.algorithm.leetcode.array.no0485_1_maxConsecutiveOnes.related.no1004_2_maxConsecutiveOnesIii;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1004. 最大连续 1 的个数 iii
 *
 * @author liujie
 * @date 2024/8/28
 */

public class Solution1 {

	public int longestOnes(int[] nums, int k) {
		int max = 0;
		int start = 0, end = 0;
		Deque<Integer> deque = new LinkedList<>();
		while (end < nums.length) {
			if (nums[end] == 0) {
				if (k == 0 && !deque.isEmpty()) {
					start = deque.pollFirst() + 1;
					k++;
				}
				if (k > 0) {
					deque.add(end);
					k--;
				} else {
					start = end + 1;
				}
			}
			max = Math.max(end - start + 1, max);
			end++;
		}
		return max;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[] nums1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int res = solution1.longestOnes(nums1, 3);
		System.out.println(res);

		int[] nums2 = {1,1,1,0,0,0,1,1,1,1,0};
		int res2 = solution1.longestOnes(nums2, 2);
		System.out.println(res2);
	}

}
