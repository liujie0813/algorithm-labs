package com.timberliu.algorithm.cracking.module16.no11_1_divingBoard;

import java.util.Arrays;

/**
 * 面试题 16.11. 跳水板
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            res[i] = (k - i) * shorter + i * longer;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/diving-board-lcci/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(divingBoard(1, 2, 3)));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(divingBoard(1, 1, 100000)));

    }
}
