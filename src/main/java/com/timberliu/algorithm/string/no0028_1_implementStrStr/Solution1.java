package com.timberliu.algorithm.string.no0028_1_implementStrStr;

/**
 * 实现 strStr()
 *
 *   时间复杂度：O((m-n)*n)
 *   空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = i;
            int index = 0;
            while (haystack.charAt(j) == needle.charAt(index)) {
                j++;
                index++;
                if (index == needle.length()) {
                    return i;
                }
                if (j == haystack.length()) {
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/implement-strstr/ -----");
        System.out.println("----- 1 -----");
        String haystask1 = "hello", needle1 = "ll";
        int i1 = strStr(haystask1, needle1);
        System.out.println(i1);

        System.out.println("----- 2 -----");
        String haystask2 = "aaaaa", needle2 = "bba";
        int i2 = strStr(haystask2, needle2);
        System.out.println(i2);

        System.out.println("----- 3 -----");
        String haystask3 = "", needle3 = "bba";
        int i3 = strStr(haystask3, needle3);
        System.out.println(i3);

        System.out.println("----- 4 -----");
        String haystask4 = "haha", needle4 = "";
        int i4 = strStr(haystask4, needle4);
        System.out.println(i4);

    }
}
