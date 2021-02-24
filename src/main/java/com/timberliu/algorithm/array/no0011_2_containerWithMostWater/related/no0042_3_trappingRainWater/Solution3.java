package com.timberliu.algorithm.array.no0011_2_containerWithMostWater.related.no0042_3_trappingRainWater;

/**
 * 接雨水
 *
 *   双指针法
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 *   如何一次遍历完成？
 *     1. 什么时候从左向右处理？什么时候从右向左处理？
 *     2. 从左向右遍历时，对于 left 而言，左边的最大值一定是 leftMax，而右边的最大值 "大于等于" rightMax
 *        如果 leftMax < rightMax，就可以知道能存多少水了，无论右边以后是否有更大的 rightMax，都不影响结果
 *        所以，如果 leftMax < rightMax，就处理 left 下标，反之则处理 right 下标
 *
 * Created by liujie on 2021/2/23
 */

public class Solution3 {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sum = 0;
        int left = 1, right = height.length - 2;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (left <= right) {
            if (leftMax < rightMax) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
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
