package com.timberliu.algorithm.leetcode.bit.no0136_1_singleNumber.related.no0268_1_missingNumber;

/**
 * 268. 丢失的数字
 *
 * Created by liujie on 2021/8/6
 */

public class Solution1 {

    public static int missingNumber(int[] nums) {
        int result = 0;
        // 0-n 异或
        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }
        // 和 nums 数组中所有元素异或后，结果为未出现的那个数字
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/missing-number/ -----");
        System.out.println("----- 1 -----");
        System.out.println(missingNumber(new int[]{3, 0, 1}));

        System.out.println("----- 2 -----");
        System.out.println(missingNumber(new int[]{0, 1}));

        System.out.println("----- 3 -----");
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

        System.out.println("----- 4 -----");
        System.out.println(missingNumber(new int[]{0}));

    }
}
