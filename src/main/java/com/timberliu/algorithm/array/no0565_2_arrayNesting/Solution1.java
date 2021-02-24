package com.timberliu.algorithm.array.no0565_2_arrayNesting;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组嵌套
 *
 *    时间复杂度：O(n)
 *    空间复杂度：O(1)
 *
 *    原理？
 *      1. 嵌套数组，从任一节点进去，必然能形成一个环
 *      2. 使用 -1 标记已经访问过的数组
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static int arrayNesting(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int index = i;
                int count = 0;
                while (nums[index] != -1) {
                    int tmp = nums[index];
                    nums[index] = -1;
                    index = tmp;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/array-nesting/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {5, 4, 0, 3, 1, 6, 2};
        int i1 = arrayNesting(nums1);
        System.out.println(i1);

        System.out.println("----- 1 -----");
        int[] nums2 = {1, 0, 2};
        int i2 = arrayNesting(nums2);
        System.out.println(i2);

    }
}
