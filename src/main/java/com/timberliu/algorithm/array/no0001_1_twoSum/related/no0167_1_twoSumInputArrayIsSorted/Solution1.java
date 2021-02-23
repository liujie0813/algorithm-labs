package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0167_1_twoSumInputArrayIsSorted;

import java.util.Arrays;

/**
 * 两数之和 - 有序数组
 *
 *  双指针法
 *    时间复杂度：O(n)
 *    空间复杂度：O(1)
 *
 *  原理
 *    缩减搜索空间
 *    类似于 搜索二维矩阵
 *
 * Created by liujie on 2021/2/22
 */

public class Solution1 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp == target) {
                return new int[]{left + 1, right + 1};
            } else if (tmp < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/ -----");

        System.out.println("----- 1 -----");
        int[] nums1 = {2,7,11,15};
        int[] indexes1 = twoSum(nums1, 9);
        System.out.println(Arrays.toString(indexes1));

        System.out.println("----- 2 -----");
        int[] nums2 = {2, 3, 4};
        int[] indexes2 = twoSum(nums2, 6);
        System.out.println(Arrays.toString(indexes2));

        System.out.println("----- 3 -----");
        int[] nums3 = {-1, 0};
        int[] indexes3 = twoSum(nums3, -1);
        System.out.println(Arrays.toString(indexes3));
    }

}
