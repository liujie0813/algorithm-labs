package com.timberliu.algorithm.array.no0001_1_twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一遍哈希
 *  时间复杂度：O(n）
 *  空间复杂度：O(n)
 *
 * Created by liujie on 2021/2/22
 */

public class Solution2 {

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (indexMap.containsKey(tmp)) {
                return new int[]{indexMap.get(tmp), i};
            }

            indexMap.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/two-sum/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {2,7,11,15};
        int[] indexes1 = twoSum1(nums1, 9);
        System.out.println(Arrays.toString(indexes1));

        System.out.println("----- 2 -----");
        int[] nums2 = {3, 2, 4};
        int[] indexes2 = twoSum1(nums2, 6);
        System.out.println(Arrays.toString(indexes2));

        System.out.println("----- 3 -----");
        int[] nums3 = {3, 3};
        int[] indexes3 = twoSum1(nums3, 6);
        System.out.println(Arrays.toString(indexes3));
    }

}
