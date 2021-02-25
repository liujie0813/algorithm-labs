package com.timberliu.algorithm.array.no0189_2_rotateArray;

import java.util.Arrays;

/**
 * 旋转数组
 *
 *   环状替换
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 *   原理？
 *     1. 将要替换的元素保存在临时变量中
 *     2. 从位置 0 开始，当前元素会被移动到 (cur + k) % n 位置处
 *     3. 再从位置 1 处开始，继续将元素移动到 (cur + k) % n 位置处
 *     4. 如此类推，直到移动元素数 等于 nums.length
 *
 * Created by liujie on 2021/2/25
 */

public class Solution3 {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        int start = 0;
        while (count < nums.length) {
            int curIndex = start;
            int curVal = nums[start];
            do {
                int nextIndex = (curIndex + k) % nums.length;
                int tmp = nums[nextIndex];
                nums[nextIndex] = curVal;

                curVal = tmp;
                curIndex = nextIndex;
                count++;
            } while (curIndex != start);
            start++;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/rotate-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        System.out.println("----- 2 -----");
        int[] nums2 = {-1,-100,3,99};
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));

        System.out.println("----- 3 -----");
        int[] nums3 = {-1};
        rotate(nums3, 2);
        System.out.println(Arrays.toString(nums3));
    }
}
