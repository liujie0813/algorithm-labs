package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0454_2_4sumCount;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 *
 *   双哈希表
 *     时间复杂度：O(n^2)
 *     空间复杂度：O(n^2) 最坏情况下，A[i] 和 B[j] 全不相同
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int tmp = 0;
        for (int a : A) {
            for (int b : B) {
                tmp = a + b;
                sumCountMap.put(tmp, sumCountMap.getOrDefault(tmp, 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                tmp = c + d;
                count += sumCountMap.getOrDefault(-tmp, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/4sum-ii/ -----");
        System.out.println("----- 1 -----");
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        int fourSumCount = fourSumCount(A, B, C, D);
        System.out.println(fourSumCount);

    }
}
