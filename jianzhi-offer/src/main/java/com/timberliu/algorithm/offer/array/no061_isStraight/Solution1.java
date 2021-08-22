package com.timberliu.algorithm.offer.array.no061_isStraight;

import java.util.Arrays;

/**
 * 61. 扑克牌中的顺子
 *
 *   1. 排序，判断有重复，返回 false
 *   2. max - min 小于等于 4，返回 true
 *
 *  复杂度取决于排序（如快排）
 *    时间复杂度：O(nlogn)
 *    空间复杂度：O(1)
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                return false;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min <= 4;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println("----- https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/ ----- ");
        System.out.println("----- 1 -----");
        System.out.println(solution1.isStraight(new int[]{1, 2, 3, 4, 5}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.isStraight(new int[]{0, 0, 1, 2, 5}));

        System.out.println("----- 3 -----");
        System.out.println(solution1.isStraight(new int[]{4, 7, 5, 9, 2}));
    }

}
