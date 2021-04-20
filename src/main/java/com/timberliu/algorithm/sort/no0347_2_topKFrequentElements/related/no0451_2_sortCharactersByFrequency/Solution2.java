package com.timberliu.algorithm.sort.no0347_2_topKFrequentElements.related.no0451_2_sortCharactersByFrequency;

import java.util.*;

/**
 * Created by liujie on 2021/4/20
 */

public class Solution2 {

    public static String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cntMap.put(s.charAt(i), cntMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Queue<Character> queue = new PriorityQueue<>((a, b) -> cntMap.get(b) - cntMap.get(a));
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            queue.add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            Integer num = cntMap.get(ch);
            for (int i = 0; i < num; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sort-characters-by-frequency/ -----");
        System.out.println("----- 1 -----");
        System.out.println(frequencySort("tree"));

        System.out.println("----- 2 -----");
        System.out.println(frequencySort("cccaaa"));

        System.out.println("----- 3 -----");
        System.out.println(frequencySort("Aabb"));

    }
}
