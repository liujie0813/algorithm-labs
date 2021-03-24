package com.timberliu.algorithm.binary_search.no0035_1_searchInsertPosition;

/**
 * 35. 搜索插入位置
 *
 *   [left, right) 左闭右开
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/search-insert-position/ -----");
        System.out.println("----- 1 -----");
        int i1 = searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(i1);

        System.out.println("----- 2 -----");
        int i2 = searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(i2);

        System.out.println("----- 3 -----");
        int i3 = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i3);

        System.out.println("----- 4 -----");
        int i4 = searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(i4);
    }
}
