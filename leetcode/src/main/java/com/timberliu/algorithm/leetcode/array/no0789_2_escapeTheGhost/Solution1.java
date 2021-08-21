package com.timberliu.algorithm.leetcode.array.no0789_2_escapeTheGhost;

/**
 * 789. 逃脱阻碍者
 *
 *   曼哈顿距离：用 dist(a, b) 表示 a 点和 b 点的曼哈顿距离
 *             dist(a, B) = |Xa - Xb| + |Ya - Yb|
 *
 *   1. 如果有一个阻碍者和目的地的曼哈顿距离 小于 玩家和目的地的曼哈顿距离，则该阻碍者可以在玩家之前到达目的地
 *   2. 如果有一个阻碍者和目的地的曼哈顿距离 等于 玩家和目的地的曼哈顿距离，则该阻碍者可以和玩家同时到达目的地
 *   3. 如果所有的阻碍者和目的地的曼哈顿距离 都大于 玩家和目的地的曼哈顿距离，则玩家可以在阻碍者之前到达目的地
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] start = {0, 0};
        int instance = manhattanDistance(start, target);
        for (int i = 0; i < ghosts.length; i++) {
            int ghostInstance = manhattanDistance(ghosts[i], target);
            if (ghostInstance <= instance) {
                return false;
            }
        }
        return true;
    }

    private int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/escape-the-ghosts/ -----");
        Solution1 solution1 = new Solution1();
        System.out.println("----- 1 -----");
        System.out.println(solution1.escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.escapeGhosts(new int[][]{{1, 0}}, new int[]{2, 0}));

        System.out.println("----- 3 -----");
        System.out.println(solution1.escapeGhosts(new int[][]{{2, 0}}, new int[]{1, 0}));

        System.out.println("----- 4 -----");
        System.out.println(solution1.escapeGhosts(new int[][]{{5, 0}, {-10, -2}, {0, -5}, {-2, -2}, {-7, 1}}, new int[]{7, 7}));

        System.out.println("----- 5 -----");
        System.out.println(solution1.escapeGhosts(new int[][]{{-1, 0}, {0, 1}, {-1, 0}, {0, 1}, {-1, 0}}, new int[]{0, 0}));

    }

}
