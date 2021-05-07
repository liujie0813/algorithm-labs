package com.timberliu.algorithm.tree.no0112_1_pathSum.related.no0666_2_pathSum4;

import java.util.HashMap;
import java.util.Map;

/**
 * 666. 路径总和 IIII
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    public static int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        int[] res = new int[1];
        dfs(nums[0] / 10, 0, map, res);
        return res[0];
    }

    private static void dfs(int node, int curSum, Map<Integer, Integer> map, int[] res) {
        if (!map.containsKey(node)) {
            return;
        }
        curSum += map.get(node);
        int depth = node / 10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            res[0] += curSum;
        } else {
            dfs(left, curSum, map, res);
            dfs(right, curSum, map, res);
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/path-sum-iv/ -----");
        System.out.println("----- 1 -----");
        System.out.println(pathSum(new int[]{113, 215, 221}));

        System.out.println("----- 2 -----");
        System.out.println(pathSum(new int[]{113, 221}));

    }
}
