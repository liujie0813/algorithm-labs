package com.timberliu.algorithm.leetcode.sort.no0075_2_sortColors;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 *   经典的荷兰国旗问题
 *
 * Created by liujie on 2021/4/20
 */

public class Solution1 {

    public static void sortColors(int[] nums) {
        // [left, right]
        int left = 0, right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                // 如果 cur 为 0，交换到开头 left
                nums[cur] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[cur] == 2) {
                // 如果 cur 为 2，交换到末尾 right
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
                // 交换后如果 不为 1，继续判断
                if (nums[cur] != 1) {
                    cur--;
                }
            }
            cur++;
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
