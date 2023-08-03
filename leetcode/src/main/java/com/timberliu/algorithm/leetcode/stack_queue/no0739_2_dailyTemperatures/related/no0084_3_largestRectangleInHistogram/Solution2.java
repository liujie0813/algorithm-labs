package com.timberliu.algorithm.leetcode.stack_queue.no0739_2_dailyTemperatures.related.no0084_3_largestRectangleInHistogram;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 *
 *  单调栈：柱子高度递增
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution2 {

	public static int largestRectangleArea(int[] heights) {
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		// 右边没有小于 height[i] 的元素，填充为 heights.length 位置
		Arrays.fill(right, heights.length);

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < heights.length; i++) {
			// 右边最近的小于 height[i] 的元素
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				right[stack.peek()] = i;
				stack.pop();
			}
			// 栈为空，左边元素都大于 height[i]，可以认为左边最近的小于 height[i] 的元素在 -1 位置
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		int res = 0;
		for (int i = 0; i < heights.length; i++) {
			res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/largest-rectangle-in-histogram/ -----");
		System.out.println("----- 1 -----");
		// 最大值为 i=5 时
		System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));

		System.out.println("----- 2 -----");
		System.out.println(largestRectangleArea(new int[]{2,4}));

	}
}
