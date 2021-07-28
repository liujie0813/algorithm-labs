package com.timberliu.algorithm.leetcode.sort.no0347_2_topKFrequentElements;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * Created by liujie on 2021/4/19
 */

public class Solution2 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        // 小顶堆
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(cntMap::get));
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else if (entry.getValue() > cntMap.get(queue.peek())) {
                queue.poll();
                queue.add(entry.getKey());
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
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
