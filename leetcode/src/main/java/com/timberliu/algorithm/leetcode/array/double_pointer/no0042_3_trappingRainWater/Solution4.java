package com.timberliu.algorithm.leetcode.array.double_pointer.no0042_3_trappingRainWater;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 *
 * 单调栈解法
 *
 *  栈存储可能储水的最长的条形块
 *
 * @author liujie
 * @date 2021/9/7
 */

public class Solution4 {

	public static int trap(int[] height) {
		Deque<Integer> stack = new LinkedList<>();
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				Integer top = stack.pop();
				if (stack.isEmpty()) {
					// 前面没有更高的柱子，水流走了
					break;
				}
				// 相当于每次横切，计算面积
				int distance = i - stack.peek() - 1;
				int boundHeight = Math.min(height[i], height[stack.peek()]) - height[top];
				sum += distance * boundHeight;
			}
			stack.push(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/trapping-rain-water/ -----");
		System.out.println("----- 1 -----");
		System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

		System.out.println("----- 2 -----");
		System.out.println(trap(new int[]{4,2,0,3,2,5}));

	}

}
