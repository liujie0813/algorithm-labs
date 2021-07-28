package com.timberliu.algorithm.leetcode.sort.no0075_2_sortColors;

import java.util.Arrays;

/**
 * Created by liujie on 2021/4/20
 */

public class Solution2 {

    public static void sortColors(int[] nums) {
        // 桶排序
        int[] bucket = new int[3];
        for (int num : nums) {
            bucket[num]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sort-colors/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {2,0,2,1,1,0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));

        System.out.println("----- 2 -----");
        int[] nums2 = {2,0,1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

        System.out.println("----- 3 -----");
        int[] nums3 = {0};
        sortColors(nums3);
        System.out.println(Arrays.toString(nums3));

    }
}
