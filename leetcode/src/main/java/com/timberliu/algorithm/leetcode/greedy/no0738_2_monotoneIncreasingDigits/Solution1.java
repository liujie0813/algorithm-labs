package com.timberliu.algorithm.leetcode.greedy.no0738_2_monotoneIncreasingDigits;

/**
 * 738. 单调递增的数字
 *
 *  小于等于 n 的最大数字，且数字呈单调递增
 *
 *  只要 char[i-1] 大于 char[i]，则先对 char[i-1]--，然后 char[i] 及后面的数都置为 9
*/

public class Solution1 {

    public static int monotoneIncreasingDigits(int n) {
		char[] chars = String.valueOf(n).toCharArray();
		int flag = chars.length;
		for (int i = chars.length - 1; i > 0; i--) {
			if (chars[i - 1] > chars[i]) {
				chars[i - 1]--;
				flag = i;
			}
		}
		for (int i = flag; i < chars.length; i++) {
			chars[i] = '9';
		}
		return Integer.parseInt(String.valueOf(chars));
	}

    public static void main(String[] args) {
		int res1 = monotoneIncreasingDigits(332);
		System.out.println(res1);
	}

}