package com.timberliu.algorithm.leetcode.sort.no0215_2_kthLargestElementInAnArray;

/**
 * 215. 数组中的第K个最大元素
 *
 *  原理：
 *   1. 快速排序：从大到小排序
 *   2. 不用全部排序，只需确定第 k 个元素时退出
 *
 * Created by liujie on 2021/4/8
 */

public class Solution1 {

    public static int findKthLargest(int[] nums, int k) {
        // [left, right]
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private static int findKthLargest(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[left];
        }
        int pivot = pivot(nums, left, right);
        if (pivot == k - 1) {
            return nums[pivot];
        } else if (pivot > k - 1) {
            return findKthLargest(nums, left, pivot - 1, k);
        } else {
            return findKthLargest(nums, pivot + 1, right, k);
        }
    }

    private static int pivot(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left, j = right + 1;
        while (true) {
            while (nums[++i] > pivot && i < right) {
            }
            while (nums[--j] < pivot && j > left) {
            }
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
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
