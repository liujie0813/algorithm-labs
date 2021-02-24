package com.timberliu.algorithm.array.no0011_2_containerWithMostWater.related.no0042_3_trappingRainWater;

/**
 * 接雨水
 *
 *   动态编程法
 *     时间复杂度：O(n)
 *     空间复杂度：O(n)
 *
 *   原理？
 *     暴力破解法中遍历数组时，每次都要计算向左、向右的最大值
 *     1. 可以事先遍历数组计算出最大值存储起来
 *     2. 再遍历迭代即可
 *
 * Created by liujie on 2021/2/23
 */

public class Solution2 {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/trapping-rain-water/ -----");
        System.out.println("----- 1 -----");
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap1 = trap(height1);
        System.out.println(trap1);

        System.out.println("----- 2 -----");
        int[] height2 = {4,2,0,3,2,5};
        int trap2 = trap(height2);
        System.out.println(trap2);

    }
}
