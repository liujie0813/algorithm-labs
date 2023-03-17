package com.timberliu.algorithm.leetcode.greedy.no0055_2_jumpGame;

/**
 * 55. 跳跃游戏
 *
 *  贪心：
 *    局部最优：每次取最大的跳跃步数（取最大覆盖范围）
 *    全局最优：最大覆盖范围是否可以到终点
 *
 *  关键：不拘泥于究竟跳几步，而是看覆盖范围
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution2 {

    public boolean canJump(int[] nums) {
        // 最远可以到达的距离
        int dist = 0;
        for (int i = 0; i < nums.length; i++) {
            // i <= dist，当前位置可以到达
            if (i <= dist) {
                // 更新最远位置
                dist = Math.max(dist, i + nums[i]);
                // 如果可以达到，直接返回
                if (dist >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        // 最远可以到达的距离
        int dist = 0;
        for (int i = 0; i <= dist; i++) {
            // 更新最远位置
            dist = Math.max(dist, i + nums[i]);
            // 如果可以达到，直接返回
            if (dist >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/jump-game/ -----");
        Solution2 solution1 = new Solution2();
        System.out.println("----- 1 -----");
        System.out.println(solution1.canJump(new int[]{3, 2, 1, 0, 4}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.canJump(new int[]{2, 3, 1, 1, 4}));
    }

}
