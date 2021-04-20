package com.timberliu.algorithm.sort.no0347_2_topKFrequentElements.related.no0451_2_sortCharactersByFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liujie on 2021/4/20
 */

public class Solution1 {

    public static String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cntMap.put(s.charAt(i), cntMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] list = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            Integer cnt = entry.getValue();
            if (list[cnt] == null) {
                list[cnt] = new ArrayList<>();
            }
            list[cnt].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == null) {
                continue;
            }
            for (Character character : list[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(character);
                }
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
