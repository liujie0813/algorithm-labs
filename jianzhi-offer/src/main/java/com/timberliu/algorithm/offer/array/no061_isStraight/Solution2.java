package com.timberliu.algorithm.offer.array.no061_isStraight;

import java.util.HashSet;
import java.util.Set;

/**
 * 61. 扑克牌中的顺子
 *
 *   1. set 判断有重复，返回 true
 *   2. 否则，max - min <= 4，就是顺子
 *
 *  时间复杂度：O(n)
 *  空间复杂度：O(n)
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution2 {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min <= 4;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println("----- https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/ ----- ");
        System.out.println("----- 1 -----");
        System.out.println(solution2.isStraight(new int[]{1, 2, 3, 4, 5}));

        System.out.println("----- 2 -----");
        System.out.println(solution2.isStraight(new int[]{0, 0, 1, 2, 5}));

        System.out.println("----- 3 -----");
        System.out.println(solution2.isStraight(new int[]{4, 7, 5, 9, 2}));
    }

}
