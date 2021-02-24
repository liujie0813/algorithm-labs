package com.timberliu.algorithm.array.no0645_1_setMismatch;

import java.util.Arrays;

/**
 * 错误的集合
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 由于数值范围为 [1, 10000]，通过交换进行排序，从而 除了重复元素外，其他元素都在正确的位置上，而且重复元素出现在丢失元素的位置上
 *       具体：如果当前元素不在正确的位置 nums[i] != i + 1
 *            且 当前元素和 它应该在的位置的元素 不相等，nums[i] != nums[nums[i] - 1]
 *            则交换元素，继续判断
 *     2. 排序后，遍历数组，如果 nums[i] != i + 1，则当前元素为重复元素，i+1 为丢失元素
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    // [3, 2, 3, 4, 5, 6]
    // [4, 1, 5, 3, 2, 6]
    //
    public static int[] findErrorNums1(int[] nums) {
        if (nums == null) {
            return new int[2];
        }
        for (int i = 0; i < nums.length; i++) {
            // 1. 如果当前元素不在正确的位置
            // 2. 如果当前元素和 它应该在的位置的元素 不相等
            // 则交换元素
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/set-mismatch/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1,2,2,4};
        int[] errorNums1 = findErrorNums1(nums1);
        System.out.println(Arrays.toString(errorNums1));

        System.out.println("----- 2 -----");
        int[] nums2 = {1,1};
        int[] errorNums2 = findErrorNums1(nums2);
        System.out.println(Arrays.toString(errorNums2));

        System.out.println("----- 3 -----");
        int[] nums3 = {3,2,3,4,6,5};
        int[] errorNums3 = findErrorNums1(nums3);
        System.out.println(Arrays.toString(errorNums3));

    }
}
