package com.timberliu.algorithm.leetcode.binary_search.no0287_2_findTheDuplicateNumber;

/**
 * 287. 寻找重复数
 *
 *   时间复杂度：O(n）
 *   空间复杂度：O(1)
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int index = nums[i];
                if (index == nums[index - 1]) {
                    return nums[i];
                }
                nums[i] = nums[index - 1];
                nums[index - 1] = index;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-the-duplicate-number/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));

        System.out.println("----- 2 -----");
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));

        System.out.println("----- 3 -----");
        System.out.println(findDuplicate(new int[]{1,1}));

        System.out.println("----- 4 -----");
        System.out.println(findDuplicate(new int[]{1,1,2}));
    }
}
