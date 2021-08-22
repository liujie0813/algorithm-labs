package com.timberliu.algorithm.cracking.module16.no15_1_masterMind;

import java.util.*;

/**
 * 面试题 16.15. 珠玑妙算
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public static int[] masterMind(String solution, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < solution.length(); i++) {
            map.put(solution.charAt(i), map.getOrDefault(solution.charAt(i), 0) + 1);
        }
        // real 猜中次数
        // fake 总次数
        int real = 0, fake = 0;
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                real++;
            }
            if (map.getOrDefault(guess.charAt(i), 0) > 0) {
                fake++;
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
            }
        }
        return new int[]{real, fake - real};
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/master-mind-lcci/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(masterMind("RGBY", "GGRR")));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(masterMind("GGGBY", "GRGYR")));

    }
}
