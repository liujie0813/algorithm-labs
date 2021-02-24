package com.timberliu.algorithm.array.no0011_2_containerWithMostWater;

/**
 * 盛最多睡的容器
 *
 *   双指针法
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 *   如何缩小范围？
 *     1. 容积由较短的那个板决定
 *     2. 指针向内移动，x 轴必然会减小
 *       如果移动较长的板，面积也必然会较小
 *       而如果移动较短的板，面积才有可能增大
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] > height[right]) {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            } else {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/container-with-most-water/ -----");
        System.out.println("----- 1 -----");
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int res1 = maxArea(height1);
        System.out.println(res1);

        System.out.println("----- 2 -----");
        int[] height2 = {1,1};
        int res2 = maxArea(height2);
        System.out.println(res2);

        System.out.println("----- 3 -----");
        int[] height3 = {4,3,2,1,4};
        int res3 = maxArea(height3);
        System.out.println(res3);

        System.out.println("----- 4 -----");
        int[] height4 = {1,2,1};
        int res4 = maxArea(height4);
        System.out.println(res4);

    }
}
