package com.timberliu.algorithm.leetcode.binary_search.no0153_2_findMinimumInRotatedSortedArray.related.no0081_2_searchInRotatedSortedArray2;

/**
 *  81. 搜索旋转排序数组 II
 *
 *     原理？
 *       a. 3,4,5,6,0,1,2
 *          left < mid, mid > right
 *       b. 5,6,0,1,2,3,4
 *          left > mid, mid < right
 *          target > left, target
 *       c. 0,1,2,3,4,5,6
 *          left < mid, mid < right
 *
 *       e. 1, 1, 1, 0, 1
 *
 *       f. 1, 0, 1, 1, 1
 *
 * Created by liujie on 2021/3/19
 */

public class Solution1 {

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 0));

        System.out.println("----- 2 -----");
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 3));

    }
}
