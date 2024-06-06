package com.timberliu.algorithm.leetcode.sort.no0215_2_kthLargestElementInAnArray;

/**
 * 215. 数组中的第K个最大元素
 *
 *  原理：
 *   1. 建立最大堆
 *   2. 在堆排序过程中，将最大元素交换到末尾，下沉时不再考虑
 *      在排除 n-1 个元素后，堆顶元素就是要查找的第 n 个元素，
 *
 *      0
 *      1    2
 *      3 4  5 6
 *
 * Created by liujie on 2021/4/8
 */

public class Solution3 {

    public static int findKthLargest(int[] nums, int k) {
        int N = nums.length - 1;
        buildMaxHeap(nums, N);
        for (int i = N; i > nums.length - k;) {
            swap(nums, 0, i);
            sink(nums, 0, --i);
        }
        return nums[0];
    }

    private static void buildMaxHeap(int[] arr, int N) {
        for (int i = N / 2; i >= 0; i--) {
            sink(arr, i, N);
        }
    }

    private static void sink(int[] arr, int k, int N) {
        while (k * 2 + 1 <= N) {
            int j = k * 2 + 1;
            if (j + 1 <= N && arr[j] < arr[j + 1]) {
                j += 1;
            }
            if (arr[k] > arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
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
