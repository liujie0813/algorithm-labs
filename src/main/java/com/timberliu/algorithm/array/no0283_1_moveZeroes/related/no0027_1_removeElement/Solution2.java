package com.timberliu.algorithm.array.no0283_1_moveZeroes.related.no0027_1_removeElement;

/**
 * 移除元素
 *
 *  一次遍历：
 *    时间复杂度：O(n)
 *    空间复杂度：O(1)
 *
 *  使用要删除的元素特别少的情况
 *
 * Created by liujie on 2021/2/24
 */

public class Solution2 {

    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/remove-element/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {3,2,2,3};
        int len1 = removeElement(nums1, 3);
        System.out.println(len1);

        System.out.println("----- 2 -----");
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int len2 = removeElement(nums2, 3);
        System.out.println(len2);
    }
}
