package com.timberliu.algorithm.leetcode.bit.no0136_1_singleNumber;

/**
 * 136. 只出现一次的数字
 *
 * Created by liujie on 2021/8/6
 */

public class Solution1 {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 出现两次的 num 异或运算结果为 0
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/single-number/ -----");
        System.out.println("----- 1 -----");
        System.out.println(singleNumber(new int[]{2, 2, 1}));

        System.out.println("----- 2 -----");
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));

    }
}
