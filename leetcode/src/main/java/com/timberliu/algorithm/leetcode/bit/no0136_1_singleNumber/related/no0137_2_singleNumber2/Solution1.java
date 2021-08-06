package com.timberliu.algorithm.leetcode.bit.no0136_1_singleNumber.related.no0137_2_singleNumber2;

/**
 * 137. 只出现一次的数字 II
 *
 *  第 i 个二进制位，可能为 0 或 1
 *  答案的第 i 个二进制位 是 数组中所有元素的第 i 个二进制位之和除以 3 的余数
 *
 * Created by liujie on 2021/8/6
 */

public class Solution1 {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        // 32 位整数
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                // num 的第 i 个二进制位
                // 与（取第 i 位）
                sum += (num >> i) & 1;
            }
            // 相加后取余
            if (sum % 3 != 0) {
                // 或（对第 i 位置为 1）
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/single-number-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));

        System.out.println("----- 2 -----");
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));

    }
}
