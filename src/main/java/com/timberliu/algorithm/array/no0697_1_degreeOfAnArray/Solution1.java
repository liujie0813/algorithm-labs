package com.timberliu.algorithm.array.no0697_1_degreeOfAnArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 *
 *   原理？
 *     1. 使用 HashMap，每个元素 nums 对应一个数组，{出现次数，首次出现位置，最后一次出现位置}
 *     2. 遍历 HashMap，统计值
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static int findShortestSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxCount = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (value[0] > maxCount) {
                maxCount = value[0];
                minLen = value[2] - value[1] + 1;
            } if (value[0] == maxCount) {
                if (value[2] - value[1] + 1 < minLen) {
                    minLen = value[2] - value[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/degree-of-an-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums1 = {1, 2, 2, 3, 1};
        int shortestSubArray1 = findShortestSubArray(nums1);
        System.out.println(shortestSubArray1);

        System.out.println("----- 1 -----");
        int[] nums2 = {1,2,2,3,1,4,2};
        int shortestSubArray2 = findShortestSubArray(nums2);
        System.out.println(shortestSubArray2);
    }
}
