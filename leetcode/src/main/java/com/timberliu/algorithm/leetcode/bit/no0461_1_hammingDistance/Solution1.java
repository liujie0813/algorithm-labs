package com.timberliu.algorithm.leetcode.bit.no0461_1_hammingDistance;

/**
 * 461. 汉明距离
 *
 * Created by liujie on 2021/8/6
 */

public class Solution1 {

    public static int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 取不同的偏移位
            int a = (x >> i) & 1, b = (y >> i) & 1;
            // 异或，加 1
            res += a ^ b;
        }
        return res;
    }

    public static int hammingDistance1(int x, int y) {
        int res = 0;
        while ((x | y) != 0) {
            // 取最后一位
            int a = x & 1, b = y & 1;
            // 异或，加 1
            res += a ^ b;
            // x，y 右移一位
            x >>= 1;
            y >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/hamming-distance/ -----");
        System.out.println("----- 1 -----");
        System.out.println(hammingDistance(1, 4));

        System.out.println("----- 2 -----");
        System.out.println(hammingDistance1(3, 1));

    }
}
