package com.timberliu.algorithm.binary_search.no0852_1_peakIndexInAMountainArray;

/**
 * 852. 山脉数组的峰顶索引
 *
 * Created by liujie on 2021/3/23
 */

public class Solution1 {

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 不是第一个
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/ -----");
        System.out.println("----- 1 -----");
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));

        System.out.println("----- 2 -----");
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));

        System.out.println("----- 3 -----");
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));

        System.out.println("----- 4 -----");
        System.out.println(peakIndexInMountainArray(new int[]{3, 4, 5, 1}));

        System.out.println("----- 5 -----");
        System.out.println(peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));

        System.out.println("----- 6 -----");
        System.out.println(peakIndexInMountainArray(new int[]{100,99,79,78,67,36,26,19}));

        System.out.println("----- 7 -----");
        System.out.println(peakIndexInMountainArray(new int[]{19,24,69,100}));

    }
}
