package com.timberliu.algorithm.string.no0242_1_validAnagram.related.no0049_2_groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] tmp = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                tmp[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tmp[j] != 0) {
                    key.append((char) (j + 'a'));
                    key.append(tmp[j]);
                }
            }

            List<String> strings = strMap.get(key.toString());
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(strs[i]);
            strMap.put(key.toString(), strings);
        }

        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/group-anagrams/ -----");
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);

    }
}
