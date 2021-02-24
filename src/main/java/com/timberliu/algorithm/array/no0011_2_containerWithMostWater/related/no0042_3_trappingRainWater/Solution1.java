package com.timberliu.algorithm.array.no0011_2_containerWithMostWater.related.no0042_3_trappingRainWater;

/**
 * 接雨水
 *
 *   暴力破解法
 *     时间复杂度：O(n^2)
 *     空间复杂度：O(1)
 *
 *   原理？
 *     1. 遍历数组
 *     2. 分别向左、向右找到最大值 maxLeft、maxRight
 *     3. maxLeft、maxRight 中的较小者与 height[i] 的差值就是该 index 能接到的雨水量
 *
 *   遇到困难的题目，一般很难想到解题方法，可以尝试暴力破解法，打开思路，再考虑优化
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = height[i];
            int maxRight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            sum += Math.min(maxLeft, maxRight) - height[i];
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
