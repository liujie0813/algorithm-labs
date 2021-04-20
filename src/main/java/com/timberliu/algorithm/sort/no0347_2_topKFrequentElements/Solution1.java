package com.timberliu.algorithm.sort.no0347_2_topKFrequentElements;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * Created by liujie on 2021/4/19
 */

public class Solution1 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            Integer value = entry.getValue();
            if (list[value] == null) {
                list[value] = new ArrayList<>();
            }
            list[value].add(entry.getKey());
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = list.length - 1; i >= 0 && j < k; i--) {
            if (list[i] == null) {
                continue;
            }
            for (Integer num : list[i]) {
                res[j++] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/top-k-frequent-elements/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));

    }
}
