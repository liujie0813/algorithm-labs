package com.timberliu.algorithm.binary_search.no0287_2_findTheDuplicateNumber;

/**
 * 287. 寻找重复数
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   题解：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 *   二分查找思路：35 题解
 *
 * Created by liujie on 2021/3/18
 */

public class Solution3 {

    public static int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-the-duplicate-number/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findDuplicate2(new int[]{1,5,3,5,2}));

        System.out.println("----- 2 -----");
        System.out.println(findDuplicate2(new int[]{3,1,3,4,2}));

        System.out.println("----- 3 -----");
        System.out.println(findDuplicate2(new int[]{1,1}));

        System.out.println("----- 4 -----");
        System.out.println(findDuplicate2(new int[]{1,1,2}));
    }
}
