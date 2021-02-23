package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0016_2_3sumClosest;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 *   遍历+双指针法
 *     时间复杂度：O(n^2)
 *     空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int closestNum = nums[0] + nums[1] + nums[2];
        int closestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == target) {
                    return tmp;
                }
                if (Math.abs(target - tmp) < closestDiff) {
                    closestNum = tmp;
                    closestDiff = Math.abs(target - tmp);
                }
                if (tmp < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestNum;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/3sum-closest/ -----");
        System.out.println("----- 1 -----");
        int[] nums = {-1, 2, 1, -4};
        int num = threeSumClosest(nums, 1);
        System.out.println(num);

    }
}
