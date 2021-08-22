package com.timberliu.algorithm.cracking.module01.no05_2_oneEditAway;

/**
 * 面试题 01.05. 一次编辑
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        boolean firstDiff = true;
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (firstDiff) {
                    firstDiff = false;
                    if (first.length() <= second.length()) {
                        j++;
                    }
                    if (second.length() <= first.length()) {
                        i++;
                    }
                } else {
                    return false;
                }
            }
        }
        return Math.abs(first.length() - second.length()) < 2;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/one-away-lcci/ -----");
        System.out.println("----- 1 -----");
        System.out.println(oneEditAway("pale", "ple"));

        System.out.println("----- 2 -----");
        System.out.println(oneEditAway("pales", "pal"));
    }
}
