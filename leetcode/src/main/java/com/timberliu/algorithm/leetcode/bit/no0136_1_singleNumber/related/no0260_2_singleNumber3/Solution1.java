package com.timberliu.algorithm.leetcode.bit.no0136_1_singleNumber.related.no0260_2_singleNumber3;

import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III
 *
 *  只出现一次的数字 I —— 对数字异或得到出现一次的值
 *            有两个 —— a. 对数字异或得到两个出现一次的数字的异或值
 *
 *   b. 再把两个数字分到两组中
 *
 *
 *   1. 对所有数字进行异或，得到两个出现一次的数字的异或值
 *   2. 对异或值的任意为 1 的位，根据该位对所有数字进行分组
 *   3. 在两个组内分别进行异或操作，得到两个数字
 *
 * Created by liujie on 2021/8/6
 */

public class Solution1 {

    public static int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        // 从最低位开始，找到第一个为 1 的位
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        // 对两组分别异或
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/single-number-iii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(singleNumber(new int[]{-1, 0})));

        System.out.println("----- 3 -----");
        System.out.println(Arrays.toString(singleNumber(new int[]{0, 1})));

    }
}
