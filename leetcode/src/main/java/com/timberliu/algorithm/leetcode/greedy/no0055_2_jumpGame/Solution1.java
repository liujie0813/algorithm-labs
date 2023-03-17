package com.timberliu.algorithm.leetcode.greedy.no0055_2_jumpGame;

/**
 * 55. 跳跃游戏
 *
 *   暴力解法：超出时间限制
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int curIndex) {
        if (curIndex > nums.length - 1) {
            return false;
        }
        if (curIndex == nums.length - 1) {
            return true;
        }
        for (int i = nums[curIndex]; i >= 1; i--) {
            if (canJump(nums, curIndex + i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/jump-game/ -----");
        Solution1 solution1 = new Solution1();
        System.out.println("----- 1 -----");
        System.out.println(solution1.canJump(new int[]{3, 2, 1, 0, 4}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.canJump(new int[]{2, 3, 1, 1, 4}));
    }

}
