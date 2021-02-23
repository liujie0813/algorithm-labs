package com.timberliu.algorithm.array.no0001_1_twoSum;

import java.util.Arrays;

/**
 * 暴力破解法
 *  时间复杂度：O(n^2)
 *  空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/22
 */

public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/two-sum/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {2,7,11,15};
        int[] indexes1 = twoSum(nums1, 9);
        System.out.println(Arrays.toString(indexes1));

        System.out.println("----- 2 -----");
        int[] nums2 = {3, 2, 4};
        int[] indexes2 = twoSum(nums2, 6);
        System.out.println(Arrays.toString(indexes2));

        System.out.println("----- 3 -----");
        int[] nums3 = {3, 3};
        int[] indexes3 = twoSum(nums3, 6);
        System.out.println(Arrays.toString(indexes3));
    }

}
