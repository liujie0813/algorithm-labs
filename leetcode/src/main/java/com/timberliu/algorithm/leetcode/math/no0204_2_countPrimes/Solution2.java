package com.timberliu.algorithm.leetcode.math.no0204_2_countPrimes;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 *   返回所有小于 n 的质数的数量
 *
 *   时间：一般来说，题目里 n 的规模达到 n^5 及以上时，程序的时间复杂度最高是 O(nlogn)
 */

public class Solution2 {

    /**
     * 为什么从 i*i 开始
     *   任意小于 i*i 的倍数都被之前的素数过滤过了
     *
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 从 2 枚举到 sqrt(n)
        for (int i = 2; i * i < n; i++) {
            // 如果是素数
            if (isPrime[i]) {
                // 从 i*i 开始，把 i 的所有倍数都置为 false
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.countPrimes(9));

    }

}