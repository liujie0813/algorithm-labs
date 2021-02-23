package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0018_2_4sum;

import java.util.*;

/**
 * 四数之和
 *
 *   双层遍历+双指针法
 *     时间复杂度：O(n^3)
 *     空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        // [-2, -1, 0, 0, 1, 2]
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target1 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int target2 = target1 - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int tmp = nums[left] + nums[right];
                    if (tmp == target2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);
                    } else if (tmp < target2) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/4sum/ -----");
        System.out.println("----- 1 -----");
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);

    }
}
