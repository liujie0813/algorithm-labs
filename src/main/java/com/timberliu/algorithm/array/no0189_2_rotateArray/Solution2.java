package com.timberliu.algorithm.array.no0189_2_rotateArray;

import java.util.Arrays;

/**
 * 旋转数组
 *
 *   使用反转
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/25
 */

public class Solution2 {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private static void swap(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/rotate-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        System.out.println("----- 2 -----");
        int[] nums2 = {-1,-100,3,99};
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));

        System.out.println("----- 3 -----");
        int[] nums3 = {-1};
        rotate(nums3, 2);
        System.out.println(Arrays.toString(nums3));
    }
}
