package com.timberliu.algorithm.leetcode.string.no0165_compareVersion;

/**
 * 165. 比较版本号
 *
 * @user liujie
 * @date 2023/8/17
 */
public class Solution1 {

    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        int i = 0, j = 0;
        while (i < first.length || j < second.length) {
            int a = 0, b = 0;
            if (i < first.length) {
                a = Integer.parseInt(first[i++]);
            }
            if (j < second.length) {
                b = Integer.parseInt(second[j++]);
            }
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.compareVersion("1.01", "1.001");
        System.out.println(res);
    }

}
