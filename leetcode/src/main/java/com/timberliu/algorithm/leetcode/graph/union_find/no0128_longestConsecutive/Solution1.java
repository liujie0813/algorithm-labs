package com.timberliu.algorithm.leetcode.graph.union_find.no0128_longestConsecutive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 *
 * 哈希表 + 并查集
 *
 * @user liujie
 * @date 2023/8/4
 */
public class Solution1 {

    static class UnionFind {
        public int[] node;
        private int[] size;
        public UnionFind(int n) {
            node = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                node[i] = i;
                size[i] = 1;
            }
        }
        // 查找，且路径压缩
        public int find(int p) {
            if (p != node[p]) {
                node[p] = find(node[p]);
            }
            return node[p];
        }
        public void union(int p, int q) {
            int first = find(p);
            int second = find(q);
            if (first != second) {
                node[first] = second;
                size[second] += size[first];
            }
        }
        public int maxConnectSize() {
            int max = 0;
            for (int i = 0; i < size.length; i++) {
                if (node[i] == i) {
                    max = Math.max(max, size[i]);
                }
            }
            return max;
        }
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            if (map.containsKey(nums[i] - 1)) {
                unionFind.union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                unionFind.union(i, map.get(nums[i] + 1));
            }
            map.put(nums[i], i);
        }
        return unionFind.maxConnectSize();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(res);
    }

}
