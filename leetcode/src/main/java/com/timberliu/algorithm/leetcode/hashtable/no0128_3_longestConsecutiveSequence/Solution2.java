package com.timberliu.algorithm.leetcode.hashtable.no0128_3_longestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 *   DP
 *
 *     单次遍历
 *     1.
 *
 * Created by liujie on 2021/4/28
 */

public class Solution2 {

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int curLength = 1 + left + right;
                if (curLength > longest) {
                    longest = curLength;
                }
                map.put(num, curLength);
                // num -> 该元素所在序列的长度
                // 更新当前序列两端的值即可
                map.put(num - left, curLength);
                map.put(num + right, curLength);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-consecutive-sequence/ -----");
        System.out.println("----- 1 -----");
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));

        System.out.println("----- 2 -----");
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));

    }

}
