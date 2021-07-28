package com.timberliu.algorithm.leetcode.binary_search.no0852_1_peakIndexInAMountainArray.related.no0162_2_findPeakElement;

/**
 * 162. 寻找峰值
 *
 * Created by liujie on 2021/3/23
 */

public class Solution1 {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-peak-element/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findPeakElement(new int[]{1,2,3,1}));

        System.out.println("----- 1 -----");
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
