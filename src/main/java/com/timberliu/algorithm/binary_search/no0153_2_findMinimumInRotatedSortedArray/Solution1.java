package com.timberliu.algorithm.binary_search.no0153_2_findMinimumInRotatedSortedArray;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 *   原理？
 *     情况：a. 1,2,3,4,5,6,7
 *             递增：left < mid < right，收缩右边界
 *          b. 6,7,1,2,3,4,5
 *             旋转1：left > mid, mid < right, 收缩右边界
 *          c. 3,4,5,6,7,1,2
 *             旋转2：left < mid, mid > right, 收缩左边界

 *     1. mid < right, 收缩右边界，right = mid
 *     2. mid > right, 收缩左边界，left = mid + 1
 *     3. 需要检查具体值，left = 0, right = n - 1
 *     4. 退出条件 left < right，取例分析，如 1、2、3 个数
 *          d. 2,1
 *             left=0,right=1,mid=0  nums[mid]>nums[right]
 *             -> left=1,right=1 退出取 nums[left]
 *          e. 1,2
 *             left=0,right=1,mid=0  nums[mid]<nums[right]
 *             -> left=0,right=0 退出取 nums[left]
 *
 * Created by liujie on 2021/3/19
 */

public class Solution1 {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }



    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findMin(new int[]{1,2,3,4,5,6,7}));

        System.out.println("----- 2 -----");
        System.out.println(findMin(new int[]{6,7,1,2,3,4,5}));

        System.out.println("----- 4 -----");
        System.out.println(findMin(new int[]{3,4,5,6,7,1,2}));

        System.out.println("----- 5 -----");
        System.out.println(findMin(new int[]{2,1}));
    }
}
