package com.timberliu.algorithm.leetcode.stack_queue.no0239_3_slidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 *   单调队列
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution1 {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> queue = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
				queue.pollLast();
			}
			queue.offer(i);
			if (queue.peek() + k <= i) {
				queue.poll();
			}
			if (i >= k - 1) {
				res[i - k + 1] = nums[queue.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/sliding-window-maximum/ -----");
		System.out.println("----- 1 -----");
		int[] nums1 = {1,3,-1,-3,5,3,6,7};
		int[] res1 = maxSlidingWindow(nums1, 3);
		System.out.println(Arrays.toString(res1));

		System.out.println("----- 2 -----");
		int[] nums2 = {7,2,4};
		int[] res2 = maxSlidingWindow(nums2, 2);
		System.out.println(Arrays.toString(res2));

	}
}
