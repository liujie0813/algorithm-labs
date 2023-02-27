package com.timberliu.algorithm.leetcode.string.no0344_1_reverseString;

/**
 * 344. 反转字符串
 *
 *  双指针
 *    一个指向开头，一个指向末尾，两个指针同时往中间移动，交换元素
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/reverse-string/ -----");
        System.out.println("----- 1 -----");
        char[] s1 = {'h','e','l','l','o'};
        reverseString(s1);
        System.out.println(s1);

        System.out.println("----- 2 -----");
        char[] s2 = {'H','a','n','n','a','h'};
        reverseString(s2);
        System.out.println(s2);

    }
}
