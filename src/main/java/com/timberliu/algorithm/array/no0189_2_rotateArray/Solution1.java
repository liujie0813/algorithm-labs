package com.timberliu.algorithm.array.no0189_2_rotateArray;

import java.util.Arrays;

/**
 * 旋转数组
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    /**
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    /**
     *  时间复杂度：O(n)
     *  空间复杂度：O(k)
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        k = k % nums.length;
        int[] aux = new int[k];
        int index = k - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= nums.length - k) {
                aux[index--] = nums[i];
            } else {
                nums[i + k] = nums[i];
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/rotate-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate2(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        System.out.println("----- 2 -----");
        int[] nums2 = {-1,-100,3,99};
        rotate2(nums2, 2);
        System.out.println(Arrays.toString(nums2));

        System.out.println("----- 3 -----");
        int[] nums3 = {-1};
        rotate2(nums3, 2);
        System.out.println(Arrays.toString(nums3));
    }
}
