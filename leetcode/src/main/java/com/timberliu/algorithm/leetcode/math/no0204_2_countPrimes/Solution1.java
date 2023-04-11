package com.timberliu.algorithm.leetcode.math.no0204_2_countPrimes;

/**
 * 204. 计数质数
 *
 *   返回所有小于 n 的质数的数量
 *
 *   时间：一般来说，题目里 n 的规模达到 n^5 及以上时，程序的时间复杂度最高是 O(nlogn)
 */

public class Solution1 {

    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.countPrimes(9));

    }

}