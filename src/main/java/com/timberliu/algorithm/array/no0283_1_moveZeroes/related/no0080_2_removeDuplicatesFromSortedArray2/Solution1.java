package com.timberliu.algorithm.array.no0283_1_moveZeroes.related.no0080_2_removeDuplicatesFromSortedArray2;

/**
 * 删除排序数组中的重复项 II
 *
 *   一次遍历法
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 *   原理？
 *     1. 遍历数组，使用 count 统计重复元素数量
 *     2. 如果 nums[i] 与 nums[i - 1] 相等，则 count++，否则表示 nums[i] 为新元素，count = 1
 *     3. 如果 count <= 2，则移动元素，否则跳过（多余的重复元素）
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[index - 2] < nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int len1 = removeDuplicates(nums1);
        System.out.println(len1);

        System.out.println("----- 2 -----");
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int len2 = removeDuplicates1(nums2);
        System.out.println(len2);
    }
}
