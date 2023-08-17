package com.timberliu.algorithm.leetcode.string.no0030_findSubString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 *
 * @user liujie
 * @date 2023/8/17
 */
public class Solution1 {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int n = s.length(), m = words.length, w = words[0].length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            Map<String, Integer> temp = new HashMap<>();
            // 窗口大小为 m*w
            for (int j = i; j + w <= n; j += w) {
                // right加入
                String right = s.substring(j, j + w);
                temp.put(right, temp.getOrDefault(right, 0) + 1);
                // left移出
                if (j >= i + m * w) {
                    int idx = j - m * w;
                    String left = s.substring(idx, idx + w);
                    if (temp.get(left) == 1) {
                        temp.remove(left);
                    } else {
                        temp.put(left, temp.getOrDefault(left, 0) - 1);
                    }
                    // 剪枝
                    if (!map.getOrDefault(left, 0).equals(temp.getOrDefault(left, 0))) {
                        continue;
                    }
                }
                // 剪枝
                if (!map.getOrDefault(right, 0).equals(temp.getOrDefault(right, 0))) {
                    continue;
                }
                if (map.equals(temp)) {
                    res.add(j - (m - 1) * w);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
