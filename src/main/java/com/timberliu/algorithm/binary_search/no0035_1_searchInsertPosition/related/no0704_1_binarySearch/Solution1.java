package com.timberliu.algorithm.binary_search.no0035_1_searchInsertPosition.related.no0704_1_binarySearch;

/**
 * 704. 二分查找
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-search/ -----");
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
