package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0015_2_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 *   遍历 + 双指针法
 *     时间复杂度：O(n^2)
 *     空间复杂度：O(1)
 *
 *   一遍哈希法和双指针法在排除重复组合时不同？
 *     由特殊情况 [0, 0, 0] 决定
 *     1. 一遍哈希：先跳过重复（仍会存放），后计算
 *     2. 双指针：先计算，后跳过重复
 *
 * Created by liujie on 2021/2/23
 */

public class Solution2 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 排除重复组合
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 排除重复组合
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int tmp = nums[left] + nums[right];
                if (tmp == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (tmp > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 排除重复组合
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (tmp > target) {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/3sum/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> lists1 = threeSum(nums1);
        System.out.println(lists1);

        System.out.println("----- 2 -----");
        int[] nums2 = {};
        List<List<Integer>> lists2 = threeSum(nums2);
        System.out.println(lists2);

        System.out.println("----- 3 -----");
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> lists3 = threeSum(nums3);
        System.out.println(lists3);
    }
}
