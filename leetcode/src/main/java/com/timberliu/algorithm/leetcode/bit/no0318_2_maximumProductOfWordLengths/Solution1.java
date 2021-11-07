package com.timberliu.algorithm.leetcode.bit.no0318_2_maximumProductOfWordLengths;

/**
 * 318. 最大单词长度乘积
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public int maxProduct(String[] words) {
		// bits 存放单词出现过的字母
		int[] bits = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				int index = c - 'a';
				bits[i] = bits[i] | (1 << index);
			}
		}
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				// 按位与结果为 0，即不含有公共字母
				if ((bits[i] & bits[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/maximum-product-of-word-lengths/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.maxProduct(new String[]{"a","aa","aaa","aaaa"}));

	}

}
