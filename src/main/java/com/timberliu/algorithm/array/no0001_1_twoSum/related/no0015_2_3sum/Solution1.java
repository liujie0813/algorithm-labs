package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0015_2_3sum;

import java.util.*;

/**
 * 三数之和
 *
 *   遍历+一遍哈希
 *     时间复杂度：O(n^2)
 *     空间复杂度：O(n)
 *
 *   如何排除重复组合？
 *     1. 如果无序数组，一般需要先排序
 *     2. 排除重复一般是在遍历时判断元素相同则跳过（剪枝）
 *        注意：特殊情况，需要判断是与前一个比较，还是与后一个比较
 *
 *   [0, 0, 0]
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

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

            int target = 0 - nums[i];
            Set<Integer> numSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                // 排除重复组合
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    numSet.add(nums[j]);
                    continue;
                }

                int tmp = target - nums[j];
                if (numSet.contains(tmp)) {
                    res.add(Arrays.asList(nums[i], tmp, nums[j]));
                } else {
                    numSet.add(nums[j]);
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
