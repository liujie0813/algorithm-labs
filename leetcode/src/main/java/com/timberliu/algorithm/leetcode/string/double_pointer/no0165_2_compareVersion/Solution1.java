package com.timberliu.algorithm.leetcode.string.double_pointer.no0165_2_compareVersion;

/**
 * 165. 比较版本号
 *
 * @author liujie
 * @date 2024/9/19
 */

public class Solution1 {

	public int compareVersion(String version1, String version2) {
		int[] i = new int[1];
		int[] j = new int[1];
		while (i[0] < version1.length() || j[0] < version2.length()) {
			ignoreZero(version1, i);
			int val1 = getVal(version1, i);
			ignoreZero(version2, j);
			int val2 = getVal(version2, j);
			if (val1 < val2) {
				return -1;
			} else if (val1 > val2) {
				return 1;
			}
			i[0]++;
			j[0]++;
		}
		return 0;
	}

	private void ignoreZero(String str, int[] index) {
		while (index[0] < str.length() && str.charAt(index[0]) == '0') {
			index[0]++;
		}
	}

	private int getVal(String str, int[] index) {
		int val = 0;
		while (index[0] < str.length() && str.charAt(index[0]) != '.') {
			int num = str.charAt(index[0]) - '0';
			val = val * 10 + num;
			index[0]++;
		}
		return val;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.compareVersion("1.2", "1.10"));

	}

}
