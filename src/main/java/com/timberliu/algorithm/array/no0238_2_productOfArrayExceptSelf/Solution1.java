package com.timberliu.algorithm.array.no0238_2_productOfArrayExceptSelf;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1) 不考虑返回结果的空间
 *
 *   原理？
 *     1. 当前索引的结果 = 索引左侧乘积的结果 * 索引右侧乘积的结果
 *     2. 遍历两次
 *        1. 第一次遍历，计算左边乘积的结果（当前索引位置处存储左边乘积的结果）
 *        2 第二次遍历，计算最终结果（与索引右边乘积相乘）
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }

        // 先存储左边乘积的结果
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 当前结果 = 左边乘积的结果 * 右边乘积的结果
            res[i] = res[i] * right;
            // 更新右边乘积的结果
            right = nums[i] * right;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/product-of-array-except-self/ -----");
        System.out.println("----- 1 -----");
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

}
