package com.timberliu.algorithm.leetcode.string.no0003_2_longestSubstringWithoutRepeatingCharacters.related.no0395_2_longestSubstring;

/**
 * 395. 至少有 K 个重复字符的最长子串
 *
 *  统计次数小于 k 的字符 a
 *    最终结果中一定不含 k
 *  以 a 字符分割子串，进行分治
 *
 * @author liujie
 * @date 2024/6/6
 */

public class Solution1 {

	public int longestSubstring(String s, int k) {
		return longestSubstring(s, 0, s.length() - 1, k);
	}

	private int longestSubstring(String s, int left, int right, int k) {
		// 统计区间内各个字符的次数
		int[] cnt = new int[26];
		for (int i = left; i <= right; i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		// 找到次数小于 k 的字符
		char split = 0;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] > 0 && cnt[i] < k) {
				split = (char) (i + 'a');
				break;
			}
		}
		if (split == 0) {
			return right - left + 1;
		}
		// 以 split 进行分割
		int index = left;
		int res = 0;
		while (index <= right) {
			while (index <= right && s.charAt(index) == split) {
				index++;
			}
			if (index > right) {
				break;
			}
			int start = index;
			while (index <= right && s.charAt(index) != split) {
				index++;
			}
			// 递归子串
			int len = longestSubstring(s, start, index - 1, k);
			res = Math.max(res, len);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int res = solution1.longestSubstring("ababbc", 2);
		System.out.println(res);
	}

}
