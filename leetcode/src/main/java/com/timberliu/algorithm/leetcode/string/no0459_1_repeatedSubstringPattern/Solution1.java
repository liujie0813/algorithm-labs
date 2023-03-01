package com.timberliu.algorithm.leetcode.string.no0459_1_repeatedSubstringPattern;

/**
 * 459. 重复的子字符串
 *
 *  双层 for 循环
 *    1. 外层循环 遍历重复子串可能的结束位置（从 0 到 n/2）
 *    2. 内层循环遍历判断是否是重复的
 *    	双指针，一个指向子串，一个指向本串，指针到达子串末尾时，再转回开头
 *
 * Created by liujie on 2023/3/1
 */

public class Solution1 {

    public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		for (int end = 0; end < n / 2; end++) {
			int i = 0;
			int j = end + 1;
			while (j < n) {
				if (s.charAt(i) != s.charAt(j)) {
					break;
				}
				i++;
				j++;
				if (i == end + 1) {
					i = 0;
				}
			}
			if (i == 0 && j == n) {
				return true;
			}
		}
		return false;
    }

    public static void main(String[] args) {
		boolean res1 = repeatedSubstringPattern("abcabc");
		System.out.println(res1);

		boolean res2 = repeatedSubstringPattern("aa");
		System.out.println(res2);

		boolean res3 = repeatedSubstringPattern("abcabca");
		System.out.println(res3);
	}

}