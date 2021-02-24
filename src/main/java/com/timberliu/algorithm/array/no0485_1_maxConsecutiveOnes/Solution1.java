package com.timberliu.algorithm.array.no0485_1_maxConsecutiveOnes;

/**
 * 最大连续 1 的个数
 *
 *   一次遍历
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxRes = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > maxRes) {
                maxRes = count;
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/max-consecutive-ones/ -----");
        System.out.println("----- 1 -----");
        int[] nums = {1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);

    }
}
