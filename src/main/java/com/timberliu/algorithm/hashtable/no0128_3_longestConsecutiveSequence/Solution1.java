package com.timberliu.algorithm.hashtable.no0128_3_longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 *  HashSet
 *
 *    1. 将所有元素添加到 set 中
 *    2. 遍历 set，如果 set 不包含 num-1，也就是当前元素是序列的第一个元素时
 *                则循环查找下一个元素，同时计算序列长度
 *                与最长的长度比较
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer num : set) {
            // num 是当前序列的第一个元素
            if (!set.contains(num - 1)) {
                // 以 num 为开头，计算当前序列的长度
                int curNum = num;
                int cur = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    cur++;
                }
                longest = Math.max(longest, cur);
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
