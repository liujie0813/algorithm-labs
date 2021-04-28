package com.timberliu.algorithm.hashtable.no0594_1_longestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 *
 * Created by liujie on 2021/4/26
 */

public class Solution1 {

    public static int findLHS1(int[] nums) {
        // <value，次数>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key + 1) + map.get(key));
            }
        }
        return res;
    }

    public static int findLHS2(int[] nums) {
        // <value，次数>
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            // x-1, x
            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num - 1) + map.get(num));
            }
            // x, x+1
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num + 1) + map.get(num));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-harmonious-subsequence/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findLHS1(new int[]{1,3,2,2,5,2,3,7}));

        System.out.println("----- 2 -----");
        System.out.println(findLHS1(new int[]{1,2,3,4}));

        System.out.println("----- 3 -----");
        System.out.println(findLHS1(new int[]{1,1,1,1}));

    }
}
