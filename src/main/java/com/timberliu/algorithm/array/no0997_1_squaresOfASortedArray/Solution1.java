package com.timberliu.algorithm.array.no0997_1_squaresOfASortedArray;

import java.util.Arrays;

/**
 * 有序数组的平方
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static int[] sortedSquares(int[] nums) {
        if (nums == null) {
            return null;
        }

        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = nums[right] * nums[right];
                right--;
            } else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/squares-of-a-sorted-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {-4,-1,0,3,10};
        int[] ints1 = sortedSquares(nums1);
        System.out.println(Arrays.toString(ints1));

        System.out.println("----- 2 -----");
        int[] nums2 = {-7,-3,2,3,11};
        int[] ints2 = sortedSquares(nums2);
        System.out.println(Arrays.toString(ints2));

        System.out.println("----- 3 -----");
        int[] nums3 = {-5, -3, -2, -1};
        int[] ints3 = sortedSquares(nums3);
        System.out.println(Arrays.toString(ints3));

        System.out.println("----- 4 -----");
        int[] nums4 = {1, 2, 3, 4};
        int[] ints4 = sortedSquares(nums4);
        System.out.println(Arrays.toString(ints4));

        System.out.println("----- 5 -----");
        int[] nums5 = {-1, 0, 0, 0, 1};
        int[] ints5 = sortedSquares(nums5);
        System.out.println(Arrays.toString(ints5));
    }

}
