package com.timberliu.algorithm.leetcode.sort.no0215_2_kthLargestElementInAnArray;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 *
 *  原理：
 *   1. 从大到小排序
 *   2. 确定第 k 个元素就退出
 *
 * Created by liujie on 2021/4/8
 */

public class Solution2 {

    private static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] arr, int left, int right, int index) {
        int q = randomPivot(arr, left, right);
        if (q == index - 1) {
            return arr[q];
        } else if (q > index - 1) {
            return quickSelect(arr, left, q - 1, index);
        } else {
            return quickSelect(arr, q + 1, right, index);
        }
    }

    private static int randomPivot(int[] arr, int left, int right) {
        int pivot = random.nextInt(right - left + 1) + left;
        swap(arr, pivot, right);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right], i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] > pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/kth-largest-element-in-an-array/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));

        System.out.println("----- 2 -----");
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        System.out.println("----- 3 -----");
        System.out.println(findKthLargest(new int[]{7,6,5,4,3,2,1}, 5));

        System.out.println("----- 4 -----");
        System.out.println(findKthLargest(new int[]{1}, 1));

    }
}
