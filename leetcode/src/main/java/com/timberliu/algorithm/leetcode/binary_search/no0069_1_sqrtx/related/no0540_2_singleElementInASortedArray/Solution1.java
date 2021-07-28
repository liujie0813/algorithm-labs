package com.timberliu.algorithm.leetcode.binary_search.no0069_1_sqrtx.related.no0540_2_singleElementInASortedArray;

/**
 * 540. 有序数组中的单一元素
 *
 *   原理？
 *     1. 有序数组，要求时间复杂度 O(lgn)  用二分查找
 *     2. 如果非有序，用遍历一次 ^ 异或法
 *
 * Created by liujie on 2021/3/24
 */

public class Solution1 {

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    public static int singleNonDuplicate1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/single-element-in-a-sorted-array/ -----");
        System.out.println("----- 1 -----");
        System.out.println(singleNonDuplicate1(new int[] {1,1,2,3,3,4,4,8,8}));

        System.out.println("----- 2 -----");
        System.out.println(singleNonDuplicate1(new int[] {3,3,7,7,10,11,11}));

        System.out.println("----- 3 -----");
        System.out.println(singleNonDuplicate1(new int[] {1,1,2,2,3}));

        System.out.println("----- 4 -----");
        System.out.println(singleNonDuplicate1(new int[] {1,1,2,3,3}));

        System.out.println("----- 5 -----");
        System.out.println(singleNonDuplicate(new int[] {1,2,2,3,3}));

    }
}
