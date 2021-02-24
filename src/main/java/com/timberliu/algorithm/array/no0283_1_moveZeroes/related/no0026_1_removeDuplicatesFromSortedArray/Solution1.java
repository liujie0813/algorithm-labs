package com.timberliu.algorithm.array.no0283_1_moveZeroes.related.no0026_1_removeDuplicatesFromSortedArray;

/**
 * 删除排序数组中的重复项
 *
 *  一次遍历法
 *    时间复杂度：O(n)
 *    空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int i = 0;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            } else {
                nums[index++] = nums[i++];
            }
        }
        return index;
    }

    public static int removeDuplicates1(int[] nums) {
        int index = 0;
        int i = 0;
        while (i < nums.length) {
            nums[index++] = nums[i++];
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1, 1, 2};
        int len1 = removeDuplicates(nums1);
        System.out.println(len1);

        System.out.println("----- 2 -----");
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = removeDuplicates(nums2);
        System.out.println(len2);

        System.out.println("----- 3 -----");
        int[] nums3 = {1, 1, 1, 1, 2};
        int len3 = removeDuplicates1(nums3);
        System.out.println(len3);
    }
}
