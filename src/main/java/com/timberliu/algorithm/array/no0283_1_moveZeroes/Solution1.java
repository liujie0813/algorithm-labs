package com.timberliu.algorithm.array.no0283_1_moveZeroes;

import java.util.Arrays;

/**
 * 移动零
 *
 *   两次遍历、一次遍历
 *     时间复杂度：O(n）
 *     空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/move-zeroes/ -----");
        System.out.println("----- 1 -----");
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
