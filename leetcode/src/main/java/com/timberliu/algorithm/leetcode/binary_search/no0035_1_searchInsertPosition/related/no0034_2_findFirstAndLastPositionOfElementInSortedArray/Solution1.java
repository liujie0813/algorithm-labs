package com.timberliu.algorithm.leetcode.binary_search.no0035_1_searchInsertPosition.related.no0034_2_findFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 *  二分法分别查找元素第一个和最后一个位置
 *
 *  二分法
 *  1. 如果 target 在右区间，则 left = mid + 1
 *  2. 如果 target 在左区间，则 right = mid - 1
 *  3. 如果 target = arr[mid]，则判断是否为第一个/最后一个元素，或者前一个/后一个元素等于 target
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = firstElementIndex(nums, target);
        res[1] = lastElementIndex(nums, target);
        return res;
    }

    private static int firstElementIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 如果已经为第一个元素，或者前一个元素不等，则返回 mid
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                // 前一个元素相等，右边界左移
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int lastElementIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 如果已经是最后一个元素，或者后一个元素不等，则返回 mid
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                // 后一个元素相等，左边界右移
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));

        System.out.println("----- 3 -----");
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));

        System.out.println("----- 4 -----");
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));

    }
}
